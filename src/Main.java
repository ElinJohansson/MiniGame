import com.googlecode.lanterna.input.Key;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        Key key;

        game.newGame(); //Startar ett nytt spel

        int counter = 10;
        int monsterCounter = 0;

        do {
            Thread.sleep(50);
            key = game.terminal.readInput();
            if (monsterCounter == counter) {
                game.moveEnemies();
//                game.gameTurn();
                monsterCounter = 0;
            }
            monsterCounter++;
            game.move.checkKeyInput(key, game);
        }
        while (!game.gameOver());

    }
}
