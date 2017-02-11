package component;

import javax.swing.*;
import java.awt.*;

public class MyPasswordField extends JPasswordField{
	
	private Font font1 = new Font("SansSerif", Font.BOLD, 20);
	
	public MyPasswordField(int n){
		super(n);
		setFont(font1);
		setBackground(new Color(190,190,190));
		setForeground(new Color(92,140,7));
		setBorder(javax.swing.BorderFactory.createEmptyBorder());
	
		
	}
}
