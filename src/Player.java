public class Player {

    private Position position;
    private int startX = 20;
    private int startY = 15;
    private int[] direction;
    private int health;

    private Weapon weapon;
    private final char face = '\u263A';

    //Constructor
    public Player() {
        position = new Position(startX, startY);
        weapon = new Weapon(position);
        health = 10;
        setDirection(Direction.right);
    }

    //Getters and setters
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(int[] direction) {
        this.direction = direction;
    }

    public int[] getDirection() {
        return direction;
    }

    public char getFace() {
        return face;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
