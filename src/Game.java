import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Terminal terminal;
    private Render render;
    private Move move;

    private Map map;
    private Player player;

    private List<Enemy> enemies;
    private int numberOfEnemies = 4;

    private int scoreCount = 0;

    //Constructor
    public Game() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminalSettings();
        render = new Render();
    }

    //Starts a new game
    public void newGame() {
        map = new Map();
        player = new Player();
        enemies = new ArrayList<>();
        addEnemies();
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
        for (Enemy enemy : enemies) {
            if (player.getPosition() == enemy.getPosition()) {
                return true;
            }
        }
        return false;
    }

    //Method that checks if an enemy is hit by ammo and kills it
    public void enemyHitByAmmo() {
        for (Enemy enemy : enemies) {
            for (Ammo ammo : player.weapon.shotsFired) {
                if (enemy.getPosition() == ammo.getPosition()) {
                    enemies.remove(enemy);
                    player.weapon.shotsFired.remove(ammo);
                }
            }
        }
    }

    //Method that checks if ammo hits wall, then removes it
    public void ammoHitsWall(){
        for(Ammo ammo:player.weapon.shotsFired){
            if(map.gameBoard[ammo.getPosition().getPositionX()][ammo.getPosition().getPositionY()] == 1){
                player.weapon.shotsFired.remove(ammo);
            }
        }
    }


    //Method that returns the score count ie number of enemies shot
    public int getScoreCount() {
        return scoreCount;
    }

    //Method that updates the score count, called when an enemy is shot
    public void setScoreCount(int scoreCount) {
        this.scoreCount = scoreCount;
    }


}
