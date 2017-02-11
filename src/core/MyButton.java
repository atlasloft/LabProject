package core;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by minute on 2017/2/5.
 */

public class MyButton extends JButton {

    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public MyButton() {
        this(null);
    }

    public MyButton(String text) {
        super(text);
        super.setContentAreaFilled(true);
        setForeground(new Color(0, 135, 200).brighter());
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBorder(null);
        setBackground(new Color(3, 59, 90));
        setHoverBackgroundColor(new Color(3, 59, 90).brighter());
        setPressedBackgroundColor(Color.PINK);
        setPreferredSize(new Dimension(100,40));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        setBorder(compound);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}
