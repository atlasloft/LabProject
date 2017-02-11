package component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GalleryMenu extends JMenu{
	
	BufferedImage bg;
	
	public GalleryMenu(String name){
		super(name);
		setPreferredSize(new Dimension(50,30));
		setForeground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
		if(bg == null){
			GraphicsConfiguration gc = getGraphicsConfiguration();
			bg = gc.createCompatibleImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		Graphics2D gd = bg.createGraphics();
		gd.setFont(new Font("",Font.PLAIN,14));
		if(isSelected()){
			gd.setColor(Color.BLACK);
		}else{
			gd.setColor(Color.WHITE);
		}
		gd.drawString(getText(),5,(int)(getHeight()*0.7));
		g.drawImage(bg,0,0,null);
	}

}
