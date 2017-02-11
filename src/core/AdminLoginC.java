package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by minute on 2017/2/6.
 */
public class AdminLoginC {
    AdminLoginV adminLoginV = new AdminLoginV();
    AdminLoginM adminLoginM = new AdminLoginM();

    public AdminLoginC(AdminLoginV adminLoginV, AdminLoginM adminLoginM) {
        this.adminLoginV = adminLoginV;
        this.adminLoginM = adminLoginM;
        adminLoginV.addBackListener(new BackAL());
        adminLoginV.addLoginListener(new LoginAL());
    }

    class BackAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminLoginV.setVisible(false);
            new Home();
        }
    }

    class LoginAL implements ActionListener {
        boolean isMatch = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("------");
            adminLoginM.setId(adminLoginV.getId());
            adminLoginM.setPassword(adminLoginV.getPassword());
            DBs.initDS();
            isMatch = DBs.validate(adminLoginM.getId(), adminLoginM.getPassword());
            if (isMatch) {
                JOptionPane.showMessageDialog(adminLoginV.getF(), "登录成功", "你好管理员", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(adminLoginV.getF(), "登录失败", "未通过验证", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        AdminLoginV v = new AdminLoginV();
        AdminLoginM m = new AdminLoginM();
        AdminLoginC c = new AdminLoginC(v, m);
        v.setVisible(true);
    }
}


