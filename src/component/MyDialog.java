package component;


import javax.swing.*;
import java.awt.*;

/**
 * Created by minute on 2017/2/6.
 */
public class MyDialog extends JDialog{
    public MyDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }
    private int state;

    public int getReturnStatus(){
        return state;
    }
}

