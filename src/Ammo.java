public class Ammo {
    private char shot = '¤';
    private Position position;
    private int[] direction;

    public Ammo(Position weaponPosition, int[] weaponDirection) {
        position.setPositionX(weaponPosition.getPositionX() + weaponDirection[0]);
        position.setPositionY(weaponPosition.getPositionY() + weaponDirection[1]);
        direction = weaponDirection;
    }

    public Position getPosition() {
        return position;
    }

    public char getShot() {
        return shot;
    }

    public int[] getDirection() {
        return direction;
    }

    public void moveAmmo() {
        position.setPositionX(position.getPositionX() + direction[0]);
        position.setPositionY(position.getPositionY() + direction[1]);
    }
}
