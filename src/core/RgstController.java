package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by minute on 2017/2/3.
 */
public class RgstController {
    private RgstView rgstView;
    private RgstModel rgstModel;

    public RgstController(RgstModel rgstModel, RgstView rgstView) {
        this.rgstModel = rgstModel;
        this.rgstView = rgstView;
        rgstView.addSubmListener(new SubmListener());
        rgstView.addExitListener(new ExitListener());
        rgstView.addResetListener(new ResetListener());

    }


    class SubmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            rgstView.fillRecord();
            System.out.println(rgstView.getRecord());
            rgstModel.setRecord(rgstView.getRecord());
            System.out.println(rgstModel.getRecord());
            //提交记录
            try {
                rgstModel.submit();
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showConfirmDialog(rgstView.getF(),"程序错误,提交失败","问题提示",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int n = JOptionPane.showConfirmDialog(rgstView.getF(), "确定操作？", "对话框标题", JOptionPane.YES_NO_OPTION);
            if(n==0){
                rgstView.reset();
            }
        }
    }


    private void determine() {
        boolean nameIsOK = Determiner.isPureChinese(rgstView.getRecord().name);

    }
}