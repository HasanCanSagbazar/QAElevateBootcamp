package model;

public class Login {

    private String userName;
    private String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
