package component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by minute on 2017/2/2.
 */
public class MyButton extends JButton{
    private final Color HOVER_BACKGROUND_COLOR = new Color(200,100,100);
    private final Color PRESSED_BACKGROUND_COLOR = new Color(0,100,100);


    public MyButton(String text) {
        super(text);
        super.setContentAreaFilled(true);

        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        setBorder(compound);


//        setPreferredSize(new Dimension(100, 40));
//        setBorder(new LineBorder(new Color(200,200,200),1));
//        setForeground(new Color(108, 175, 42));
//        setBackground(Color.white);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(HOVER_BACKGROUND_COLOR);
        } else if (getModel().isRollover()) {
            g.setColor(PRESSED_BACKGROUND_COLOR);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
