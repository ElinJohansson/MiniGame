import com.googlecode.lanterna.terminal.Terminal;

public class Render {

    Terminal terminal;

    public void updateMap(Game game) {
        game.terminal.clearScreen();
        printGameBoard(game.terminal, game.map);
        printScoreBoard(game.terminal, game.map);
        printPlayer(game.terminal, game.map, game.player);
        printEnemy();
        printWeapon();
        printAmmo();
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
    public void printPlayer(Terminal terminal, Map map, Player player) {
        
    }

    //Prints the enemies list
    public void printEnemy() {

    }

    //Prints the weapon position
    public void printWeapon() {

    }

    //Prints the ammo list
    public void printAmmo() {

    }
}
