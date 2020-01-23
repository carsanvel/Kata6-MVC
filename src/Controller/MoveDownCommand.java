package Controller;

import Model.Rectangle;
import View.RectangleDisplay;

public class MoveDownCommand implements Command{
    
    private final RectangleDisplay rectangleDisplay;
    private final Rectangle rectangle;

    public MoveDownCommand(RectangleDisplay rectangleDisplay, Rectangle rectangle) {
        this.rectangleDisplay = rectangleDisplay;
        this.rectangle = rectangle;
    }
    
    @Override
    public void execute() {
        int y1 = rectangle.getHeight()+ rectangle.getY0() + rectangleDisplay.oY() + 5;
        int displayHeight = rectangleDisplay.oY() * 2;
        if(y1 <= displayHeight) {
            rectangle.moveY(5);
        } else {
            rectangle.moveY(5 - (y1 - displayHeight));
        }
        rectangleDisplay.display();
    }
}
