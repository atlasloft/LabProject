package core;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import static core.DBs.searchById;

/**
 * Created by minute on 2017/2/7.
 */
public class AdminTableM {
    private long input;
    private MyTableModel tableModel = new MyTableModel();

    public void searchAndUpdate(long input) {
        Object[][] data = DBs.searchById(input);
        System.out.println(data[0][0]);
        tableModel.setData(data);
    }

    public MyTableModel getTableModel() {
        return tableModel;
    }

    public void setInput(long input) {
        this.input = input;
    }

    public long getInput() {
        return input;
    }



}
