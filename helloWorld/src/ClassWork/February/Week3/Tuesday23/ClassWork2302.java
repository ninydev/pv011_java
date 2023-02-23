package ClassWork.February.Week3.Tuesday23;

import java.sql.*;

public class ClassWork2302 implements Runnable
{

    @Override
    public void run() {
        firstConnection();
    }

    private void firstConnection() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:52000/pv011",
                    "root", "mypassword");

            System.out.println("DB Ok");

            String sqlQuery = "CREATE TABLE posts (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR (64)" +
                    ")";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlQuery);
            // executeUpdate -- INSERT, UPDATE, CREATE ....
            // executeQuery -- SELECT
            // execute -- true (если есть ответ от SELECT) false



            conn.close();

        } catch (Exception e) {
            System.out.println("DB Error " + e.getMessage());

        }

    }
}
