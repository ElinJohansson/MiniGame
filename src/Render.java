import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

public class Render {

     //Updates the map in the terminal
    public void updateMap(Terminal terminal, Player player, List<Enemy> enemies, Map map) {
        terminal.clearScreen();
        printGameBoard(terminal, map);
        printScoreBoard(terminal, map);
        printGameTitle(terminal);
        printPlayer(terminal, player);
        printWeapon(terminal, player.getWeapon());
    }

    //Prints the game board
    public void printGameBoard(Terminal terminal, Map map) {
        for (int x = 0; x < map.getGameBoardWidth(); x++) {
            for (int y = 0; y < map.getGameBoardHeight(); y++) {
                terminal.moveCursor(x, y);
                if (map.gameBoard[x][y] == map.getFloor()) {
                    terminal.applyForegroundColor(0,0,0);
                    terminal.putCharacter(' ');
                } else if (map.gameBoard[x][y] == map.getBorder()) { //Border
                    terminal.applyForegroundColor(18,65,89); //Border color
                    terminal.putCharacter('\u2588'); //Block character
                }
            }
        }
    }

    //Prints the score board
    public void printScoreBoard(Terminal terminal, Map map) {
        for (int x = map.getGameBoardWidth(); x < map.getScoreBoardWidth(); x++) {
            for (int y = 0; y < map.getScoreBoardHeight(); y++) {
                terminal.moveCursor(x, y);
                if (map.scoreBoard[x][y] == map.getScoreBoardTile()) { //Floor in the score board
                    terminal.applyForegroundColor(189, 60, 40);
                    terminal.putCharacter(' ');
                } else if (map.scoreBoard[x][y] == map.getBorder()) { //Border
                    terminal.applyForegroundColor(18,65,89); //Border color
                    terminal.putCharacter('\u2588'); //Block character
                }
            }
        }
    }

    //Prints the player position
    public void printPlayer(Terminal terminal, Player player) {
        terminal.applyForegroundColor(255, 255, 0);
        terminal.moveCursor(player.getPosition().getPositionX(), player.getPosition().getPositionY());
        terminal.putCharacter(player.getFace());
    }

    //Prints the weapon position
    public void printWeapon(Terminal terminal, Weapon weapon) {
        terminal.applyForegroundColor(255, 255, 0);
        terminal.moveCursor(weapon.getPosition().getPositionX(), weapon.getPosition().getPositionY());
        terminal.putCharacter(weapon.getWeaponFace()); //Weapon char
    }

    //Prints the game title
    public void printGameTitle(Terminal terminal){
        printText(terminal, "SIDE INVADERS",72,2,255,255,0);
        printText(terminal, "-Attack of the Rainbow Army-",65,3,255,255,0);
    }


    public void printText(Terminal terminal, String stringToPrint, int xPosition, int yPosition, int red, int blue, int green){
        terminal.applyForegroundColor(red, blue, green);
        for(int i = 0, x = xPosition; i < stringToPrint.length(); i++,x++){
            terminal.moveCursor(x,yPosition);
            terminal.putCharacter(stringToPrint.charAt(i));
        }
    }

    public void eraseText(Terminal terminal, String stringToPrint, int xPosition, int yPosition, int red, int blue, int green){
        terminal.applyForegroundColor(red, blue, green);
        for(int i = 0, x = xPosition; i < stringToPrint.length(); i++,x++){
            terminal.moveCursor(x,yPosition);
            terminal.putCharacter(' ');
        }
    }

}
