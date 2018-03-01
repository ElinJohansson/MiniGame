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

    public void setWeaponPositionOnPlayer(Player player) {
        //nya positionen ska vara vapnets gamla position plus riktningen som spelaren rör sig i
        int weaponOldX = position.getPositionX();
        int weaponOldY = position.getPositionY();
        int[] playerDirection = player.getDirection();
        position.setPositionX(weaponOldX+playerDirection[0]);
       position.setPositionY(weaponOldY+playerDirection[1]);

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void changeWeaponPositionOnPlayer(Position position){
        this.position=position;
    }

    //Creates an ammo object and adds it to shotsFired
    public void shoot(){
        Ammo newShot = new Ammo(position,direction);
        shotsFired.add(newShot);
    }

/*    public void moveWeapon(Position playerPosition,Key key){
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
    }*/
}
