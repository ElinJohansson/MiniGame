public class Enemy {

    char enemyFace = '\u00DF';
    Position enemyPosition;


    // returns the position of the enemy to the map to be drawn on the gameboard
    public int enemy (Position enemyPosition, Map map ){
        return (map.gameBoard[enemyPosition.getPositionX()][enemyPosition.getPositionY()]);
    }

    public int moveEnemy(){
        

    }


    public int checkCollisionOtherEnemy(){


    }


}





