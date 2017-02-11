package component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by minute on 2017/2/7.
 */
public class FadingFrame extends JFrame {
    public FadingFrame() {
        setSize(500, 200);
        setUndecorated(true);
        setLocationRelativeTo(null);
    }

    static class splash implements Runnable {
        public splash(FadingFrame ff) {
            this.ff = ff;
        }

        FadingFrame ff = new FadingFrame();
        @Override
        public void run() {
            ff.setVisible(true);
            try {
                for (int i = 100; i < 0; i--) {
                    Thread.sleep(7);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ff.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new FadingFrame();
    }
}
