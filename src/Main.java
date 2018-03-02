public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        GameLoopCounter gameLoopCounter = new GameLoopCounter();
        game.newGame(); //Startar ett nytt spel

        do {
            try {
                Thread.sleep(50);
                gameLoopCounter.monsterAndAmmoTurn(game);
                game.playerActions.checkKeyInputAndMovesPlayerOrShoot(game);
            } catch (InterruptedException e){
                System.out.println("You interrupted Mr. Smiley Face! Shame on You!");
            }
        }
        while (!game.gameOver());

    }
}
