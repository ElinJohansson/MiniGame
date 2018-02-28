import com.googlecode.lanterna.input.Key;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        Key key;
        int iterator = 0;
        while (true) {
            while (!game.gameOver()) {
                do {
                    Thread.sleep(5);
                    key = game.terminal.readInput();
                    if (iterator % 100 == 0) {
                        //monster ska röra på sig
                    }
                    iterator++;
                }
                while (key == null);
                game.move.checkKeyInput(key, game);
            }
        }
    }
}
