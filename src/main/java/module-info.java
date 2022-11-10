module com.example.ntstock {
    requires javafx.controls;
    requires javafx.fxml;

    opens SignIn to javafx.fxml;
    exports SignIn;

    opens SignUp to javafx.fxml;
    exports SignUp;

    opens CustomerDashboard to javafx.fxml;
    exports CustomerDashboard;

    opens RetailerDashboard to javafx.fxml;
    exports RetailerDashboard;

    opens DealerDashboard to javafx.fxml;
    exports DealerDashboard;

    opens AdministratorDashboard to javafx.fxml;
    exports AdministratorDashboard;
}