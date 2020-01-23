package kata6MVC;

import Controller.Command;
import Model.Rectangle;
import View.RectangleDisplay;
import ViewSwingImplementation.SwingRectangleDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    private RectangleDisplay rectangleDisplay;
    private final Map<String, Command> commands;
    
    public MainFrame(Rectangle rectangle) {
        setTitle("Kata6-MVC");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        commands = new HashMap<>();
        getContentPane().add(rectangleDisplay(rectangle), BorderLayout.CENTER);
        getContentPane().add(buttonsPanel(), BorderLayout.SOUTH);
        
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private JPanel rectangleDisplay(Rectangle rectangle) {
        SwingRectangleDisplay display = new SwingRectangleDisplay(rectangle);
        rectangleDisplay = display;
        return display;
    }
    
    private JPanel buttonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        upPanel.add(upButton());
        downPanel.add(downButton());
        centerPanel.add(leftButton());
        centerPanel.add(rightButton());
        buttonsPanel.add(upPanel, BorderLayout.NORTH);
        buttonsPanel.add(downPanel, BorderLayout.SOUTH);
        buttonsPanel.add(centerPanel, BorderLayout.CENTER);
        return buttonsPanel;
    }
    
    private JButton upButton() {
        JButton upButton = new JButton("^");
        upButton.addActionListener(moveUp());
        return upButton;
    }
    
    private JButton downButton() {
        JButton downButton = new JButton("v");
        downButton.addActionListener(moveDown());
        return downButton;
    }
    private JButton rightButton() {
        JButton rightButton = new JButton(">");
        rightButton.addActionListener(moveRight());
        return rightButton;
    }
    private JButton leftButton() {
        JButton leftButton = new JButton("<");
        leftButton.addActionListener(moveLeft());
        return leftButton;
    }
    
    private ActionListener moveUp() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Up").execute();
            }
        };
    }
    
    private ActionListener moveDown() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Down").execute();
            }
        };
    }
    
    private ActionListener moveRight() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Right").execute();
            }
        };
    }
    
    private ActionListener moveLeft() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Left").execute();
            }
        };
    }
    
    public void addCommand(Command command, String name) {
        commands.put(name, command);
    }

    public RectangleDisplay getRectangleDisplay() {
        return rectangleDisplay;
    }


}
