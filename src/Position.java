public class Position {

    private int x;
    private int y;

    //Constructor
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Gets the current position of the character on the x-row
    public int getPositionX() {
        return this.x;
    }

    //Gets the current position of the character on the y-column
    public int getPositionY() {
        return this.y;
    }

    // sets position of the character on the x-row
    public void setPositionX(int x) {
        this.x = x;
    }

    // sets position of the character on the y-column
    public void setPositionY(int y) {
        this.y = y;
    }

}