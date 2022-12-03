package Auths.SignIn;

public class UserInformation {
    private String email;
    private String password;
    private String role;
    private String username;
    private String gender;

    private String birthday;
    private String creatingTime;
    private String userRandomId;


    public UserInformation(String email, String password, String role, String username, String gender, String birthday,  String creatingTime, String userRandomId) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.creatingTime = creatingTime;
        this.userRandomId = userRandomId;
    }

    public UserInformation(String username, String email, String birthday) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getUserRandomId() {
        return userRandomId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(String creatingTime) {
        this.creatingTime = creatingTime;
    }


}
