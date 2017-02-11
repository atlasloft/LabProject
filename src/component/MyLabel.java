package component;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6594721443209942804L;

	public MyLabel(String str){
		super(str);
		
		setFont(MyFonts.TEXT);
		setForeground(new Color(190,190,190));
//		setForeground(new Color(138,205,72));
		setBackground(Color.RED);
		
	}
}