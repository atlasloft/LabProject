package lab.ui;

/**
 * Created by minute on 2017/2/7.
 */
import javax.swing.*;

public class JFrameFadeOut extends JFrame {
    JLabel l = new JLabel("Hello");
    public JFrameFadeOut() {
        this.add(l, SwingConstants.CENTER );
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
    }
    static class FadeOut extends Thread {
        private JFrameFadeOut wnd;
        public FadeOut(JFrameFadeOut wnd) {
            this.wnd = wnd;
        }
        public void run() {
            try {
                for (int i = 100; i > 0; i--) {
                    Thread.sleep(70);
                    wnd.setOpacity(i / 100f);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            wnd.setVisible(false);
        }
    }

    public static void main(String[] args) {
        JFrameFadeOut wnd = new JFrameFadeOut();
        wnd.setVisible(true);
        new FadeOut(wnd).start();
    }
}
