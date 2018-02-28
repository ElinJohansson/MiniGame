import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

public class Render {

    Terminal terminal;

    //Updates the map in the terminal
    public void updateMap(Game game) {
        game.terminal.clearScreen();
        printGameBoard(game.terminal, game.map);
        printScoreBoard(game.terminal, game.map);
        printPlayer(game.terminal, game.player);
        printEnemy(game.terminal, game.monsters);
        printWeapon(game.terminal, game.player.weapon);
        printAmmo(game.terminal, game.player.weapon.shotsFired);
    }

    //Prints the game board
    public void printGameBoard(Terminal terminal, Map map) {
        for (int x = 0; x < map.gameBoard.length; x++) {
            for (int y = 0; y < map.gameBoard[x].length; y++) {
                terminal.moveCursor(x, y);
                if (map.gameBoard[x][y] == 0) { //Floor
                    terminal.applyForegroundColor(189, 60, 40);
                    terminal.putCharacter(' ');
                } else if (map.gameBoard[x][y] == 1) { //Border
                    terminal.applyForegroundColor(100, 30, 15);
                    terminal.putCharacter('\u2588');
                }
            }
        }
    }

    //Prints the score board
    public void printScoreBoard(Terminal terminal, Map map) {
        for (int x = 0; x < map.scoreBoard.length; x++) {
            for (int y = 0; y < map.scoreBoard[x].length; y++) {
                terminal.moveCursor(x, y);
                if (map.scoreBoard[x][y] == 0) { //Floor
                    terminal.applyForegroundColor(189, 60, 40);
                    terminal.putCharacter(' ');
                } else if (map.scoreBoard[x][y] == 1) { //Border
                    terminal.applyForegroundColor(100, 30, 15);
                    terminal.putCharacter('\u2588');
                }
            }
        }
    }

    //Prints the player position
    public void printPlayer(Terminal terminal, Player player) {
        terminal.applyForegroundColor(255, 255, 0);
        terminal.moveCursor(player.getPosition().getPositionX(), player.getPosition().getPositionY());
        terminal.putCharacter(player.heMan);
    }

    //Prints the enemies list
    public void printEnemy() {

    }

    //Prints the weapon position
    public void printWeapon(Terminal terminal, Weapon weapon) {
        terminal.applyForegroundColor(255, 255, 0);
        terminal.moveCursor(weapon.getPosition().getPositionX(), weapon.getPosition().getPositionY());
        terminal.putCharacter(weapon.getRevolver()); //Weapon char
    }


    //Goes through the ammo list and prints to the terminal
    public void printAmmo(Terminal terminal, List<Ammo> shotsFired) {
        for (Ammo ammo : shotsFired) {
            terminal.applyForegroundColor(255, 255, 0);
            terminal.moveCursor(ammo.getPosition().getPositionX(), ammo.getPosition().getPositionY()); //Gets the ammo position
            terminal.putCharacter(ammo.getShot()); //Ammo char
        }
    }
}
