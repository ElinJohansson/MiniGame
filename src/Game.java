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
    private int numberOfEnemies = 5;

    private int scoreCount = 0;

    public List<Enemy> getEnemies() {
        return enemies;
    }

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
        addEnemies();
        render.updateMap(terminal, player, enemies, map);
    }

    public void gameTurn() {
        render.updateMap(terminal, player, enemies, map);
    }

    //Adds enemies to enemy list
    public void addEnemies() {
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new Enemy());
        }
    }

    //Terminal settings
    private void terminalSettings() {
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(189, 132, 40);
        terminal.setCursorVisible(false);
    }

    //Game over condition
    public boolean gameOver() {
        for(Enemy enemy : enemies){
            if(enemy.getPosition().getPositionX() == player.getPosition().getPositionX() &&
                    enemy.getPosition().getPositionY() == player.getPosition().getPositionY()){
                System.out.println("Game Over");
                return true;
            }
        }
        return false;
    }

//    //Method that checks if an enemy is hit by ammo and kills it
//    public void enemyHitByAmmo() {
//        for (Enemy enemy : enemies) {
//            for (Ammo ammo : player.weapon.shotsFired) {
//                if (enemy.getPosition() == ammo.getPosition()) {
//                    enemies.remove(enemy);
//                    player.weapon.shotsFired.remove(ammo);
//                }
//            }
//        }
//    }

//    //Method that checks if ammo hits wall, then removes it
//    public void ammoHitsWall() {
//        for (Ammo ammo : player.weapon.shotsFired) {
//            if (map.gameBoard[ammo.getPosition().getPositionX()][ammo.getPosition().getPositionY()] == 1) {
//                player.weapon.shotsFired.remove(ammo);
//            }
//        }
//    }


    //Method that returns the score count ie number of enemies shot
    public int getScoreCount() {
        return scoreCount;
    }

    //Method that updates the score count, called when an enemy is shot
    public void setScoreCount(int scoreCount) {
        this.scoreCount = scoreCount;
    }

    //Method that loops over the enemies' list and moves them
    public void moveEnemies() {

        for (Enemy mon : enemies) {
            //Hämta enemy position
            int x = mon.getPosition().getPositionX();
            int y = mon.getPosition().getPositionY();
            Position oldPosition = new Position(x, y);

            //för att användas för att sudda ut i terminalen
            int oldX = x;
            int oldY = y;

            if (mon.getPosition().getPositionX() > player.getPosition().getPositionX()) {
                x--;
            }
            if (mon.getPosition().getPositionX() < player.getPosition().getPositionX()) {
                x++;
            }
            if (mon.getPosition().getPositionY() > player.getPosition().getPositionY()) {
                y--;
            }
            if (mon.getPosition().getPositionY() < player.getPosition().getPositionX()) {
                y++;
            }
            Position newPosition = new Position(x, y);
            mon.setPosition(newPosition);
            if (isMonsterOnMonster(enemies)) {
                mon.setPosition(oldPosition);
            }

            //Uppdaterar monstrets position och suddar ut föregående
            terminal.applyForegroundColor(0, 0, 0);
            terminal.moveCursor(mon.getPosition().getPositionX(), mon.getPosition().getPositionY());
            terminal.putCharacter(mon.getEnemyFace());
            terminal.applyForegroundColor(0, 0, 0);
            terminal.moveCursor(oldX, oldY);
            terminal.putCharacter(' ');
        }
    }


    public boolean isMonsterOnMonster(List<Enemy> enemies) {
        Set<String> monsterPositionString = new HashSet<>();
        for (int i = 0; i < enemies.size(); i++) {
            String s = "";
            s = "x:" + enemies.get(i).getPosition().getPositionX() + "y:" + enemies.get(i).getPosition().getPositionY();
            if (monsterPositionString.contains(s)) {
                return true;
            }
            monsterPositionString.add(s);
        }
        return false;
    }


}
