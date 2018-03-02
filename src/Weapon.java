import java.util.ArrayList;
import java.util.List;

public class Weapon {

    private char weaponFace = '\u259B';
    private Position position;
    private int[] direction;
    private List<Ammo> shotsFired = new ArrayList<>();

    //Constructor
    public Weapon(Position playerPosition) {
        position = Direction.goRight(playerPosition);
        direction = Direction.right;
    }

    //Sets the weapon position and connects it to the player
    public void setWeaponPositionOnPlayer(Player player) {
        int weaponOldX = position.getPositionX();
        int weaponOldY = position.getPositionY();
        int[] playerDirection = player.getDirection();
        position.setPositionX(weaponOldX + playerDirection[0]);
        position.setPositionY(weaponOldY + playerDirection[1]);

    }

    //Creates an ammo object and adds it to shotsFired
    public void shoot(Game game) {
        Ammo newShot = new Ammo(position, direction);
        shotsFired.add(newShot);
        game.music.playFX("380_gunshot_single-mike-koenig.mp3");
    }

    //Getters and setters
    public char getWeaponFace() {
        return weaponFace;
    }

    public Position getPosition() {
        return position;
    }

    public List<Ammo> getShotsFired() {
        return shotsFired;
    }
}
