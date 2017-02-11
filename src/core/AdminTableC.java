package core;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by minute on 2017/2/7.
 */
public class AdminTableC {
    public AdminTableV v;
    public AdminTableM m;

    public static void main(String[] args) {
        AdminTableV v = new AdminTableV();
        AdminTableM m = new AdminTableM();
        AdminTableC c = new AdminTableC(v,m);
//        v.setVisible(true);
    }

    /**
     * CONSTRUCTOR
     * @param v
     * @param m
     */
    public AdminTableC(AdminTableV v, AdminTableM m) {
        DBs.initDS();
        this.v = v;
        this.m = m;
        v.addButtonSearchListener(buttonPressA);
        v.addEnterPressListener(enterPressA);
    }

    //根据输入内容查询
    Action enterPressA = new AbstractAction() {
        /**
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m.setInput(v.getInput());
                m.searchAndUpdate(m.getInput());
                v.setTableModel(m.getTableModel());
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(v.getF(), "请通过学号进行查询", "格式错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    };


    //查询所有记录
    Action buttonPressA = new AbstractAction() {
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


}
