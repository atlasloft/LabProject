package lab.ui;

/**
 * Created by minute on 2017/2/7.
 */
import javax.swing.*;

public class FFrame extends JFrame {
    JLabel l = new JLabel("Hello");
    public FFrame() {
        add(l);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
    }
    static class FadeOut extends Thread {
        private FFrame ff;
        public FadeOut(FFrame wnd) {
            this.ff = wnd;
        }
        public void run() {
            ff.setVisible(true);
            try {
                for (int i = 100; i > 0; i--) {
                    Thread.sleep(7);
                    ff.setOpacity(i / 100f);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ff.setVisible(false);
        }
    }


    public static void main(String[] args) {
        FFrame f = new FFrame();
        f.setUndecorated(true);
        f.setVisible(true);
        new FadeOut(f).start();
    }
}