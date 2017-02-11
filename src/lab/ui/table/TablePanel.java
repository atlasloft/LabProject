package lab.ui.table;

/**
 * Created by minute on 2017/2/7.
 */

//import lab.ui.table.TestTableModel;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * TablePanel is just like SimpleTableDemo, except that it uses a custom
 * TableModel.
 */
public class TablePanel extends JPanel {
    private boolean DEBUG = false;

    public TablePanel() {
        //scrollpane以table为参数构造
//        panel上添加scollpane组件

        super(new GridLayout(1, 0));
        TestTableModel tm = new TestTableModel();
        Object[][] data = {{1,2,3,4,5},{3,34,4,45,null}};
        tm.setData(data);
        JTable table = new JTable(tm);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("TablePanel");
        JPanel contentP = new JPanel();
        Box v = Box.createVerticalBox();
        Box h = Box.createHorizontalBox();
        Box h2 = Box.createHorizontalBox();
        TablePanel tablePanel = new TablePanel();
        tablePanel.setOpaque(true); //content panes must be opaque


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentP);
        contentP.add(tablePanel);
        contentP.add(v);
        v.add(h);
        v.add(h2);

        h.add(tablePanel);
        h2.add(new JButton("Hello"));
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


