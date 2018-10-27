package routes.data;


import java.sql.*;
import java.util.ArrayList;


public class DataWrapper {


    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection conn;
        String dburl = "jdbc:sqlite:/Users/aleksandrkurapov/IdeaProjects/Routes-Server/Routes_db.db";


        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(dburl);

        System.out.println("База Подключена!");
        return conn;
    }



    public static void closeDB(Connection conn) throws  SQLException {
        conn.close();


        System.out.println("Соединения закрыты");
    }

    public static ArrayList<Category> getCategories() throws ClassNotFoundException, SQLException {

        ArrayList<Category> listOfCategories = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Categories ");
        ResultSet r1 = st.executeQuery();

        while(r1.next()){

            listOfCategories.add(new Category(r1.getLong("id"), r1.getString("name"),r1.getInt("time")));
        }
        closeDB(connection);
        return listOfCategories;
    }
}
