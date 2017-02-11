package component;

import javax.swing.*;
import java.awt.*;

//怎样通过继承扩展一个类来着？？
public class MyTextField extends JTextField{
	private Font font1 = new Font("SansSerif", Font.BOLD, 20);
	public MyTextField(int n){
		super(n);
		setFont(font1);
		setBackground(new Color(190,190,190));
		setForeground(new Color(92,140,7));
		setBorder(BorderFactory.createEmptyBorder());
	}
	
}
