public class Player {

    Position position;
    private int startX = 20;
    private int startY = 15;

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
}
