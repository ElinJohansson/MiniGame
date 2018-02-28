public class Move {

    public void checkKeyInput() {
        //Vilken knapp som trycks ner
        switch (key.getKind()) {
            case ArrowDown:
                newPosition.setPositionY(y + 1);
                newPosition.setPositionX(x);
                if (!hitWall(newPosition)) {
                    player.setPosition(newPosition.getX(), newPosition.getY());
                    break;
                } else {
                    break;
                }
            case ArrowUp:
                newPosition.setY(y - 1);
                newPosition.setX(x);
                if (!hitWall(newPosition)) {
                    player.setPosition(newPosition.getX(), newPosition.getY());
                    break;
                } else {
                    break;
                }
            case ArrowLeft:
                newPosition.setX(x - 1);
                newPosition.setY(y);
                if (!hitWall(newPosition)) {
                    player.setPosition(newPosition.getX(), newPosition.getY());
                    break;
                } else {
                    break;
                }
            case ArrowRight:
                newPosition.setX(x + 1);
                newPosition.setY(y);
                if (!hitWall(newPosition)) {
                    player.setPosition(newPosition.getX(), newPosition.getY());
                    break;
                } else {
                    break;
                }
        }
    }
}
