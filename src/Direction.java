public class Direction {
    public static  final int[] left = {-1, 0};
    public static  final int[] right = {1,0};
    public static final int[] up = {0,-1};
    public static  final int[] down = {0,1};
    public static final int[][] directions = {up, down, left, right};


    public static Position goLeft(Position characterPosition){

        Position tempPosition = new Position(characterPosition.getPositionX(),characterPosition.getPositionY());
        tempPosition.setPositionX(characterPosition.getPositionX()+left[0]);

        return tempPosition;
    }

    public static Position goRight(Position characterPosition){

        Position tempPosition = new Position(0,characterPosition.getPositionY());
        tempPosition.setPositionX(characterPosition.getPositionX()+right[0]);

        return tempPosition;

    }

    public static Position goUP(Position characterPosition){
        Position tempPosition = new Position(0,characterPosition.getPositionY());
        tempPosition.setPositionX(characterPosition.getPositionX()+up[0]);

        return tempPosition;
    }

    public static Position goDown(Position characterPosition){
        Position tempPosition = new Position(0,characterPosition.getPositionY());
        tempPosition.setPositionX(characterPosition.getPositionX()+down[0]);

        return tempPosition;
    }

}
