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

        } catch (Exception e) {

        }

    }
}
