package core;

import component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by minute on 2017/2/6.
 */
public class AdminLoginV {
    public AdminLoginV() {
        init();
    }

    private long id;
    private String password;

    public long getId() {
        id = Long.parseLong(idTF.getText());
        return id;
    }

    public String getPassword() {
        password = new String(pwf.getPassword());
        return password;
    }

    private JFrame f = new JFrame("报名表");
    private Box v = Box.createVerticalBox();
    private Box h0 = Box.createHorizontalBox();
    private Box h1 = Box.createHorizontalBox();
    private Box h2 = Box.createHorizontalBox();
    private Box h3 = Box.createHorizontalBox();
    private MyLabel idL = new MyLabel("输入账号");
    private MyTextField idTF = new MyTextField(20);
    private MyLabel pwL = new MyLabel("输入密码");
    private MyLabel titleL = new MyLabel("你好，管理员");
    private MyPasswordField pwf = new MyPasswordField(20);
    private MyButton loginB = new MyButton("登录");
    private MyButton backB = new MyButton("返回");
    private JPanel p = new JPanel();

    public JFrame getF() {
        return f;
    }

    public void init() {
        titleL.setForeground(new Color(119, 179, 219));
        titleL.setFont(MyFonts.TITLE);

        f.add(v);
        v.setOpaque(true);
        v.setBackground(new Color(50, 50, 50));
        v.add(h0);
        v.add(Box.createVerticalStrut(20));
        v.add(h1);
        v.add(Box.createVerticalStrut(20));
        v.add(h2);
        v.add(Box.createVerticalStrut(20));
        v.add(h3);

        h0.add(Box.createHorizontalStrut(20));
        h0.add(titleL);
        h0.add(Box.createHorizontalGlue());

        h1.add(Box.createHorizontalStrut(20));
        h1.add(idL);
        h1.add(Box.createHorizontalStrut(10));
        h1.add(idTF);
        h1.add(Box.createHorizontalStrut(20));

        h2.add(Box.createHorizontalStrut(20));
        h2.add(pwL);
        h2.add(Box.createHorizontalStrut(10));
        h2.add(pwf);
        h2.add(Box.createHorizontalStrut(20));

        p.setOpaque(false);
        h3.add(p);
        p.add(loginB);
        p.add(Box.createHorizontalStrut(30));
        p.add(backB);

        f.pack();
//        f.setUndecorated(true);
//        f.setLocationRelativeTo(null);
        UIs.setGeneral(f);
//        f.setVisible(true);
    }

    void addLoginListener(ActionListener al) {
        loginB.addActionListener(al);
    }


    void addBackListener(ActionListener al) {
        backB.addActionListener(al);
    }

    public void setVisible(boolean b) {
        f.setVisible(b);
    }

    public static void main(String[] args) {
        new AdminLoginV();
    }


//    监听器 点击按钮，与数据库进行匹配，匹配成功 弹出表格，匹配失败 弹出权限获取失败的 窗口


}
