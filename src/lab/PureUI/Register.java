package lab.PureUI;

import component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import db.Tools;
//import util.Record;

public class Register {

    private JFrame f = new JFrame("报名表");
    private Box v = Box.createVerticalBox();

    private Box[] h = new Box[16];
    private MyTextField[] tf = new MyTextField[6];

    private JPanel[] p = new JPanel[8];
    //   private JPanel p = new JPanel();
    //id
    private MyLabel idL = new MyLabel("您的学号");

    //password

    private MyPasswordField pwf = new MyPasswordField(20);
    //name
    private MyLabel nmL = new MyLabel("您的姓名");
    //tel
    private MyLabel telL = new MyLabel("您的电话号码");
    //qq
    private MyLabel qqL = new MyLabel("您的qq");
    //class&grade
    private MyLabel majorL = new MyLabel("您的年级和专业");
    //Other organization you have joined
    private MyLabel otherL = new MyLabel("您已经参加的其他组织");
    //YourNote
    private MyLabel pwL = new MyLabel("设置密码来保护您的报名信息");

    private MyLabel noteL = new MyLabel("留言板");
    private MyTextArea noteTA = new MyTextArea(3, 20);

    private JButton exitB = UIs.createSimpleButton("Exit");

    public JButton submitB = UIs.createSimpleButton("Submit");
//	Tools tools = new Tools();


    public void init() {
        //初始化16个水平box
        for (int i = 0; i < 16; i++) {
            h[i] = Box.createHorizontalBox();
        }

        Box hTail = Box.createHorizontalBox();


        //初始化6个textfield
        for (int i = 0; i < 6; i++) {
            tf[i] = new MyTextField(20);
        }
        f.add(v);
        v.setOpaque(true);
        v.setBackground(new Color(50, 50, 50));
        v.add(Box.createVerticalStrut(80));
        //垂直box加入16个水平box
        for (int i = 0; i < 16; i++) {
            v.add(h[i]);
        }
        v.add(hTail);

        //在6个水平box上加textfield
        for (int i = 1, j = 0; i < 12; i = i + 2, j++) {
            h[i].add(Box.createHorizontalStrut(30));
            h[i].add(tf[j]);
            h[i].add(Box.createHorizontalStrut(30));
        }

        //初始化8个panel
        for (int i = 0; i < 8; i++) {
            p[i] = new JPanel();
        }

        //0,2,4...的水平box中加入panel，并设置流布局，加入strut,让label处于合适的位置
        for (int i = 0, j = 0; (j < 8) && (i < 16); i = i + 2, j++) {
            p[j] = new JPanel();
            h[i].add(p[j]);
            p[j].setOpaque(false);
            p[j].setLayout(new FlowLayout(FlowLayout.LEFT));
            p[j].add(Box.createHorizontalStrut(30));
        }


        p[0].add(idL);
        idL.setHorizontalAlignment(SwingConstants.LEFT);
        p[1].add(nmL);
        p[2].add(telL);
        p[3].add(qqL);
        p[4].add(majorL);
        p[5].add(otherL);
        p[6].add(pwL);
        p[7].add(noteL);
        h[13].add(Box.createHorizontalStrut(30));
        h[13].add(pwf);
        h[13].add(Box.createHorizontalStrut(30));
        h[15].add(Box.createHorizontalStrut(30));
        h[15].add(noteTA);
        h[15].add(Box.createHorizontalStrut(30));
        hTail.add(exitB);

        exitB.addActionListener(new ExitListener());
        submitB.addActionListener(new SubmitListener());
        hTail.add(submitB);
        v.add(Box.createVerticalStrut(20));

        //JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
        f.setUndecorated(true);
        UIs.setGeneral(f);


    }

    //注册表和 查询表//
    class ExitListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            System.exit(0);


        }
    }
//都需要实现的功能 可以通过接口实现

    public long getId() {
        String str = tf[0].getText();
        long id = Long.valueOf(str).longValue();
        return id;
    }

    public String getPw() {
        String pw = new String(pwf.getPassword());
        return pw;
    }

    public String getNm() {
        String nm = tf[1].getText();
        return nm;
    }

    public long getTel() {
        String str = tf[0].getText();
        long tel = Long.valueOf(str).longValue();
        return tel;
    }

    public long getQQ() {
        String str = tf[3].getText();
        long qq = Long.valueOf(str).longValue();
        return qq;
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            try {
//    			tools.initParam("src/etc/mysql.ini");
//    			tools.submit(getRecord());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public String getMajor() {
        String str = tf[4].getText();
        return str;
    }

    public String getOther() {
        String str = tf[5].getText();
        return str;
    }

    public String getNote() {
        String str = noteTA.getText();
        return str;

    }

    //    public Record getRecord(){
//    	Record record = new Record();
//    	record.setInput(getInput());
//    	record.setPassword(getPw());
//    	record.setName(getNm());
//    	record.setTel(getTel());
//    	record.setQQ(getQQ());
//    	record.setMajor(getMajor());
//    	record.setNote(getNote());
//    	return record;
//    }
    public static void main(String[] args) {
        new Register().init();
    }


}