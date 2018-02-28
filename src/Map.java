public class Map {

    //Dimensions for the game board
    private int gameBoardHeight = 40;
    private int gameBoardWidth = 60;


    //Dimensions for the score board
    private int scoreBoardHeight = 40;
    private int scoreBoardWidth = 100; //Because the left part overlaps with the game board

    //Arrays containing information about gameBoard & scoreBoard, int[x][y]
    public int[][] gameBoard;
    public int[][] scoreBoard;

    //Different types of tiles that are represented in the arrays
    private final int floor = 0;
    private final int border = 1;
    private final int scoreBoardTile = 2;

    //Constructor
    public Map() {
        initializeGameBoard();
        initializeScoreBoard();
    }

    //Fills the game board array
    private void initializeGameBoard() {
        gameBoard = new int[gameBoardWidth][gameBoardHeight];
        for (int x = 0; x < gameBoard.length; x++) { //Löper igenom x-axeln horisontellt
            for (int y = 0; y < gameBoard[x].length; y++) { //Löper igenom y-axeln vertikalt
                if(x == 0 || x == gameBoardHeight-1 || y == 0 || y == gameBoard[x].length-1 ){ //If the iterator is on the border
                    scoreBoard[x][y] = border;
                }
                gameBoard[x][y] = floor;
            }
        }
    }

    //Fills the score board array
    private void initializeScoreBoard() {
        scoreBoard = new int[scoreBoardWidth][scoreBoardHeight];
        for (int x = 0; x < scoreBoard.length; x++) { //Löper igenom x-axeln horisontellt
            //The part that is overlapping with the game board
            for (int y = 0; y < gameBoard[x].length; y++) { //Löper igenom y-axeln vertikalt
                scoreBoard[x][y] = floor;
            }
            //The part that represents the visual score board to the right in the terminal
            for(int y = gameBoard[x].length+1; y < scoreBoard[x].length; y++){  //gameboard[x].length+1 because the area starts after game board border
                if(x == 0 || x == scoreBoardHeight-1 || y == scoreBoard[x].length-1 ){ //If the iterator is on the border
                    scoreBoard[x][y] = border;
                }
                scoreBoard[x][y] = scoreBoardTile;
            }
        }
    }

    //Getters & Setters
    public int getGameBoardHeight() {
        return gameBoardHeight;
    }

    public int getGameBoardWidth() {
        return gameBoardWidth;
    }

    public int getScoreBoardHeight() {
        return scoreBoardHeight;
    }

    public int getScoreBoardWidth() {
        return scoreBoardWidth;
    }
}
