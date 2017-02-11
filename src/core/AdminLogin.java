package core;

import component.MyButton;
import component.*;

import javax.swing.*;
import java.awt.*;

//import db.Tools;

//管理员登录界面
public class AdminLogin {
    private JFrame f = new JFrame("报名表");
    private Box v = Box.createVerticalBox();
    private Box h0 = Box.createHorizontalBox();
    private Box h1 = Box.createHorizontalBox();
    private Box h2 = Box.createHorizontalBox();
    private Box h3 = Box.createHorizontalBox();
    private MyLabel idL = new MyLabel("输入账号");
    private MyTextField tf = new MyTextField(20);
    private MyLabel pwL = new MyLabel("输入密码");
    private MyLabel title = new MyLabel("你好，管理员");
    private MyPasswordField pwf = new MyPasswordField(20);
    private MyButton b = new MyButton("获取管理权限");
    private JPanel p = new JPanel();

    public void init() {
        title.setForeground(new Color(119, 179, 219));
        title.setFont(MyFonts.TITLE);
        f.add(v);
        v.setOpaque(true);
        v.setBackground(new Color(50, 50, 50));
        v.add(h0);
        h0.add(Box.createHorizontalStrut(20));
        h0.add(title);
        h0.add(Box.createHorizontalGlue());
        v.add(Box.createVerticalStrut(20));
        v.add(h1);
        h1.add(Box.createHorizontalStrut(20));
        h1.add(idL);
        h1.add(tf);
        h1.add(Box.createHorizontalStrut(20));
        v.add(Box.createVerticalStrut(20));
        v.add(h2);
        h2.add(Box.createHorizontalStrut(20));
        h2.add(pwL);
        h2.add(pwf);
        h2.add(Box.createHorizontalStrut(20));
        v.add(Box.createVerticalStrut(20));
        v.add(h3);
        p.setOpaque(false);
        h3.add(p);
        p.add(b);

        f.setUndecorated(true);
        UIs.setGeneral(f);
        f.setVisible(true);
    }

    //监听器 点击按钮，与数据库进行匹配，匹配成功 弹出表格，匹配失败 弹出权限获取失败的 窗口
//	class LoginAL implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			Tools tools = new Tools();
//			try {
//				tools.initParam("src/etc/mysql.ini");
//				String password = new String(pwf.getPassword());
//				isMatch = tools.validate(tf.getText(),password);
//
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			if(isMatch){
//				new AdminTableV().init();
//			}else{
//				JOptionPane.showMessageDialog(null, "权限获取失败", null, JOptionPane.ERROR_MESSAGE);
//
//			}
//		}
//	}


    public static void main(String[] args) {
        new AdminLogin().init();
    }
}
