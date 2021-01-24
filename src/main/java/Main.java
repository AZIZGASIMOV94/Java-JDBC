import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume_db";
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url,username, password);
        System.out.println(con.getClass().getName());
        Statement statement = con.createStatement();
        statement.execute("SELECT * FROM user_table");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String st = resultSet.getString("name");
            String st1 = resultSet.getString("surname");
            String st2 = resultSet.getString("email");
            String st3 = resultSet.getString("phone");
            System.out.println(id+" "+st+" "+st1+" "+st2+" "+st3);
        }
    }
}
