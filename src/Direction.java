public class Direction {
    public static final int LEFT_X = -1;
    public static final int RIGHT_X = 1;
    public static final int UP_Y = -1;
    public static final int DOWN_Y = 1;


<<<<<<< HEAD
    public static Position goLeft(Position characterPosition){
        characterPosition.setPositionX(characterPosition.getPositionX()+LEFT_X);
        return characterPosition;
    }

    public static Position goRight(Position characterPosition){
        characterPosition.setPositionX(characterPosition.getPositionX()+RIGHT_X);
        return characterPosition;
    }

    public static Position goUP(Position characterPosition){
        characterPosition.setPositionY(characterPosition.getPositionY()+UP_Y);
        return characterPosition;
    }

    public static Position goDown(Position characterPosition){
        characterPosition.setPositionY(characterPosition.getPositionY()+DOWN_Y);
        return characterPosition;
    }
=======
>>>>>>> c09429e09951c2a9652f63de72fd308d968f7e8e
}
