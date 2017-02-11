package core;

import component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by minute on 2017/2/4.
 */

/**
 * 关于box
 * <p>
 * 标题栏,退出,最小化按钮
 * 标题
 * 标签+文本框 共 7 * 2;
 * 按钮
 */
public class RgstView {

    public void fillRecord() {
        record.name = nmTF.getText();
        record.id = Long.parseLong(idTF.getText());
        record.tel = Long.parseLong(telTF.getText());
        record.qq = Long.parseLong(qqTF.getText());
        record.major = majorTF.getText();
        record.other = otherTF.getText();
        record.password = new String(pwf.getPassword());
    }


    public Record getRecord() {
        return record;
    }

    private Record record = new Record();


    //组件数目
    private final int INFO_HBOX_NUM = 14;
    private final int PNL_NUM = 7;
    private final int TF_NUM = 6;


    private JFrame f = new JFrame("报名表");
    private Box v = Box.createVerticalBox();

    private Box headH = Box.createHorizontalBox();
    private Box bodyV = Box.createVerticalBox();

    private Box titleH = Box.createHorizontalBox();
    private Box[] infoH = new Box[INFO_HBOX_NUM];
    private Box btnH = Box.createHorizontalBox();

    //    private MyTextField[] infoTF = new MyTextField[TF_NUM];
    private MyTextField nmTF = new MyTextField(20);
    private MyTextField idTF = new MyTextField(20);
    private MyTextField telTF = new MyTextField(20);
    private MyTextField qqTF = new MyTextField(20);
    private MyTextField majorTF = new MyTextField(20);
    private MyTextField otherTF = new MyTextField(20);

    private MyPasswordField pwf = new MyPasswordField(20);
    private JPanel[] p = new JPanel[PNL_NUM];

//    private JButton exitB = GUI.createSimpleButton("Exit");
//    private JButton submitB = GUI.createSimpleButton("Submit");

    private MyButton submB = new MyButton("提交");
    private MyButton resetB = new MyButton("重置");
    private MyButton exitB = new MyButton("退出");

//    private JButton submB = new JButton("提交");
//    private JButton resetB = new JButton("重置");
//    private JButton exitB = new JButton("退出");


    private MyLabel nmL = new MyLabel("您的姓名");
    private MyLabel idL = new MyLabel("您的学号");
    private MyLabel telL = new MyLabel("您的电话号码");
    private MyLabel qqL = new MyLabel("您的qq");
    private MyLabel majorL = new MyLabel("您的年级和专业");
    private MyLabel otherL = new MyLabel("您已经参加的其他组织");
    private MyLabel pwL = new MyLabel("设置密码来保护您的报名信息");

    MyLabel[] labelArr = {nmL, idL, telL, qqL, majorL, otherL, pwL};
    MyTextField[] tfArr = {nmTF, idTF, telTF, qqTF, majorTF, otherTF};

    public JFrame getF() {
        return f;
    }

    /**
     * CONSTRUCTOR
     */
    public RgstView() {
        init();
    }


    public void init() {
        //初始化组件
        f.setUndecorated(true);

        //初始化 info模块 的14个水平box
        for (int i = 0; i < INFO_HBOX_NUM; i++) {
            infoH[i] = Box.createHorizontalBox();
        }
        bodyV.setOpaque(true);
        bodyV.setBackground(new Color(50, 50, 50));

        //初始化8个panel
        for (int i = 0; i < PNL_NUM; i++) {
            p[i] = new JPanel();
        }

//        这行代码有问题,想在stack overflow上问 ArrayList<MyLabel> LabelList = new ArrayList<MyLabel>(idL,nmL,telL,qqL,majorL,otherL,pwL);
        //编译器给的错误提示是无法解析构造器
        /**
         * 组件布局
         */
        f.getContentPane().add(bodyV);

        //bodyV添加info模块
        for (int i = 0; i < INFO_HBOX_NUM; i++) {
            bodyV.add(infoH[i]);
        }
        bodyV.add(btnH);
        bodyV.add(Box.createVerticalStrut(20));


        //在第1, 3, 5, 7, 9, 11个 infoH 上加textfield
        for (int i = 0; i < TF_NUM; i++) {
            infoH[i * 2 + 1].add(Box.createHorizontalStrut(30));
            infoH[i * 2 + 1].add(tfArr[i]);
            infoH[i * 2 + 1].add(Box.createHorizontalStrut(30));
        }
        infoH[13].add(Box.createHorizontalStrut(30));
        infoH[13].add(pwf);
        infoH[13].add(Box.createHorizontalStrut(30));

        //在0, 2, 4, 6, 8, 10, 12 的infoH中加入 panel，并设置流布局，加入strut,让label处于合适的位置
        for (int i = 0; i < INFO_HBOX_NUM/*13*/; i++) {
            if (i % 2 == 0) {
                infoH[i].add(p[i / 2]);
                p[i / 2].add(Box.createHorizontalStrut(30));
                p[i / 2].add(labelArr[i / 2]);
                p[i / 2].setOpaque(false);
                p[i / 2].setLayout(new FlowLayout(FlowLayout.LEFT));
            }
        }

        btnH.add(submB);
        btnH.add(Box.createHorizontalStrut(60));
        btnH.add(resetB);
        btnH.add(Box.createHorizontalStrut(60));
        btnH.add(exitB);
//        UIs.setGeneral(f);
        f.setUndecorated(true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    /**
     * 装饰者模式的监听器
     *
     * @param al
     */

    public void addSubmListener(ActionListener al) {
        submB.addActionListener(al);
    }

    public void addExitListener(ActionListener al) {
        exitB.addActionListener(al);
    }

    public void addResetListener(ActionListener al) {
        resetB.addActionListener(al);
    }

    public void reset() {
        pwf.setText("");
        for (int i = 0; i < TF_NUM; i++) {
            tfArr[i].setText("");
        }
    }

    public void setVisible(Boolean b) {
        f.setVisible(b);
    }

    /**
     * Created by minute on 2017/2/6.
     */

}