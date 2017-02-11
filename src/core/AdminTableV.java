package core;

import component.DarkTextArea;
import component.MyTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import java.awt.*;

//import db.Tools;

public class AdminTableV {

    long input;


    private MyTextField tf = new MyTextField(12);
    private JLabel l = new JLabel("输入学号并回车进行查询");
    private JButton searchB = new JButton("查看全部信息");
    private JPanel contentP = new JPanel();
    private JPanel tableP = new JPanel();
    private JPanel buttonP = new JPanel();
    private JScrollPane sp;
    private JTable table = new JTable();

    private JFrame f = new JFrame();
    private Box v = Box.createVerticalBox();
    private Box h1 = Box.createHorizontalBox();
    private Box h1v1 = Box.createVerticalBox();
    private Box h1v2 = Box.createVerticalBox();
    private Box h2 = Box.createHorizontalBox();
    private Box h3 = Box.createHorizontalBox();

    public AdminTableV() {
        init();
    }


    public void init() {
        /**
         * test
         */

//        MyTableModel tm = new MyTableModel();
//        Object[][] data = {{1, 2, 3, 4, 5, 6, 7}};
//        tm.setData(data);
//
//        table.setModel(tm);
        Border border = new LineBorder(new Color(190, 190, 190), 2);
        searchB.setPreferredSize(new Dimension(120, 60));
        searchB.setBorder(border);
        searchB.setForeground(new Color(108, 175, 42));
        searchB.setBackground(Color.white);

        //对组件进行布局


        contentP.setOpaque(true);
        v.setOpaque(true);
        v.setBackground(new Color(50, 50, 50));
        l.setForeground(new Color(170, 170, 170));
        //在scrollpane中加入ta的代码

        /**
         * 布局开始
         */
        f.setContentPane(contentP);
        contentP.add(v);
        v.add(h1);
        v.add(h2);
        v.add(h3);
        h1.add(h1v1);
        h1.add(h1v2);

        h1v1.add(searchB);
        searchB.setAlignmentX(Component.CENTER_ALIGNMENT);

        h1v2.add(l);
        h1v2.add(Box.createVerticalStrut(10));
        h1v2.add(tf);
        table.setVisible(true);
        sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        sp.setViewportBorder(null);
//        sp.setBorder(BorderFactory.createEmptyBorder());
        h3.add(sp);
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }




    public void addEnterPressListener(Action action) {
        tf.addActionListener(action);
    }

    public void addButtonSearchListener(Action action) {
        searchB.addActionListener(action);
    }

    public void setVisible(boolean b) {
        f.setVisible(b);
    }

    //方法 从文本框中获取 String 转化为 long类型 数值常量
    public long getInput() {
        input = Long.parseLong(tf.getText());
        return input;
    }

    public JFrame getF() {
        return f;
    }

    public void setTableModel(TableModel tableModel) {
        table.setModel(tableModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new AdminTableV()
        );
    }


}
