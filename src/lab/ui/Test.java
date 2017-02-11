package lab.ui;

import javax.swing.*;

/**
 * Created by minute on 2017/2/6.
 */
public class Test extends JDialog {
    private Object res;

    public Test() {
        //必须是模态对话框才可以做返回值
        this.setModal(true);
        //这里自己写些布局的业务代码
    }

    //执行这个方法即可得到返回值.
    public Object getRes() {
        this.setVisible(true);
        return res;
    }

    public static void main(String args[]) {
        Test t = new Test();
        //执行这个后,会先弹出对话框.在对话框关闭后,即可得到返回值
        Object obj = t.getRes();
    }
}