
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  

public class UserDB {
    ////needs a repath to connect
    //private static final String JDBC_CONNECTION = "jdbc:sqlite:" + UserContracts.TABLE_NAME;
	private static final String JDBC_CONNECTION = "jdbc:sqlite:/home/joaquin_alonsogarcia/Documents/TheGameOfLife/tables.db";
	//table creation query
    private static final String CREATE_TABLE = 
    		"CREATE TABLE IF NOT EXISTS " + UserContracts.TABLE_NAME +"(" + //Problem here
    				UserContracts.TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    UserContracts.TABLE_USERNAME + " VARCHAR(20)," +
                    UserContracts.TABLE_PASSWORD + " VARCHAR(20) "+
                    
            ");";
    //table delete query
    private static final String DELETE_TABLE = "DELETE TABLE IF EXISTS " + UserContracts.TABLE_NAME;
    //sqlite connection
    private Connection connection = null;
    //builer
    public UserDB() throws SQLException{
    	super();
    	System.out.println(CREATE_TABLE);
    	connectDB();
    	createTable();
    	disconnectDB();
    }
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
                " where " + UserContracts.TABLE_USERNAME + " not like 'sqlite%' " +
                "order by " + UserContracts.TABLE_USERNAME + ";";
        System.out.println(query);
        ArrayList<Users> users = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            Users user = new Users();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt(UserContracts.TABLE_ID));
                user.setUserName(rs.getString(UserContracts.TABLE_USERNAME));
                user.setPassword(rs.getString(UserContracts.TABLE_PASSWORD));
                users.add(user);
            }
            rs.close();
            return users;
        }
    }
    
    // Add users to the DB
    public boolean insertUser(String userName, String userPassword)throws SQLException{
        
    	String query = "INSERT INTO "+UserContracts.TABLE_NAME+"("+
        		UserContracts.TABLE_USERNAME+", "+UserContracts.TABLE_PASSWORD+")"
        		+"VALUES ('"+ userName+"'," + "'"+userPassword+"')" ;
    	System.out.println(query);
    	try (Statement statement = connection.createStatement();){
        	int resultSet = statement.executeUpdate(query);
        	int resultado = resultSet;
        	System.out.println(resultado);
        	
        }catch(SQLException e) {
        	System.out.println(e +"Es aquí");
        }
      
        return false; 
		
    }
    
    //Search if on the DB exists an user with the same credentials passed by parameters
    public boolean UserExist(String name, String password) throws SQLException {
    	String query = String.format("SELECT userName, password from users where userName = '%s' AND password = '%s' ",name ,password );
    	System.out.println(query);
    	Statement st = connection.createStatement();
    	ResultSet rs = st.executeQuery(query); //search rawquery
    	
    	
    	
    	
    	ArrayList <Users> listUsersOnDB = getAllData();
    	for ( Users users  : listUsersOnDB ) {
    		System.out.println(users.getUserName()+" "+users.getPassword() );
    		if (users.getUserName().equals(name) && users.getPassword().equals(password)) {
    			return true;
    		}
    	}
		return false;
    	
    }
    
    
}
