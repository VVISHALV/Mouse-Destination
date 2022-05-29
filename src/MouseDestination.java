import java.awt.AWTException;
import java.awt.Robot;

public class MouseDestination {
    static Robot robot = null;

    MouseDestination() throws AWTException {
        robot = new Robot();
    }

    public static void setMouse(int x, int y) {
        robot.mouseMove(x, y);
    }

}
