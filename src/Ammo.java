public class Ammo {
    private char shot = '¤';
    private Position position;
    private int direction;

    public Ammo(Position weaponPosition, int weaponDirection){
        position =weaponPosition;
        direction=weaponDirection;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getShot() {
        return shot;
    }

    public int getDirection() {
        return direction;
    }
}
