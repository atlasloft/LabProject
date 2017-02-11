package component;

import javax.swing.*;
import java.awt.*;

public class DarkTextArea extends JTextArea{
	public DarkTextArea(int rows, int columns){
		super(rows, columns);
		setFont(MyFonts.BODY);
		setBackground(new Color(45,45,45));
		setForeground(new Color(190,190,190));
		setBorder(BorderFactory.createEmptyBorder());
		setLineWrap(true);
		setWrapStyleWord(true);
	}
}
