package lab.ui;

/**
 * Created by minute on 2017/2/6.
 */

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JOptionPaneERROR_MESSAGE {

    public static void main(String[] args) {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);

    }
}
