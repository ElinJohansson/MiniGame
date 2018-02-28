import java.util.List;

public class Enemy {

    char enemyFace = '\u00DF';
    Position enemyPosition;


    // returns the position of the enemy to the map to be drawn on the gameboard
    public int enemy (Position enemyPosition, Map map ){
        return (map.gameBoard[enemyPosition.getPositionX()][enemyPosition.getPositionY()]);
    }

    public void moveEnemy(Player player){
        //enemy ska röra sig mot spelaren, utan att vänta på knapptryck.
                if (Math.abs(enemyPosition.getPositionX()- player.getPosition().getPositionX()) >= Math.abs(enemyPosition.getPositionY()- player.getPosition().getPositionY())) {
                    if ((player.getPosition().getPositionX() - enemyPosition.getPositionX()) <= 0) {
                        enemyPosition = Direction.goLeft(enemyPosition);

                    } else {
                        enemyPosition = Direction.goRight(enemyPosition);
                    }
                }
                else {
                    if ((player.getPosition().getPositionY() - enemyPosition.getPositionY()) <= 0) {
                        enemyPosition = Direction.goUP(enemyPosition);;

                    } else {
                        enemyPosition = Direction.goDown(enemyPosition);

                    }
                }+

    }

    // check if the enemies are in the same space, if they are then 
    public int checkCollisionOtherEnemy(List<Enemy> enemies){
        for ( int i = 0; i < enemies.size; i++ ){
            for (int j = i+1; j < enemies.size; j++){


            }

        }
    }


}





