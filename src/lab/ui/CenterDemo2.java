package lab.ui;

/**
 * Created by minute on 2017/2/7.
 */
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class CenterDemo2 {
    public static void main(final String[] args ) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Test frame");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500,200);
                final JLabel label = new JLabel("Test label");

                label.setBorder(new LineBorder(Color.BLUE, 2)); //Adding a border for clarity.

                //Most significant two lines of code:
                final JPanel containerPanel = new JPanel(new GridBagLayout());
                containerPanel.add(label);

                frame.getContentPane().add(containerPanel); //or: frame.setContentPane(containerPanel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}