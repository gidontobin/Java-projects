import game.GameFlow;
import game.LevelInformation;
import game.LevelOne;
import game.LevelTwo;
import game.LevelThree;
import game.LevelFour;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6 game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GameFlow a = new GameFlow();
        List<LevelInformation> l = new ArrayList<>();
        for (String arg : args) {
            if (!arg.matches("\\d")) {
                continue;
            }
            if (Integer.parseInt(arg) == 1) {
                l.add(new LevelOne());
            }
            if (Integer.parseInt(arg) == 2) {
                l.add(new LevelTwo());
            }
            if (Integer.parseInt(arg) == 3) {
                l.add(new LevelThree());
            }
            if (Integer.parseInt(arg) == 4) {
                l.add(new LevelFour());
            }
        }
        if (l.size() == 0) {
            l.add(new LevelOne());
            l.add(new LevelTwo());
            l.add(new LevelThree());
            l.add(new LevelFour());
        }
        a.runLevels(l);
    }
}
