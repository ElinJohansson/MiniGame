import com.googlecode.lanterna.input.Key;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        game.newGame(); //Startar ett nytt spel

        int counter = 10;
        int monsterCounter = 0;
        int ammoCounter = 0;
        int counterForAmmo = 3;


        do {
            Thread.sleep(100);
            if (monsterCounter == counter) {
                game.moveEnemies();
//                game.gameTurn();
                monsterCounter = 0;
            }
            if (ammoCounter == counterForAmmo) {
                game.movesAllAmmoAndPrintsTheNewPositions();
                game.ammoHitsWall();
                game.enemyHitByAmmo();
                game.printAmmo();
                ammoCounter = 0;

            }
            monsterCounter++;
            ammoCounter++;
            game.move.checkKeyInput(game);
        }
        while (!game.gameOver());

    }
}
