import com.googlecode.lanterna.input.Key;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
    private char revolver = '\u00AE';
    private Position position;
    private int[] direction;
    public List<Ammo> shotsFired = new ArrayList<>();

    public Weapon(Position playerPosition){
        position =Direction.goRight(playerPosition);
        direction=Direction.right;
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

    public void moveWeapon(Position playerPosition,Key key){
        switch (key.getKind()){
            case NormalKey:
                switch (key.getCharacter()){
                    case 'w': case 'W':
                        setPosition(Direction.goUP(playerPosition));
                        break;
                    case 's': case 'S':
                        setPosition(Direction.goDown(playerPosition));
                        break;
                    case 'a': case 'A':
                        setPosition(Direction.goLeft(playerPosition));
                        break;
                    case 'd': case 'D':
                        setPosition(Direction.goRight(playerPosition));
                        break;
                    default:
                        System.out.println("Press another key");
                }
            break;
        }
    }
}
