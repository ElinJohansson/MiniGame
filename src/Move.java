import com.googlecode.lanterna.input.Key;

public class Move {

    public void checkKeyInput(Game game) throws InterruptedException {
        Key key;

            key = game.terminal.readInput();
        if(key == null) return;


//        //Gets the player position and adds it to a temp new position
        int x = game.player.getPosition().getPositionX();
        int y = game.player.getPosition().getPositionY();

        Position oldPosition = game.player.getPosition();

        Position newPosition = new Position(x, y);

        int playerX;
        int playerY;
        int oldWeaponX = game.player.weapon.getPosition().getPositionX();
        int oldWeaponY = game.player.weapon.getPosition().getPositionY();
        Position newWeaponPosition;

        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor( x,y);
        game.terminal.putCharacter(' ');

        System.out.println(key.getKind());
        //Vilken knapp som trycks ner
        switch (key.getKind()) {
            case ArrowDown:
                newPosition.setPositionY(y + 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.down);
                    game.player.weapon.setWeaponPositionOnPlayer(game.player);
                }
                break;
            case ArrowUp:
                newPosition.setPositionY(y - 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.up);
                    game.player.weapon.setWeaponPositionOnPlayer(game.player);
                }
                break;
            case ArrowLeft:
                newPosition.setPositionX(x - 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.left);
                    game.player.weapon.setWeaponPositionOnPlayer(game.player);
                }
                break;
            case ArrowRight:
                newPosition.setPositionX(x + 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.right);
                    game.player.weapon.setWeaponPositionOnPlayer(game.player);
                }
                break;
            case Tab:
                game.player.weapon.shoot();
                break;
            case NormalKey:
                break;
            default:
                    break;

        }
        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor( oldWeaponX, oldWeaponY);
        game.terminal.putCharacter(' ');

        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor(game.player.weapon.getPosition().getPositionX(), game.player.weapon.getPosition().getPositionY());
        game.terminal.putCharacter('\u00AE'); //Weapon char
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.getPosition().getPositionX(), game.player.getPosition().getPositionY());
        game.terminal.putCharacter(game.player.getFace());
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.weapon.getPosition().getPositionX(), game.player.weapon.getPosition().getPositionY());
        game.terminal.putCharacter(game.player.weapon.getRevolver()); //Weapon char


    }
}
