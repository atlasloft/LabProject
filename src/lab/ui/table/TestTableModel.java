package lab.ui.table;

import javax.swing.table.AbstractTableModel;

/**
 * Created by minute on 2017/2/8.
 */
class TestTableModel extends AbstractTableModel {
    private String[] columnNames = {"姓名", "学号", "手机号码", "qq", "专业班级", "已加入的其他组织", "密码"};

    public TestTableModel() {
    }

    public Object[][] getData() {
        return data;
    }

    private Object[][] data;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
    //返回三种情况,空结果,非空结果,连接异常
}