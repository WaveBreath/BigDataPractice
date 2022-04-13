import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
    static DataSource dataSource;
    static {
        Properties properties=new Properties();
        FileInputStream fileInputStream=null;
        BasicDataSource basicDataSource=new BasicDataSource();
        try {
            fileInputStream = new FileInputStream("G:\\BigData\\practice\\测试\\task\\src\\main\\resources\\db.properties");
            properties.load(fileInputStream);
            basicDataSource.setDriverClassName(properties.getProperty("driver"));
            basicDataSource.setUrl(properties.getProperty("url"));
            basicDataSource.setUsername(properties.getProperty("user"));
            basicDataSource.setPassword(properties.getProperty("password"));
            dataSource=basicDataSource;
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection con, Statement sta){
        try {
            if (sta != null) {
                sta.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement sta, ResultSet res){
        try {
            if(res!=null)
                res.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        finally {
            close(con, sta);
        }
    }
}
