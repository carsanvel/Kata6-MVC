package Controller;

import Model.Rectangle;
import View.RectangleDisplay;

public class MoveLeftCommand implements Command{

    private final RectangleDisplay rectangleDisplay;
    private final Rectangle rectangle;

    public MoveLeftCommand(RectangleDisplay rectangleDisplay, Rectangle rectangle) {
        this.rectangleDisplay = rectangleDisplay;
        this.rectangle = rectangle;
    }
    
    @Override
    public void execute() {
        int x1 = rectangle.getX0() + rectangleDisplay.oX() - 5;
        if(x1 >= 0) {
            rectangle.moveX(-5);
        } else  {
            rectangle.moveX(-5 - x1);
        }
        rectangleDisplay.display();
    }
}
