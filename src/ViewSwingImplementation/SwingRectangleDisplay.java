package ViewSwingImplementation;

import Model.Rectangle;
import View.RectangleDisplay;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements RectangleDisplay{
    
    private final Rectangle rectangle;

    public SwingRectangleDisplay(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    
    @Override
    public void display() {
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        int x0 = rectangle.getX0();
        int y0 = rectangle.getY0();
        g.fillRect(oX() + x0, oY() + y0, rectangle.getWidth(), rectangle.getHeight());
    }
    
    @Override
    public int oX() {
        return getWidth()/2;
    }
    
    @Override
    public int oY() {
        return getHeight()/2;
    }
    
}
