public class Player {

    Position position;
    private int startX = 20;
    private int startY = 15;
    private int[] direction;

    Weapon weapon;
    private final char face = 'H';
    private int health;

    public char getFace() {
        return face;
    }

    //Constructor
    public Player(){
        position = new Position(startX,startY);
        weapon = new Weapon(position);
        setDirection(Direction.right);
    }

    //Getters and setters
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDirection(int[] direction){
       this.direction = direction;
    }

    public int[] getDirection(){
        return direction;
    }
}
