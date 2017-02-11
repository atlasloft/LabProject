package component;

import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea{
	private Font font1 = new Font("SansSerif", Font.BOLD, 20);
	public MyTextArea(int rows, int columns){
		super(rows, columns);
		setFont(font1);
		setBackground(new Color(200,200,200));
		setForeground(new Color(82,130,7)) ;
		setBorder(BorderFactory.createEmptyBorder());
		setFont(new Font("Serif", Font.ITALIC, 16));
		setLineWrap(true);
		setWrapStyleWord(true);

	}
}
