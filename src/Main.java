import com.googlecode.lanterna.input.Key;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        GameLoopCounter gameLoopCounter = new GameLoopCounter();

        boolean startNewGame = false;

        while (true) {
            game.newGame(); //Startar ett nytt spel
            do {
                try {
                    Thread.sleep(50);
                    gameLoopCounter.monsterAndAmmoTurn(game);
                    game.playerActions.checkKeyInputAndMovesPlayerOrShoot(game);
                } catch (InterruptedException e) {
                    System.out.println("You interrupted Mr. Smiley Face! Shame on You!");
                }
            }
            while (!game.gameOver());
            Key key;
            game.music.stopAll();
            game.music.play("hyena-laugh_daniel-simion.mp3", true);
            do {
                Thread.sleep(50);
                key = game.terminal.readInput();
                if (key != null && key.getKind() == Key.Kind.F2) {
                    System.out.println("pressed f2");
                    startNewGame = true;
                }
            }
            while (!startNewGame);
            game.music.stopAll();
        }


    }
}
