import java.sql.*;

// https://www.youtube.com/watch?v=e8g9eNnFpHQ
// https://www.tutorialspoint.com/java_mysql/java_mysql_insert_records.htm
public class MyJDBC {

    public static void main(String[] args) throws SQLException {
        String name;
        String surename;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc-video", "root", "Attila");
        Statement statement = connection.createStatement();
        String insertQuery = "insert into people values( 4, 'Johnny', 'walker')";
        try {
            statement.executeUpdate(insertQuery);
        } catch (SQLIntegrityConstraintViolationException ignored){
            System.out.println("Entry already exists: " + insertQuery);
        }

        ResultSet resultSet = statement.executeQuery("select firstname, lastname from people where idpeople > 1");
        while (resultSet.next()) {
            name = (resultSet.getString("firstname"));
            surename = (resultSet.getString("lastname"));
            System.out.println(name + " " + surename);
        }
        //resultSet = statement.executeQuery("select * from people");
    }
}


/*    String insertQuery = "INSERT INTO your_table_name (name, age) VALUES (?, ?)";

            preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, age);*/