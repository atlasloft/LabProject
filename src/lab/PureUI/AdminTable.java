package lab.PureUI;

import component.DarkTextArea;
import component.MyTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

//import db.Tools;

public class AdminTable {
/*
是这么回事：

*不要从上往下看，一层一层的看
*
一个竖直box中装了：
	|
	|- 水平box1 中装了
	|	|- 竖直box1中装了
	|		|- 一个搜索所有记录的按钮
	|	|- 竖直box2中装了
	|		|- 水平box1 中装了
	|			|- 一个标签
	|		|- 水平box2 中装了
	|			|- 一个文本框
	|- 水平box2 中装了
		|- 一个用于显示查询数据的文本区域


*/	
	//private声明所有组件
	private JFrame f = new JFrame();
	private Box v = Box.createVerticalBox();
	private Box vAlpha1 = Box.createVerticalBox();
	private Box vAlpha2 = Box.createVerticalBox();
	private Box h1 = Box.createHorizontalBox();
	private Box h2 = Box.createHorizontalBox();
	private Box h3 = Box.createHorizontalBox();
	private Box hAlpha1 = Box.createHorizontalBox();
	private Box hAlpha2 = Box.createHorizontalBox();

	private JLabel l = new JLabel("输入学号并回车进行查询");
	private MyTextField tf = new MyTextField(12);
	private JButton searchB = new JButton("查看全部信息");
	private JPanel p = new JPanel();
	private JPanel p0 = new JPanel();
	private DarkTextArea ta = new DarkTextArea(10, 25);
	private JScrollPane sp;

	
	public void init() {
		//监听器 回车查询特定id 
		Action action = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("some action");
					try {
//						Tools tools = new Tools();
//						tools.initParam("src/etc/mysql.ini");
//						ta.setText("ID\tPASSWORD\tNAME\tTEL\tQQ\tMAJOR\tOTHER\tNOTE\n"
//								+ tools.getChoosedRecord(tf.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		};

		//下面那一行我也不知道是什么...但这个 监听器 是查询所有记录的
		
		@SuppressWarnings("serial")
		Action action2 = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				try {
//					Tools tools = new Tools();
//					tools.initParam("src/etc/mysql.ini");
//					ta.setText("ID\tPASSWORD\tNAME\tTEL\tQQ\tMAJOR\tOTHER\tNOTE\n" + tools.getAllRecord());
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		};
		
		
		//对组件进行布局
		f.add(v);
		l.setForeground(new Color(170, 170, 170));
		h1.add(vAlpha1);
		h1.add(vAlpha2);
		
		vAlpha1.add(p0);
		p0.setOpaque(true);
		p0.setBackground(new Color(50,50,50));
		p0.add(searchB);
		
		vAlpha2.add(Box.createVerticalStrut(10));
		vAlpha2.add(hAlpha1);
		vAlpha2.add(Box.createVerticalStrut(10));
		vAlpha2.add(hAlpha2);
		
		hAlpha1.add(Box.createHorizontalStrut(20));
		hAlpha1.add(l);
		hAlpha1.add(Box.createHorizontalGlue());
		hAlpha1.add(Box.createHorizontalStrut(20));
		
		hAlpha2.add(Box.createHorizontalStrut(20));
		tf.addActionListener(action);
		hAlpha2.add(tf);
		hAlpha2.add(Box.createHorizontalStrut(20));
		
		vAlpha2.add(Box.createVerticalStrut(10));

		Border noBorder = new LineBorder(new Color(190, 190, 190), 2);
		searchB.setPreferredSize(new Dimension(120, 60));
		searchB.setBorder(noBorder);
		searchB.setForeground(new Color(108, 175, 42));
		searchB.setBackground(Color.white);
		searchB.addActionListener(action2);

		v.setOpaque(true);
		v.setBackground(new Color(50, 50, 50));
		v.add(Box.createVerticalStrut(10));
		v.add(h1);
		v.add(Box.createVerticalStrut(10));
		v.add(h2);
		v.add(h3);
		p.setLayout(new GridLayout(1, 1));
		TitledBorder tb = new TitledBorder("查询结果");
		tb.setTitleColor(new Color(170, 170, 170));
		// 给panel设置边框
		p.setBorder(tb);
		p.setOpaque(false);
		p.setBackground(Color.green);

		p.setPreferredSize(new Dimension(1200, 300));
		h3.add(p);

		sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setViewportBorder(null);
		p.add(sp);
		sp.setBorder(BorderFactory.createEmptyBorder());

		
		ta.setTabSize(10);
		ta.setFont(new Font("RomanTimes", Font.BOLD, 16));
		ta.setLineWrap(true);// 激活自动换行功能
		ta.setWrapStyleWord(false);// 激活断行不断字功能
		
		
		f.setLocation(40, 40);
		f.setVisible(true);
		f.pack();
		
		

	}
	
	//方法 从文本框中获取 String 转化为 long类型 数值常量 
	public long getId() {
		String str = tf.getText();
		long id = Long.valueOf(str).longValue();
		return id;
	}

	public static void main(String[] args) {
		new AdminTable().init();
	}

}
