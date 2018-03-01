import java.util.List;
import java.util.Random;

public class Enemy {

    char enemyFace = '\u00DF';
    private Position position;

    public Enemy() {
        Random rand = new Random();
        this.position = new Position(rand.nextInt(58)+1,rand.nextInt(28)+1);
    }

    public char getEnemyFace() {
        return enemyFace;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    // returns the position of the enemy to the map to be drawn on the gameboard
    public int enemy(Position enemyPosition, Map map) {
        return (map.gameBoard[enemyPosition.getPositionX()][enemyPosition.getPositionY()]);
    }

    public void moveEnemy(Player player, Game game) {
        //enemy ska röra sig mot spelaren, utan att vänta på knapptryck.
        if (Math.abs(position.getPositionX() - player.getPosition().getPositionX()) >= Math.abs(position.getPositionY() - player.getPosition().getPositionY())) {
            if ((player.getPosition().getPositionX() - position.getPositionX()) <= 0) {
                position = Direction.goLeft(position);

                if (positionOccupied(game.getEnemies()) || position.hitWall(game.map, position)) {
                    position = Direction.goRight(position);
                }
            } else {
                position = Direction.goRight(position);
                if (positionOccupied(game.getEnemies()) || position.hitWall(game.map, position)) {
                    position = Direction.goLeft(position);
                }
            }
        } else {
            if ((player.getPosition().getPositionY() - position.getPositionY()) <= 0) {
                position = Direction.goUP(position);
                if (positionOccupied(game.getEnemies()) || position.hitWall(game.map, position)) {
                    position = Direction.goDown(position);
                }


            } else {
                position = Direction.goDown(position);
                if (positionOccupied(game.getEnemies()) || position.hitWall(game.map, position)) {
                    position = Direction.goUP(position);
                }

            }
        }

    }

    // check if the enemies are in the same space, if they are then 
    public boolean positionOccupied(List<Enemy> enemies) {
        for (Enemy enemy1 : enemies) {
            for (Enemy enemy2 : enemies) {
                if (enemy1.getPosition().getPositionX() == enemy2.getPosition().getPositionX() &&
                        enemy1.getPosition().getPositionY() == enemy2.getPosition().getPositionY() && enemy1.position != enemy2.position) {
                    return true;
                }
            }
        }
        return false;

    }


}





