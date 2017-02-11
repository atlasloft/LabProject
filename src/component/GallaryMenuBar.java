package component;

import javax.swing.*;
import java.awt.*;

public class GallaryMenuBar extends JMenuBar{
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		GradientPaint gp = new GradientPaint(0,0,new Color(156,153,153),0,getHeight() /2, new Color(191,188,188));
		g2d.setPaint(gp);
		g2d.fillRect(0,0,getWidth(),getHeight());
	}

}
