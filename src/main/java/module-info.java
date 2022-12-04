module com.example.ntstock {
    requires javafx.controls;
    requires javafx.fxml;

    opens Auths.SignIn to javafx.fxml;
    exports Auths.SignIn;

    opens Auths.SignUp to javafx.fxml;
    exports Auths.SignUp;

    opens Dashboards to javafx.fxml;
    exports Dashboards;



    opens Dashboards.CustomerDashboard to javafx.fxml;
    exports Dashboards.CustomerDashboard;

    opens Dashboards.RetailerDashboard to javafx.fxml;
    exports Dashboards.RetailerDashboard;

    opens Dashboards.DealerDashboard to javafx.fxml;
    exports Dashboards.DealerDashboard;

    opens Dashboards.AdministratorDashboard to javafx.fxml;
    exports Dashboards.AdministratorDashboard;

    opens Slides.SlideOne to javafx.fxml;
    exports Slides.SlideOne;

    opens Slides.SlideTwo to javafx.fxml;
    exports Slides.SlideTwo;

    opens Slides.SlideThree to javafx.fxml;
    exports Slides.SlideThree;

    opens Slides.SlideFour to javafx.fxml;
    exports Slides.SlideFour;

    opens CustomAlertBox to javafx.fxml;
    exports CustomAlertBox;


    opens Sidebars.AdministratorSidebar to javafx.fxml;
    exports Sidebars.AdministratorSidebar;

    opens Sidebars.CustomerSidebar to javafx.fxml;
    exports Sidebars.CustomerSidebar;

    opens Sidebars.DealerSidebar to javafx.fxml;
    exports Sidebars.DealerSidebar;

    opens Sidebars.RetailerSidebar to javafx.fxml;
    exports Sidebars.RetailerSidebar;

}