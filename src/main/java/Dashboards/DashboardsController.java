package Dashboards;
import Auths.SignIn.*;
import Dashboards.RetailerDashboard.MyProductsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DashboardsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private VBox AdministratorSidebar;
    @FXML
    private Button AAllDealersBtn;
    @FXML
    private Button AAllRetailersListBtn;
    @FXML
    private Button AComplainsBtn;
    @FXML
    private Button AProPriceBtn;
    @FXML
    private Button AProductListBtn;
    @FXML
    private VBox CustomerSidebar;
    @FXML
    private Button CHomeBtn;
    @FXML
    private Button CComplainBtn;

    @FXML
    private VBox DealerSidebar;
    @FXML
    private Button DMyProductsBtn;
    @FXML
    private Button DAddProduct;

    @FXML
    private Button DRetailersListBtn;
    @FXML
    private VBox RetailerSidebar;
    @FXML
    private Button RDealersListBtn;
    @FXML
    private Button RMyDealersListBtn;
    @FXML
    private Button RMyProductsBtn;


    @FXML
    private BorderPane MainBorderPane;


    @FXML
    private Label UserNameLebel;
    @FXML
    private Label UIDLabel;
    @FXML
    private Label UserTypeLebel;
    @FXML
    private Label welcomeLebel;

    private String userEmail;
    private String userId;
    private String userRole;

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void handleSidebar(){
            try {
                if(UserTypeLebel.getText().equals("Dealer")) {DealerSidebar.setVisible(true);}
                else if(UserTypeLebel.getText().equals("Administrator")) {AdministratorSidebar.setVisible(true);}
                else if(UserTypeLebel.getText().equals("Retailer")) {RetailerSidebar.setVisible(true);}
                else if(UserTypeLebel.getText().equals("Customer")){CustomerSidebar.setVisible(true);}
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void setSignedUserInfo(String role, String uEmail, String uRandomID){
        this.userEmail = uEmail;
        this.userId = uRandomID;
        this.userRole = role;
        handleUser(role, uEmail, uRandomID);
        UserTypeLebel.setText(role);
        UIDLabel.setText("UID - " + uRandomID);
        welcomeLebel.setText("Welcome to " + role + " Dashboard.");
    }


    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();

    public void handleUser(String role, String uEmail, String uRandomID) {
        try {
            String filePath = "AllTextFiles/" + role + "s/"+uEmail+""+role+""+uRandomID+".txt";
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                UserNameLebel.setText(user.getUsername());
            }

        } catch (Exception e) {
            System.out.println("$Error: " + e.getMessage());
        }
    }



    @FXML
    void handleLogout(ActionEvent event) {
        try {
            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println(event);
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void CHandleHomeSideBtn(ActionEvent event) { // Customer Sidebar.
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/CustomerDashboard/CustomerHome.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void CHandleComplainBtn(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/CustomerDashboard/ComplainBox.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AHandleAllRetailersListBtn(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/AdministratorDashboard/AllRetailers.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AHandleAllDealersBtn(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/AdministratorDashboard/AllDealers.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void AHandleComplainsBtn(ActionEvent event) {}
    @FXML
    void AHandleProPriceBtn(ActionEvent event) {}
    @FXML
    void AHandleProductListBtn(ActionEvent event) {}

    @FXML
    void RHandleDealersListBtn(ActionEvent event) {}
    @FXML
    void RHandleMyDealersListBtn(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/RetailerDashboard/MyDealers.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void RHandleMyProductsBtn(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/RetailerDashboard/MyProducts.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void DHandleRetailersListBtn(ActionEvent event) {}
    @FXML
    void DHandleMyProductsBtn(ActionEvent event) {}
    // merge with shahin

    @FXML
    void DHandleAddProduct(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboards/DealerDashboard/AddProductToRetailer.fxml"));
            MainBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
