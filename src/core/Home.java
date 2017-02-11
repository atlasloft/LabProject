//好累{x x}
package core;

import lab.PureUI.AdminLogin;
import component.MyLabel;
import component.MyMenuBar;
import component.UIs;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//首页的界面

public class Home {
	
	Font font = new Font("MenloRegular", Font.BOLD, 20);
	private JFrame f = new JFrame("");
	private Box v = Box.createVerticalBox();
	private Box h[] = new Box[7];
	JButton b1 = new JButton("注册");
	JButton b2 = new JButton("登录");
	JButton exitB = new JButton("退出");
	MyMenuBar mb = new MyMenuBar();
	JMenu mn1 = new JMenu("menu");
	JMenu mn2 = new JMenu("离开");
	JLabel titleL = new JLabel("郑轻软创{ '  ' }招新系统");
	MyLabel note1 = new MyLabel("<HTML><U>注册与报名:</U></HTML>");
	MyLabel note2 = new MyLabel("<HTML><U>查看与修改:</U></HTML>");
	JPanel p[] = new JPanel[7];
	JMenuItem mni = new JMenuItem("Administrator");
	boolean isShow;

	public Home() {
		init();
	}

	public void init() {

		// 初始化7个水平box
		for (int i = 0; i < 7; i++) {
			h[i] = Box.createHorizontalBox();
		}
		// 竖直box加7个水平box
		for (int i = 0; i < 7; i++) {
			v.add(h[i]);
		}
		// 每个水平box加panel
		for (int i = 1, j = 1; i < 7; i++, j++) {
			h[i].add(Box.createHorizontalStrut(30));
			p[j] = new JPanel();
			h[i].add(p[j]);
			p[j].setOpaque(false);
			h[i].add(Box.createHorizontalStrut(30));
		}
		
		//令label 居左
		p[2].setLayout(new FlowLayout(FlowLayout.LEFT));
		p[4].setLayout(new FlowLayout(FlowLayout.LEFT));
		p[6].setLayout(new FlowLayout(FlowLayout.LEFT));

		//设置菜单栏的颜色，在菜单栏中加Menu和MenuItem
		mb.setColor(new Color(50, 50, 50));
		h[0].add(mb);
		mb.add(mn1);
		mn1.add(mni);
		mni.addActionListener(new AdminAL());
		
		mb.add(Box.createHorizontalGlue());
		
		mb.add(mn2);
		mn2.addActionListener(new ExitAL());
		//给菜单加监听器
		mn2.addMenuListener(new MenuListener() {
	        @Override
	        public void menuSelected(MenuEvent e) {
	            System.out.println("menuSelected");
	            System.exit(0);
	        }
	        @Override
	        public void menuDeselected(MenuEvent e) {
	            System.out.println("menuDeselected");
	        }
	        @Override
	        public void menuCanceled(MenuEvent e) {
	            System.out.println("menuCanceled");

	        }
	    });
		
		titleL.setFont(font);
		titleL.setForeground(new Color(138, 205, 72));
		p[1].add(titleL);

		p[2].add(Box.createHorizontalStrut(20));
		note1.setForeground(new Color(106, 143, 200));
		p[2].add(note1);

		Border noBorder = new LineBorder(Color.white, 2);

		b1.setPreferredSize(new Dimension(100, 30));
		b1.setBorder(noBorder);
		b1.setForeground(new Color(108, 175, 42));
		b1.setBackground(Color.white);
		b1.addActionListener(new RegAL());
		p[3].add(b1);

		p[4].add(Box.createHorizontalStrut(20));
		note2.setForeground(new Color(106, 143, 200));
		p[4].add(note2);
		b2.setPreferredSize(new Dimension(100, 30));
		b2.setBorder(noBorder);
		b2.setForeground(new Color(108, 175, 42));
		b2.setBackground(Color.white);
		p[5].add(b2);
		Border thin = new LineBorder(Color.white, 1);
		exitB.setOpaque(true);
		exitB.setPreferredSize(new Dimension(60, 20));
		exitB.setBorder(thin);
		exitB.setForeground(new Color(10, 10, 10));
		exitB.setBackground(new Color(250, 250, 250));
		
		mn2.addActionListener(new ExitAL());

		f.setUndecorated(true);
		f.add(v);
		v.setOpaque(true);
		v.setBackground(new Color(50, 50, 50));
		UIs.setGeneral(f);
		f.setVisible(true);
	}

	//监听器 调出登录表，并隐藏首页
	class RegAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new RgstEnter().enter();
			f.setVisible(false);
		}
	}
	// 监听器 退出系统，
	class ExitAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}

	// 监听器， 打开注册界面并隐藏首页
	class AdminAL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			System.out.println("Selected: " + e.getActionCommand());
			new AdminLogin().init();
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Home();
		});
	}
}
