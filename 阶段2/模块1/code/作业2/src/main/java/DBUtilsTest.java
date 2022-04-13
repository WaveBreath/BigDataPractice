import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilsTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name=? AND gender = ?;");
            preparedStatement.setString(2,"男");
            preparedStatement.setString(1,"赵雷");
            resultSet = preparedStatement.executeQuery();
            String[] tool={"id","name","gender","salary","bonus","join_date"};
            while(resultSet.next()){
                for(int i=1;i<= tool.length;i++)
                    System.out.println(tool[i-1]+":"+resultSet.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection,preparedStatement,resultSet);
        }


    }
}
