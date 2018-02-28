public class Enemy {

    char enemyFace = '\u00DF';
    Position enemyPosition;


    // returns the position of the enemy to the map to be drawn on the gameboard
    public int enemy (Position enemyPosition, Map map ){
        return (map.gameBoard[enemyPosition.getPositionX()][enemyPosition.getPositionY()]);
    }

    public int moveEnemy(Player player){
        //enemy ska röra sig mot spelaren, utan att vänta på knapptryck.
                if (Math.abs(enemyPosition.getPositionX()- player.getPosition().getPositionX()) >= Math.abs(enemyPosition.getPositionY()- player.getPosition().getPositionY())) {
                    if ((player.getPosition().getPositionX() - enemyPosition.getPositionX()) <= 0) {
                        enemyPosition.setPositionX()--;

                    } else {
                        monsterPosition1X++;

                    }
                } else {
                    if ((positionY - monsterPosition1Y) <= 0) {
                        monsterPosition1Y--;

                    } else {
                        monsterPosition1Y++;

                    }
                }

    }


    public int checkCollisionOtherEnemy(){




    }


}





