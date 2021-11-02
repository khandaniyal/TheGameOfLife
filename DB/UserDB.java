package DB;
import Model.Users;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    ////needs a repath to connect
    private static final String JDBC_CONNECTION = "jdbc:sqlite:" + UserContracts.TABLE_NAME;
    //table creation query
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + UserContracts.TABLE_NAME +
                                               " (" + UserContracts.TABLE_ID + " INTEGER PRIMARY KEY AUTO INCREMENT," +
                                               UserContracts.TABLE_USERNAME + "VARCHAR(20)," +
                                               UserContracts.TABLE_PASSWORD + "VARCHAR(20));";
    //table delete query
    private static final String DELETE_TABLE = "DELETE TABLE IF EXISTS " + UserContracts.TABLE_NAME;
    //sqlite connection
    private Connection connection = null;
    //builer
    public UserDB(){ super(); }
    //connects to the db
    public void connectDB()throws SQLException{
        if(connection != null) return;
        connection = DriverManager.getConnection(JDBC_CONNECTION);
    }
    //disconnects the db
    public void disconnectDB()throws SQLException{ if(connection == null) connection.close(); }
    //creates the table using the constant variable query
    public void createTable()throws SQLException{
        Statement st = null;
        try{
            st = connection.createStatement();
            st.executeUpdate(CREATE_TABLE);
        }finally { if(st != null) st.close(); }
    }
    //deletes the current table if exists
    public void deleteTable()throws SQLException {
        Statement st = null;
        try{
            st = connection.createStatement();
            st.executeUpdate(DELETE_TABLE);
        }finally { if(st != null) st.close(); }
    }
    //reads from the db
    public ArrayList<Users> getAllData()throws SQLException{
        String query = "Select " + UserContracts.TABLE_ID + ", " +  UserContracts.TABLE_USERNAME + ", " +
                UserContracts.TABLE_PASSWORD + " from " + UserContracts.TABLE_NAME +
                "where " + UserContracts.TABLE_USERNAME + " not like 'sqlite%' " +
                "order by " + UserContracts.TABLE_USERNAME + ";";

        ArrayList<Users> users = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            Users user = new Users();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt(0));
                user.setUserName(rs.getString(1));
                user.setPassword(rs.getString(2));
                users.add(user);
            }
            rs.close();
            return users;
        }
    }
}
