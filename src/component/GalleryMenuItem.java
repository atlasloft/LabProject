package component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GalleryMenuItem extends JMenuItem{
	
	private BufferedImage bg;
	private String theTitle;
	
	public GalleryMenuItem(String title){
		super(title);
		theTitle = title;
	}
	
	public void paintComponent(Graphics g){
		if(bg == null){
			GraphicsConfiguration gc = getGraphicsConfiguration();
			bg = gc.createCompatibleImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		Graphics2D gd = bg.createGraphics();
		gd.setFont(new Font("",Font.PLAIN,12));
		if(isArmed()){
			gd.setColor(Color.BLACK);
		}else{
			gd.setColor(Color.WHITE);
		}
		gd.drawString(theTitle,5,(int)(getHeight()*0.7));
		g.setColor(new Color(191,188,188));
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(bg,0,0,null);
	}

}
