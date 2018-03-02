import com.googlecode.lanterna.input.Key;

public class PlayerActions {

    public void checkKeyInputAndMovesPlayerOrShoot(Game game) throws InterruptedException {

        //Keylistener
        Key key;
        key = game.terminal.readInput();
        if (key == null) return; //Quits the method if there is no key input

        //Gets the player position and adds it to a temp new position
        int oldPlayerX = game.player.getPosition().getPositionX();
        int oldPlayerY = game.player.getPosition().getPositionY();
        Position oldPosition = game.player.getPosition();

        //The new position
        Position newPosition = new Position(oldPlayerX, oldPlayerY);

        //Gets the weapon position and adds it to a temp old position
        int oldWeaponX = game.player.getWeapon().getPosition().getPositionX();
        int oldWeaponY = game.player.getWeapon().getPosition().getPositionY();

        //Checks and switches on key pressed
        switch (key.getKind()) {
            case ArrowDown:
                playerMoveDown(game, oldPosition, newPosition, oldPlayerY + 1, Direction.down);
                break;
            case ArrowUp:
                playerMoveUp(game, oldPosition, newPosition, oldPlayerY - 1, Direction.up);
                break;
            case ArrowLeft:
                moveLeft(game, oldPosition, newPosition, oldPlayerX - 1, Direction.left);
                break;
            case ArrowRight:
                playerMoveRight(game, oldPosition, newPosition, oldPlayerX + 1, Direction.right);
                break;
            case Tab:
                game.player.getWeapon().shoot();
                break;
            case NormalKey:
                break;
            default:
                break;

        }
        updatePlayerAndWeaponOnTerminal(game, oldPlayerX, oldPlayerY, oldWeaponX, oldWeaponY);
    }

    private void updatePlayerAndWeaponOnTerminal(Game game, int oldPlayerX, int oldPlayerY, int oldWeaponX, int oldWeaponY) {
        erasePreviousPosition(game, oldPlayerX, oldPlayerY);
        erasePreviousPosition(game, oldWeaponX, oldWeaponY);


        printPlayerPosition(game);

        printWeaponPosition(game);
    }

    private void printWeaponPosition(Game game) {
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.getWeapon().getPosition().getPositionX(), game.player.getWeapon().getPosition().getPositionY());
        game.terminal.putCharacter(game.player.getWeapon().getWeaponFace()); //Weapon char
    }

    private void printPlayerPosition(Game game) {
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.getPosition().getPositionX(), game.player.getPosition().getPositionY());
        game.terminal.putCharacter(game.player.getFace());
    }

    private void erasePreviousPosition(Game game, int tempX, int tempY) {
        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor(tempX, tempY);
        game.terminal.putCharacter(' ');
    }

    private void playerMoveRight(Game game, Position oldPosition, Position newPosition, int i, int[] right) {
        newPosition.setPositionX(i);
        if (hitWall(game.map, newPosition)) {
            game.player.setPosition(oldPosition);

        } else {
            game.player.setPosition(newPosition);
            game.player.setDirection(right);
            game.player.getWeapon().setWeaponPositionOnPlayer(game.player);
        }
    }

    private void moveLeft(Game game, Position oldPosition, Position newPosition, int i, int[] left) {
        newPosition.setPositionX(i);
        if (hitWall(game.map, newPosition)) {
            game.player.setPosition(oldPosition);

        } else {
            game.player.setPosition(newPosition);
            game.player.setDirection(left);
            game.player.getWeapon().setWeaponPositionOnPlayer(game.player);
        }
    }

    private void playerMoveUp(Game game, Position oldPosition, Position newPosition, int i, int[] up) {
        newPosition.setPositionY(i);
        if (hitWall(game.map, newPosition)) {
            game.player.setPosition(oldPosition);

        } else {
            game.player.setPosition(newPosition);
            game.player.setDirection(up);
            game.player.getWeapon().setWeaponPositionOnPlayer(game.player);
        }
    }

    private void playerMoveDown(Game game, Position oldPosition, Position newPosition, int i, int[] down) {
        newPosition.setPositionY(i);
        if (hitWall(game.map, newPosition)) {
            game.player.setPosition(oldPosition);

        } else {
            game.player.setPosition(newPosition);
            game.player.setDirection(down);
            game.player.getWeapon().setWeaponPositionOnPlayer(game.player);
        }
    }

    //Checks if the character hits a wall of the gameboard
    public boolean hitWall(Map map, Position characterPosition) {
        if (map.gameBoard[characterPosition.getPositionX()][characterPosition.getPositionY()] == 1) {
            return true;
        } else {
            return false;
        }
    }
}

