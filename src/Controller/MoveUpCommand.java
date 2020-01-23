package Controller;

import Model.Rectangle;
import View.RectangleDisplay;

public class MoveUpCommand implements Command{
    
    private final RectangleDisplay rectangleDisplay;
    private final Rectangle rectangle;

    public MoveUpCommand(RectangleDisplay rectangleDisplay, Rectangle rectangle) {
        this.rectangleDisplay = rectangleDisplay;
        this.rectangle = rectangle;
    }
    
    @Override
    public void execute() {
        int y1 = rectangle.getY0() + rectangleDisplay.oY() - 5;
        if(y1 >= 0) {
            rectangle.moveY(-5);
        } else  {
            rectangle.moveY(-5 - y1);
        }
        rectangleDisplay.display();
    }
    
}
