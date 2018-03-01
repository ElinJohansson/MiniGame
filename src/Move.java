import com.googlecode.lanterna.input.Key;

public class Move {

    public void checkKeyInput(Key key, Game game) {
        if (key == null) return;
//        //Gets the player position and adds it to a temp new position
//        int x = game.player.getPosition().getPositionX();
//        int y = game.player.getPosition().getPositionY();

        Position oldPosition = game.player.getPosition();

        Position newPosition;

        //Vilken knapp som trycks ner
        switch (key.getKind()) {
            case ArrowDown:
//                newPosition.setPositionY(y + 1);
//                newPosition.setPositionX(x);
                newPosition = Direction.goDown(oldPosition);
                if (newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);
                    break;
                } else {
                    game.player.setPosition(newPosition);
                    break;
                }
            case ArrowUp:
//                newPosition.setPositionY(y - 1);
//                newPosition.setPositionX(x);
                newPosition = Direction.goUP(oldPosition);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);
                    break;
                } else {
                    break;
                }
            case ArrowLeft:
//                newPosition.setPositionX(x - 1);
//                newPosition.setPositionY(y);
                newPosition = Direction.goLeft(oldPosition);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);
                    break;
                } else {
                    break;
                }
            case ArrowRight:
//                newPosition.setPositionX(x + 1);
//                newPosition.setPositionY(y);
                newPosition = Direction.goRight(oldPosition);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(oldPosition);
                    break;
                } else {
                    break;
                }
        }
    }
}
