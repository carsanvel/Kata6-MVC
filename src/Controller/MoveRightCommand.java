package Controller;

import Model.Rectangle;
import View.RectangleDisplay;

public class MoveRightCommand implements Command{

    private final RectangleDisplay rectangleDisplay;
    private final Rectangle rectangle;

    public MoveRightCommand(RectangleDisplay rectangleDisplay, Rectangle rectangle) {
        this.rectangleDisplay = rectangleDisplay;
        this.rectangle = rectangle;
    }
    
    @Override
    public void execute() {
        int x1 = rectangle.getWidth() + rectangle.getX0() + rectangleDisplay.oX() + 5;
        int displayWidth = rectangleDisplay.oX() * 2;
        if(x1 <= displayWidth) {
            rectangle.moveX(5);
        } else {
            rectangle.moveX(5 - (x1 - displayWidth));
        }
        rectangleDisplay.display();
    }
    
}
