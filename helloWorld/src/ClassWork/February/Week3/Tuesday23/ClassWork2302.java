package ClassWork.February.Week3.Tuesday23;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class ClassWork2302 implements Runnable
{

    @Override
    public void run() {
        hibernateConnection();
    }

    private void hibernateConnection(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    }



    private void firstConnection() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:52000/pv011",
                    "root", "mypassword");

            System.out.println("DB Ok");

            String sqlQuery;

            Statement statement = conn.createStatement();
            // executeUpdate -- INSERT, UPDATE, CREATE ....
            // executeQuery -- SELECT
            // execute -- true (если есть ответ от SELECT) false


//            sqlQuery = "CREATE TABLE posts (" +
//                    "id INT PRIMARY KEY AUTO_INCREMENT," +
//                    "title VARCHAR (64)" +
//                    ")";
//            statement.executeUpdate(sqlQuery);

//            sqlQuery = "INSERT INTO posts (title) VALUES('First Post'), ('Second Post')";
//            statement.executeUpdate(sqlQuery);

//            sqlQuery = "SELECT * from posts";
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString("title");
//
//                System.out.println(id + " " + title);
//            }

            sqlQuery = "SELECT * from posts WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString("title");

                System.out.println(id + " " + title);
            }



            conn.close();

        } catch (Exception e) {
            System.out.println("DB Error " + e.getMessage());

        }

    }
}
