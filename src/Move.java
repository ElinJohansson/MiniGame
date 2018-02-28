import com.googlecode.lanterna.input.Key;

public class Move {

    public void checkKeyInput(Key key, Game game) {

        //Gets the player position and adds it to a temp new position
        int x = game.player.getPosition().getPositionX();
        int y = game.player.getPosition().getPositionY();

        Position tempPosition = game.player.getPosition();

        Position newPosition = new Position(x, y);

        //Vilken knapp som trycks ner
        switch (key.getKind()) {
            case ArrowDown:
                newPosition.setPositionY(y + 1);
                newPosition.setPositionX(x);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(tempPosition);
                    break;
                } else {
                    break;
                }
            case ArrowUp:
                newPosition.setPositionY(y - 1);
                newPosition.setPositionX(x);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(tempPosition);
                    break;
                } else {
                    break;
                }
            case ArrowLeft:
                newPosition.setPositionX(x - 1);
                newPosition.setPositionY(y);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(tempPosition);
                    break;
                } else {
                    break;
                }
            case ArrowRight:
                newPosition.setPositionX(x + 1);
                newPosition.setPositionY(y);
                if (!newPosition.hitWall(game.map, newPosition)) {
                    game.player.setPosition(tempPosition);
                    break;
                } else {
                    break;
                }
        }
    }
}
