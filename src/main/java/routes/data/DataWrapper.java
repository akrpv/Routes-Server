package routes.data;


import java.sql.*;
import java.util.ArrayList;


public class DataWrapper {


    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection conn;
        String dburl = "jdbc:sqlite:./Routes_db.db";
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





    public static ArrayList<Place> getPlacesByCategoryId(long categoryId) throws  ClassNotFoundException, SQLException {
        ArrayList<Place> PlaceList = new ArrayList<>();

        Connection connection = getConnection();

        PreparedStatement st2 = connection.prepareStatement("SELECT time FROM Categories WHERE id = " + categoryId);
        ResultSet r2 = st2.executeQuery();
        int time = 0;
        while(r2.next()){

             time = r2.getInt(1);
        }
        PreparedStatement st = connection.prepareStatement("SELECT Category_id,x,y,name FROM Places WHERE Category_id = " + categoryId);
        ResultSet r1 = st.executeQuery();

        while(r1.next()){

            PlaceList.add(new Place(r1.getLong("Category_id"), r1.getDouble("x"),r1.getDouble("y"),r1.getString("name"),time));
        }

        closeDB(connection);
        return PlaceList;
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
