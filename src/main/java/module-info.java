module com.example.ntstock {
    requires javafx.controls;
    requires javafx.fxml;

    opens SignIn to javafx.fxml;
    exports SignIn;

    opens SignUp to javafx.fxml;
    exports SignUp;
}