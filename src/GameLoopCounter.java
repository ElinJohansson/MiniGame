public class GameLoopCounter {
    //Loop counters
    private int monsterSpeed = 10;
    private int monsterSpeedCounter = 0;
    private int monsterWaveCounter = 0;
    private int monsterWave = 150;
    private int ammoCounter = 0;
    private int ammoSpeed = 3;
    private int levelCounter = 0;

    public void monsterAndAmmoTurn(Game game) throws InterruptedException {
        if (ammoCounter == ammoSpeed) {
            game.movesAllAmmoAndPrintsTheNewPositions();
            game.ammoHitsWall();
            game.enemyHitByAmmo();
            ammoCounter = 0;

        }
        if (monsterSpeedCounter == monsterSpeed) {
            game.moveEnemies();
            game.enemyHitByAmmo();
//            if (monsterWaveCounter == monsterWave) {
//                game.addEnemiesToList();
//                monsterWaveCounter = 0;
//            }
            if(game.getEnemies().isEmpty() && !game.gameOver()){
                levelCounter+=1;
                game.render.printText(game.terminal, "Level: "+(levelCounter+1),70, 5, 255, 255, 0);
                game.render.printText(game.terminal, "Level "+levelCounter+" cleared", 22,10, 102, 255, 51);
                game.addEnemiesToList();
                Thread.sleep(1000);
                game.render.eraseText(game.terminal, "Level "+levelCounter+" cleared", 22,10,102,255,51);

            }
            monsterSpeedCounter = 0;
        }
        monsterSpeedCounter++;
        ammoCounter++;
        monsterWaveCounter++;
    }

    public int getLevelCounter() {
        return levelCounter;
    }

    public void setLevelCounter(int levelCounter) {
        this.levelCounter = levelCounter;
    }
}
