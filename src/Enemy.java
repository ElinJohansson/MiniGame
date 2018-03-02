public class Enemy {

    private char enemyFace = '\u2593';
    private Position position;

    //Constructor
    public Enemy(int x, int y){
        position = new Position(x,y);
    }

    @Override
    public boolean equals(Object anObject){
        if(!(anObject instanceof Enemy)){
            return false;
        }
        Enemy otherEnemy = (Enemy)anObject;
        return this.position.getPositionX() == otherEnemy.position.getPositionX() && this.position.getPositionY() == otherEnemy.position.getPositionY();
    }

    //Getters and setters
    public char getEnemyFace() {
        return enemyFace;
    }

    public Position getPosition() {
        return position;
    }

}





