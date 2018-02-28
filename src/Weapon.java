import java.util.ArrayList;
import java.util.List;

public class Weapon {
    private char revolver = '\u00AE';
    private Position position;
    private int direction;
    public List<Ammo> shotsFired = new ArrayList<>();

    public Weapon(Position playerPosition){
        position =playerPosition;
        direction=Direction.RIGHT_X;
    }

    public char getRevolver() {
        return revolver;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position playerPosition) {
        position = playerPosition;
    }

    //Creates an ammo object and adds it to shotsFired
    public void shoot(){
        Ammo newShot = new Ammo(position,direction);
        shotsFired.add(newShot);
    }
}
