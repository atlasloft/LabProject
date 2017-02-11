package lab.ui;

import javax.swing.*;

/**
 * Created by minute on 2017/2/7.
 */
public class JTableExample {
    public static void main(String[] args) {
        Object[] column = {"One", "Two"};
        Object[][] data = {{1, 2}, {3, 4}, {5, 6}};

        JTable toDoTable = new JTable(data, column);
        JScrollPane jpane = new JScrollPane(toDoTable);
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        panel.add(jpane);
        frame.add(new JScrollPane(panel));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}