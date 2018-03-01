import com.googlecode.lanterna.input.Key;

public class Move {

    public void checkKeyInput(Game game) throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = game.terminal.readInput();
        }
        while (key == null);


//        //Gets the player position and adds it to a temp new position
        int x = game.player.getPosition().getPositionX();
        int y = game.player.getPosition().getPositionY();
        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor(x, y);
        game.terminal.putCharacter(' ');
        game.terminal.applyForegroundColor(0, 0, 0);
        game.terminal.moveCursor(game.player.weapon.getPosition().getPositionX(), game.player.weapon.getPosition().getPositionY());
        game.terminal.putCharacter(' '); //Weapon char
        Position oldPosition = game.player.getPosition();

        Position newPosition = new Position(x, y);

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
                }
                break;
            case ArrowUp:
                newPosition.setPositionY(y - 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.up);
                }
                break;
            case ArrowLeft:
                newPosition.setPositionX(x - 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.left);
                }
                break;
            case ArrowRight:
                newPosition.setPositionX(x + 1);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);

                } else {
                    game.player.setPosition(newPosition);
                    game.player.setDirection(Direction.right);
                }
                break;
            case NormalKey:
                switch (key.getCharacter()) {
                    case 'w':
                    case 'W':
                        game.player.weapon.changeWeaponPositionOnPlayer(Direction.goUP(game.player.getPosition()));
                        break;
                    case 's':
                    case 'S':
                        game.player.weapon.changeWeaponPositionOnPlayer(Direction.goDown(game.player.getPosition()));
                        break;
                    case 'a':
                    case 'A':
                        game.player.weapon.changeWeaponPositionOnPlayer(Direction.goLeft(game.player.getPosition()));
                        break;
                    case 'd':
                    case 'D':
                        game.player.weapon.changeWeaponPositionOnPlayer(Direction.goRight(game.player.getPosition()));
                        break;
                    default:
                        System.out.println("Press another key");
                }
        }
        game.player.weapon.setPositionOnPlayer(game.player);
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.getPosition().

                getPositionX(), game.player.getPosition().

                getPositionY());
        game.terminal.putCharacter(game.player.getFace());
        game.terminal.applyForegroundColor(255, 255, 0);
        game.terminal.moveCursor(game.player.weapon.getPosition().

                getPositionX(), game.player.weapon.getPosition().

                getPositionY());
        game.terminal.putCharacter(game.player.weapon.getRevolver()); //Weapon char


    }
}
