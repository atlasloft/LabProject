package lab.ui;

/**
 * Created by minute on 2017/2/7.
 */
import java.awt.*;
import javax.swing.*;
//清新脱俗,逼格极高.
public class TableWithTimer  {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private JScrollPane scroll = new JScrollPane();
    private JTable myTable;
    private String[] head = {"One", "Two", "Three", "Four", "Five", "Six"};
    private String[][] data = new String[25][6];

    public TableWithTimer() {
        myTable = new TableBackroundPaint0(data, head);
        myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myTable.setGridColor(Color.gray);
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(myTable);
        frame.add(scroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableWithTimer tableWithTimer = new TableWithTimer();
            }
        });
    }
    class TableBackroundPaint0 extends JTable {

        private static final long serialVersionUID = 1L;

        TableBackroundPaint0(Object[][] data, Object[] head) {
            super(data, head);
            setOpaque(false);
            ((JComponent) getDefaultRenderer(Object.class)).setOpaque(false);
        }

        @Override
        public void paintComponent(Graphics g) {
            Color background = new Color(168, 210, 241);
            Color controlColor = new Color(230, 240, 230);
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            Paint oldPaint = g2.getPaint();
            g2.setPaint(new GradientPaint(0, 0, background, width, 0, controlColor));
            g2.fillRect(0, 0, width, height);
            g2.setPaint(oldPaint);
            for (int row : getSelectedRows()) {
                Rectangle start = getCellRect(row, 0, true);
                Rectangle end = getCellRect(row, getColumnCount() - 1, true);
                g2.setPaint(new GradientPaint(start.x, 0, controlColor, (int) ((end.x + end.width - start.x) * 1.25), 0, Color.orange));
                g2.fillRect(start.x, start.y, end.x + end.width - start.x, start.height);
            }
            super.paintComponent(g);
        }
    }
}