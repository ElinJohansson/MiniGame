public class Ammo {

    private char shot = '¤';
    private Position position;
    private int[] direction;

    //Constructor
    public Ammo(Position weaponPosition, int[] weaponDirection) {
        position = new Position(weaponPosition.getPositionX() + weaponDirection[0],(weaponPosition.getPositionY() + weaponDirection[1]));
        direction = weaponDirection;
    }

    //Moves the ammo in the direction it was fired
    public void moveAmmo() {
        position.setPositionX(position.getPositionX() + direction[0]);
        position.setPositionY(position.getPositionY() + direction[1]);
    }

    //Setters and getters
    public Position getPosition() {
        return position;
    }

    public char getShot() {
        return shot;
    }

}
