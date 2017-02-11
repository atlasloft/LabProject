package lab.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Created by minute on 2017/2/4.
 */
public class Te {
    public ComboPooledDataSource ds = new ComboPooledDataSource();

    public void initDS() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("etc/mysql.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds.setDriverClass(props.getProperty("driver"));
            System.out.println(props.getProperty("driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(props.getProperty("url"));
        System.out.println(props.getProperty("url"));
        ds.setUser(props.getProperty("user"));
        System.out.println(props.getProperty("user"));
        ds.setPassword(props.getProperty("password"));
        System.out.println(props.getProperty("password"));
    }

    public Te() {
        initDS();
    }

    public static void main(String[] args) throws Exception{
        Te t = new Te();
        Connection conn = t.ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enroll.roster");
        ResultSet rs = pstmt.executeQuery();
        rs.beforeFirst();
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

}
