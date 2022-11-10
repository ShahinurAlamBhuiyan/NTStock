package SignIn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignIn extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignIn.class.getResource("sign-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NTStock");
        stage.setScene(scene);
        stage.show();
    }
    // merge with

    public static void main(String[] args) {
        launch();
    }
}


class UserInformation{
    private String email;
    private String password;
    private String role;
    private String username;
    private String gender;

    private String birthday;
    private String area;
    private String creatingTime;


    public UserInformation(String email, String password, String role, String username, String gender, String birthday,String area, String creatingTime) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.area = area;
        this.creatingTime = creatingTime;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}