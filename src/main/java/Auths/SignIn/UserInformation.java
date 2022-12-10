package Auths.SignIn;

public class UserInformation {
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String userName;
    private String gender;

    private String birthday;
    private String creatingTime;
    private String userRandomId;


    public UserInformation(String email, String password, String role, String firstName, String lastName, String gender, String birthday,  String creatingTime, String userRandomId) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.userName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.creatingTime = creatingTime;
        this.userRandomId = userRandomId;
    }

    public UserInformation(String firstName, String lastName, String email, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getUserName() {
        return userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
