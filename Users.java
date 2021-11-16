
public class Users {
    private String userName;
    private String password;
    private int id;
    //Builders
    public Users(){}
    public Users(int id, String userName, String password){ this.userName = userName; this.password = password; this.id = id;}
    //Getters & Setters
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public int getId() { return  id; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setId(int id) { this.id = id; }
}