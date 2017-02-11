package core;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.ResultSetDynaClass;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by minute on 2017/2/5.
 */
public class DBs {
    /**
     * 插入一条记录
     *
     * @param record
     * @param conn
     */
    public static ComboPooledDataSource ds = null;

    public static void initDS() {
        ds = new ComboPooledDataSource();
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

    public static boolean validate(long id, String password) {
        Connection conn;
        PreparedStatement pstmt;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM enroll.admin WHERE id = ? AND password = ?");
            pstmt.setLong(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            rs.beforeFirst();
            while(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static void insertData(Record record) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO roster (name, id, tel, qq, major, other, password) VALUES(?, ?, ?, ?, ?, ?, ?);");
            pstmt.setString(1, record.name);
            pstmt.setString(2, record.id.toString());
//            pstmt.setString(2,record.input);
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

    public static void searchByName(String name, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM enroll.roster WHERE name = ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过id进行查询
     * @param input
     */
    public static Object[][] searchById(long input) {
        Object[][] data = null;

        PreparedStatement pstmt = null;
        Connection conn = null;
        int rowCount = 0;
        try {
            String regex = "\'"+input+"\\d*\'";
            System.out.println(regex);
            conn = ds.getConnection();
            System.out.println("Connection got");
            pstmt = conn.prepareStatement("SELECT * FROM enroll.roster WHERE id REGEXP ?;");
            pstmt.setLong(1,input);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Query executed !");
            while(rs.next()){
                System.out.println(rs.getLong(2));
                rowCount++;
            }
            System.out.println("row count = "+rowCount);
            data = new Object[rowCount][7];
            int r = 0;
            rs.beforeFirst();//极为重要的一句
            while(rs.next()){
                data[r][0] = rs.getString(1);
                data[r][1] = rs.getLong(2);
                data[r][2] = rs.getLong(3);
                data[r][3] = rs.getLong(4);
                data[r][4] = rs.getString(5);
                data[r][5] = rs.getString(6);
                data[r][6] = rs.getString(7);
                r++;
            }

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(data[i][j]+"\t");
                }
                System.out.println();
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public static void searchData(Connection conn) {
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = conn.prepareStatement("SELECT * FROM enroll.roster");
//            rs = pstmt.executeQuery();
//            rs.beforeFirst();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        initDS();
//        searchById(5416);
//    }

}