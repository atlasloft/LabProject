package core;

/**
 * Created by minute on 2017/2/3.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by minute on 2017/2/3.
 */
public class RgstModel {

    public void setRecord(Record record) {
        this.record = record;
    }

    private Record record = new Record();
    private ComboPooledDataSource ds = new ComboPooledDataSource();

    public void initDS() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("etc/mysql.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds.setDriverClass(props.getProperty("driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(props.getProperty("url"));
        ds.setUser(props.getProperty("user"));
        ds.setPassword(props.getProperty("password"));
    }


    public RgstModel() {
        reset();
        initDS();
    }

    /**
     * setter & getter start
     *
     * @return
     */
    public Record getRecord() {
        return record;
    }

    /**
     * reset
     */
    public void reset() {
        record.name = null;
        record.id = null;
        record.tel = null;
        record.qq = null;
        record.major = null;
        record.other = null;
        record.password = null;
    }

    public void submit(){
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO roster (name, id, tel, qq, major, other, password) VALUES(?, ?, ?, ?, ?, ?, ?);");
            pstmt.setString(1, record.name);
            pstmt.setString(2, record.id.toString());
            pstmt.setString(3, record.tel.toString());
            pstmt.setString(4, record.qq.toString());
            pstmt.setString(5, record.major);
            pstmt.setString(6, record.other);
            pstmt.setString(7, record.password);
            //update 方法用于更新和修改
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}

