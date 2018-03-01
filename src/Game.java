import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public Terminal terminal;
    public Render render;
    public Move move;
    public Map map;
    public Player player;

    private List<Enemy> enemies;
    private int numberOfEnemies = 10;

    private int scoreCount = 0;

    //Constructor
    public Game() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminalSettings();
        render = new Render();
        move = new Move();
    }

    //Starts a new game
    public void newGame() {
        map = new Map();
        player = new Player();
        enemies = new ArrayList<>();
        addEnemiesToList();
        render.updateMap(terminal, player, enemies, map);
    }

    public void gameTurn() {
        render.updateMap(terminal, player, enemies, map);
    }

    //Terminal settings
    private void terminalSettings() {
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(145, 60, 57);  //Bakgrundsfärg
        terminal.setCursorVisible(false);
    }

    //Adds enemies to enemy list, enemies are added in newGame() all at once
    public void addEnemiesToList() {
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new Enemy());
        }
    }

    //Game over condition if enemies stand on top of player
    public boolean gameOver() {
        for (Enemy enemy : enemies) {
            if (enemy.getPosition().getPositionX() == player.getPosition().getPositionX() &&
                    enemy.getPosition().getPositionY() == player.getPosition().getPositionY()) {
                return true;
            }
        }
        return false;
    }

    //Method that checks if an enemy is hit by ammo and kills it
    public void enemyHitByAmmo() {
        List<Enemy> tempEnemies = new ArrayList<>();
        List<Ammo> tempAmmo = new ArrayList<>();
        for (Enemy enemy : enemies) {
            for (Ammo ammo : player.weapon.shotsFired) {
                if (enemy.getPosition().getPositionX() == ammo.getPosition().getPositionX() &&
                        enemy.getPosition().getPositionY() == ammo.getPosition().getPositionY()) {
                    terminal.moveCursor(enemy.getPosition().getPositionX(), enemy.getPosition().getPositionY()); //Erase the ammo and enemy from the board
                    terminal.putCharacter(' ');
                    tempEnemies.add(enemy); //Adds current enemy and ammo to temporary list
                    tempAmmo.add(ammo);
                    setScoreCount(1); //Adds +1 to scoreCount when an enemy is killed
                }
            }
        }
        enemies.removeAll(tempEnemies);
        player.weapon.shotsFired.removeAll(tempAmmo);
    }

    //Method that checks if ammo hits wall, then removes it
    public void ammoHitsWall() {
        List<Ammo> tempAmmo = new ArrayList<>();
        for (Ammo ammo : player.weapon.shotsFired) {
            if (ammo.getPosition().getPositionX() == map.getGameBoardWidth() - 1) {
                terminal.moveCursor(ammo.getPosition().getPositionX(), ammo.getPosition().getPositionY());
                terminal.applyForegroundColor(100, 30, 15); //Deletes the ammo from the border
                terminal.putCharacter('\u2588');
                tempAmmo.add(ammo);
            }
        }
        player.weapon.shotsFired.removeAll(tempAmmo);
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

        for (Enemy enemy : enemies) {
            //Get enemy position and store in temp values
            int enemyTempX = enemy.getPosition().getPositionX();
            int enemyTempY = enemy.getPosition().getPositionY();

            //Variables that are used to erase the enemy characters in the terminal
            int oldX = enemyTempX;
            int oldY = enemyTempY;

            Position oldPosition = new Position(oldX, oldY);

            if (enemy.getPosition().getPositionX() > player.getPosition().getPositionX()) {
                enemyTempX--; //ie enemy moves left
            }
            if (enemy.getPosition().getPositionX() < player.getPosition().getPositionX()) {
                enemyTempX++; //ie enemy moves right
            }
            if (enemy.getPosition().getPositionY() > player.getPosition().getPositionY()) {
                enemyTempY--; //ie enemy moves up
            }
            if (enemy.getPosition().getPositionY() < player.getPosition().getPositionX()) {
                enemyTempY++; //ie enemy moves down
            }

            //Sets the new enemy position
            Position newPosition = new Position(enemyTempX, enemyTempY);
            enemy.setPosition(newPosition);

            //Erases the old enemy position
            terminal.applyForegroundColor(0, 0, 0);
            terminal.moveCursor(oldX, oldY);
            terminal.putCharacter(' ');
            //Prints the new enemy position to the terminal
            terminal.applyForegroundColor(0, 0, 0);
            terminal.moveCursor(enemy.getPosition().getPositionX(), enemy.getPosition().getPositionY());
            terminal.putCharacter(enemy.getEnemyFace());
        }
    }

    //Checks if any enemy stands ontop of another enemy
    public boolean isEnemyOnEnemy() {
        Set<String> enemyPositionString = new HashSet<>();
        for (int i = 0; i < enemies.size(); i++) {
            String s = "x:" + enemies.get(i).getPosition().getPositionX() + "y:" + enemies.get(i).getPosition().getPositionY();
            if (enemyPositionString.contains(s)) {
                System.out.println("This monster is on another monster");
                return true; //The enemy is alerady in the hashset
            }
            enemyPositionString.add(s); //Else adds the string to the hashset
        }
        return false;
    }

    //Prints ammos to the terminal
    public void printAmmo() {
        for (Ammo a : player.weapon.shotsFired) {
            terminal.moveCursor(a.getPosition().getPositionX(), a.getPosition().getPositionY());
            terminal.putCharacter(a.getShot());
        }
    }

    //Moves the ammo
    public void movesAllAmmoAndPrintsTheNewPositions() {
        for (Ammo a : player.weapon.shotsFired) {
            int tempX = a.getPosition().getPositionX(); //Stores the old positions
            int tempY = a.getPosition().getPositionY();
            terminal.moveCursor(tempX, tempY); //Erases the old position
            terminal.putCharacter(' ');
            a.moveAmmo(); //Moves the current ammo
            terminal.moveCursor(a.getPosition().getPositionX(), a.getPosition().getPositionY()); //Prints to the terminal
            terminal.putCharacter(a.getShot());
        }
    }





}
