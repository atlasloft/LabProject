package component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by minute on 2017/2/5.
 */
public class ButtonRe extends JButton {

    private Color hoverBackgroundColor = new Color(100,100,100);
    private Color pressedBackgroundColor = new Color(150,150,150);

    public ButtonRe() {
        this(null);
    }

    public ButtonRe(String text) {
        super(text);
        super.setContentAreaFilled(true);
        setForeground(new Color(0, 135, 200).brighter());
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBorder(null);
        setBackground(new Color(3, 59, 90));
//        setHoverBackgroundColor(new Color(3, 59, 90).brighter());
//        setPressedBackgroundColor(Color.PINK);
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

