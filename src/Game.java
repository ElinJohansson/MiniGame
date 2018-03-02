import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.*;

public class Game {

    public Terminal terminal;
    public Render render;
    public PlayerActions playerActions;
    public Map map;
    public Player player;
    public GameLoopCounter gameLoopCounter;

    private List<Enemy> enemies;
    private int numberOfEnemies = 5;

    private List<Color> colors;

    private int scoreCount = 0;

    //Constructor
    public Game() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminalSettings();
        render = new Render();
        playerActions = new PlayerActions();
        gameLoopCounter = new GameLoopCounter();
        colors = new ArrayList<>();
        addColors();

    }

    //Starts a new game
    public void newGame() {
        map = new Map();
        player = new Player();
        enemies = new ArrayList<>();
        addEnemiesToList();
        render.updateMap(terminal, player, enemies, map);
        printMonsterKillScore();
        printPlayerHealth();
        printLevel();
    }

    public void gameTurn() {
        render.updateMap(terminal, player, enemies, map);
    }

    //Terminal settings
    private void terminalSettings() {
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(0, 34, 51);  //Bakgrundsfärg
        terminal.setCursorVisible(false);
    }

    //Adds enemies to enemy list if not already on enemy position, enemies are added in newGame() all at once
    public void addEnemiesToList() {
        List<Integer> availableYPositions = new ArrayList<>();

        for (int y = 1; y < map.getScoreBoardHeight() - 1; y++) {
            availableYPositions.add(y);
        }
        Collections.shuffle(availableYPositions);
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new Enemy((map.getGameBoardWidth() - 2), availableYPositions.get(i)));
        }
        if (numberOfEnemies <= 20) {
            numberOfEnemies += 5;
        }
    }


    //Game over condition if enemies stand on top of player or hits the left wall
    public boolean gameOver() {
        for (Enemy enemy : enemies) {
            if ((enemy.getPosition().getPositionX() == player.getPosition().getPositionX() &&
                    enemy.getPosition().getPositionY() == player.getPosition().getPositionY()) ||
                    !isPlayerAlive()) {
                render.printText(terminal, "LORD ZOD´S RAINBOW MINIONS ARE VICTORIOUS", 10, 10, 255, 0, 0);
                return true;
            }
        }
        return false;
    }

    //Method that checks if player health is at or below zero
    public boolean isPlayerAlive() {
        if (player.getHealth() <= 0) {
            return false;
        }
        return true;
    }

    //Method that reduces the health of player if an enemy hits the left wall
    public void reducePlayerHealth() {
        player.setHealth(player.getHealth() - 1);

    }

    //Method that checks if an enemy is hit by ammo and kills it
    public void enemyHitByAmmo() {
        List<Enemy> tempEnemies = new ArrayList<>();
        List<Ammo> tempAmmo = new ArrayList<>();
        for (Enemy enemy : enemies) {
            for (Ammo ammo : player.getWeapon().getShotsFired()) {
                if (enemy.getPosition().getPositionX() == ammo.getPosition().getPositionX() &&
                        enemy.getPosition().getPositionY() == ammo.getPosition().getPositionY()) {
                    terminal.moveCursor(enemy.getPosition().getPositionX(), enemy.getPosition().getPositionY()); //Erase the ammo and enemy from the board
                    terminal.putCharacter(' ');
                    tempEnemies.add(enemy); //Adds current enemy and ammo to temporary list
                    tempAmmo.add(ammo);
                    setScoreCount(1); //Adds +1 to scoreCount when an enemy is killed
                    printMonsterKillScore();
                }
            }
        }
        enemies.removeAll(tempEnemies);
        player.getWeapon().getShotsFired().removeAll(tempAmmo);
        tempEnemies.clear();
        tempAmmo.clear();
    }

    //Prints monster kill score
    public void printMonsterKillScore() {
        render.printText(terminal, "Monsters killed: " + getScoreCount(), 70, 6, 255, 255, 0);
    }

    //Prints player health left
    public void printPlayerHealth() {
        render.printText(terminal, "Health left: " + "  ", 70, 7, 255, 255, 0);
        render.printText(terminal, "Health left: " + player.getHealth(), 70, 7, 255, 255, 0);
    }

    //Prints current level
    public void printLevel() {
        render.printText(terminal, "Level: " + "  ", 70, 7, 255, 255, 0);
        render.printText(terminal, "Level: " + (gameLoopCounter.getLevelCounter() + 1), 70, 5, 255, 255, 0);

    }


    //Method that checks if ammo hits wall, then removes it
    public void ammoHitsWall() {
        List<Ammo> tempAmmo = new ArrayList<>();
        for (Ammo ammo : player.getWeapon().getShotsFired()) {
            if (ammo.getPosition().getPositionX() == map.getGameBoardWidth() - 1) {
                terminal.moveCursor(ammo.getPosition().getPositionX(), ammo.getPosition().getPositionY());
                terminal.applyForegroundColor(18, 65, 89); //Deletes the ammo from the border. border color
                terminal.putCharacter('\u2588');
                tempAmmo.add(ammo);
            }
        }
        player.getWeapon().getShotsFired().removeAll(tempAmmo);
    }

    //Method that updates the score count, called when an enemy is shot
    public void setScoreCount(int scoreCount) {
        this.scoreCount = this.scoreCount + scoreCount;
    }

    //Method that returns the score count ie number of enemies shot
    public int getScoreCount() {
        return scoreCount;
    }

    //Method that loops over the enemies' list and moves them
    public void moveEnemies() {

        Random rand = new Random();

        List<Enemy> enemiesToKill = new ArrayList<>();
        for (Enemy enemy : enemies) {


            //Variables that are used to erase the enemy characters in the terminal
            int oldX = enemy.getPosition().getPositionX();
            int oldY = enemy.getPosition().getPositionY();
            enemy.getPosition().setPositionX(oldX - 1); //Moves the enemies to the left

            //Erases the old enemy position
            terminal.applyForegroundColor(0, 0, 0);
            terminal.moveCursor(oldX, oldY);
            terminal.putCharacter(' ');
            //Prints the new enemy position to the terminal

            int randomColor = rand.nextInt(7); //Randomise a color

            terminal.applyForegroundColor(colors.get(randomColor).getRed(), colors.get(randomColor).getBlue(), colors.get(randomColor).getYellow()); //enemy color
            terminal.moveCursor(enemy.getPosition().getPositionX(), enemy.getPosition().getPositionY());
            terminal.putCharacter(enemy.getEnemyFace());

            //If enemy hits left wall
            if (enemy.getPosition().getPositionX() == 0) {
                reducePlayerHealth();


                terminal.applyForegroundColor(18, 65, 89); //Border color
                terminal.moveCursor(enemy.getPosition().getPositionX(), enemy.getPosition().getPositionY());
                terminal.putCharacter('\u2588');
                enemiesToKill.add(enemy);
            }
        }

        printPlayerHealth();
        enemies.removeAll(enemiesToKill);
        enemiesToKill.clear();
    }

    public void addColors() {
        colors.add(new Color(255, 0, 102)); //rosa
        colors.add(new Color(0, 153, 255)); //blå
        colors.add(new Color(0, 255, 0)); //grön
        colors.add(new Color(255, 255, 102)); //gul
        colors.add(new Color(204, 153, 255)); //ljuslila
        colors.add(new Color(255, 83, 26)); //orange
        colors.add(new Color(107, 0, 179)); //mörklila
    }


    //Moves and prints the ammo
    public void movesAllAmmoAndPrintsTheNewPositions() {
        for (Ammo a : player.getWeapon().getShotsFired()) {
            int tempX = a.getPosition().getPositionX(); //Stores the old positions
            int tempY = a.getPosition().getPositionY();
            terminal.moveCursor(tempX, tempY); //Erases the old position
            terminal.putCharacter(' ');
            a.moveAmmo(); //Moves the current ammo
            terminal.moveCursor(a.getPosition().getPositionX(), a.getPosition().getPositionY()); //Prints to the terminal
            terminal.applyForegroundColor(255, 255, 0); //Ammo color
            terminal.putCharacter(a.getShot());

        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
