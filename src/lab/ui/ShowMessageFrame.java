package lab.ui;

/**
 * Created by minute on 2017/2/7.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ShowMessageFrame extends javax.swing.JFrame {
    private JLabel text;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screensize = tk.getScreenSize();
    int height = screensize.height;
    int width = screensize.width;
    private String str = null;

    public ShowMessageFrame(String str) {
        this.str = str;
        new Thread(new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
        }).start();
    }

    private void initGUI() {
        try {
            setUndecorated(true);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                text = new JLabel("<html>" + str + "</html>", JLabel.CENTER);
                getContentPane().add(text, BorderLayout.CENTER);
                text.setBackground(new java.awt.Color(255, 251, 240));
            }
            pack();
            setBounds(width / 2 - 180, height - 150, 360, 100);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ShowMessageFrame("⊙_⊙");
    }

}