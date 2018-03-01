import com.googlecode.lanterna.terminal.Terminal;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Enemy {

    char enemyFace = '\u00DF';
    private Position position;

    public Enemy() {
        Random rand = new Random();
        this.position = new Position(58, rand.nextInt(28) + 1);
    }

    public char getEnemyFace() {
        return enemyFace;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    // returns the position of the enemy to the map to be drawn on the gameboard
    public int enemy(Position enemyPosition, Map map) {
        return (map.gameBoard[enemyPosition.getPositionX()][enemyPosition.getPositionY()]);
    }

    //Testar annan metod
/*    public void moveEnemy(Player player, Map map, List<Enemy> enemies) {
        //enemy ska röra sig mot spelaren, utan att vänta på knapptryck.
        //Kollar absolutvärdet mellan enemy-pos och player-pos i x och y-led
        if (Math.abs(position.getPositionX() - player.getPosition().getPositionX()) >= Math.abs(position.getPositionY() - player.getPosition().getPositionY())) {
            //Om avståndet är större i x-led och enemy står till höger om spelaren
            if ((player.getPosition().getPositionX() - position.getPositionX()) <= 0) {
               //Monstrets position flyttas ett steg till vänster
                position = Direction.goLeft(position);
                //Om den nya positionen är upptagen av en annan enemy eller om den går in i en vägg
//                if (positionOccupied(enemies) || position.hitWall(map, position)) {
//                    //Positionen ändras tillbaka igen
//                    position = Direction.goRight(position);
//                }
            } else {
                position = Direction.goRight(position);
//                if (positionOccupied(enemies) || position.hitWall(map, position)) {
//                    position = Direction.goLeft(position);
//                }
            }
        } else {
            if ((player.getPosition().getPositionY() - position.getPositionY()) <= 0) {
                position = Direction.goUP(position);
//                if (positionOccupied(enemies) || position.hitWall(map, position)) {
//                    position = Direction.goDown(position);
//                }


            } else {
                position = Direction.goDown(position);
//                if (positionOccupied(enemies) || position.hitWall(map, position)) {
//                    position = Direction.goUP(position);
//                }

            }
        }
        System.out.println(position.getPositionX()+" "+position.getPositionY());

    }*/



    // check if the enemies are in the same space, if they are then 
/*    public boolean positionOccupied(List<Enemy> enemies) {
 *//*       for (Enemy enemy1 : enemies) {
            for (Enemy enemy2 : enemies) {
                if (enemy1.getPosition().getPositionX() == enemy2.getPosition().getPositionX() &&
                        enemy1.getPosition().getPositionY() == enemy2.getPosition().getPositionY() && enemy1.position != enemy2.position) {
                    return true;
                }
            }
        }
        return false;*//*

        Set<String> monsterPositionString = new HashSet<>();
        for (int i = 0; i < enemies.size(); i++) {
            String s = "";
            s = "x:" + enemies.get(i).getPosition().getPositionX() + "y:" + enemies.get(i).getPosition().getPositionY();
            if (monsterPositionString.contains(s)) {
                return true;
            }
            monsterPositionString.add(s);
        }
        return false;

    }*/


}





