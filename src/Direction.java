public class Direction {
    public static  final int[] left = {-1, 0};
    public static  final int[] right = {1,0};
    public static final int[] up = {0,-1};
    public static  final int[] down = {0,1};
    public static final int[][] directions = {up, down, left, right};


    public static Position goLeft(Position characterPosition){
        characterPosition.setPositionX(characterPosition.getPositionX()+left[0]);
        return characterPosition;
    }

    public static Position goRight(Position characterPosition){
        characterPosition.setPositionX(characterPosition.getPositionX()+right[0]);
        return characterPosition;
    }

    public static Position goUP(Position characterPosition){
        characterPosition.setPositionY(characterPosition.getPositionY()+up[1]);
        return characterPosition;
    }

    public static Position goDown(Position characterPosition){
        characterPosition.setPositionY(characterPosition.getPositionY()+down[1]);
        return characterPosition;
    }

}
