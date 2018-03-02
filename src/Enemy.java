import java.util.Random;

public class Enemy {

    private char enemyFace = '\u2593';
    private Position position;

    //Constructor
    public Enemy() {
        Random rand = new Random();
        this.position = new Position(58, rand.nextInt(28) + 1); //Enemy start position is randomised on the game board
    }

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





