package kata6MVC;

import Controller.MoveDownCommand;
import Controller.MoveLeftCommand;
import Controller.MoveRightCommand;
import Controller.MoveUpCommand;
import Model.Rectangle;
import View.RectangleDisplay;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle  = new Rectangle(0, 0, 50, 25);
        MainFrame frame = new MainFrame(rectangle);
        RectangleDisplay display = frame.getRectangleDisplay();
        frame.addCommand(new MoveRightCommand(display, rectangle), "Right");
        frame.addCommand(new MoveLeftCommand(display, rectangle), "Left");
        frame.addCommand(new MoveUpCommand(display, rectangle), "Up");
        frame.addCommand(new MoveDownCommand(display, rectangle), "Down");
        frame.execute();
    }
    
}
