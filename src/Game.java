import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.List;

public class Game {

    public Terminal terminal;
    private Map map;
    private Player player;
    private List<Enemy> enemies;

    //Constructor
    public Game() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminalSettings();
    }

    //Terminal settings
    private void terminalSettings() {
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(189, 132, 40);
        terminal.setCursorVisible(false);
    }
}
