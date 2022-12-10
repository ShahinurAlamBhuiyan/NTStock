package Auths.SignIn;


import Dashboards.AdministratorDashboard.AdministratorDashboardController;

import Dashboards.CustomerDashboard.CustomerDashboardController;
import Dashboards.DashboardsController;
import Dashboards.DealerDashboard.DealerDashboardController;
import Dashboards.RetailerDashboard.RetailerDashboardController;
import Auths.SignUp.SignUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Slides.SlideOne.SlideOne.*;

public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ToggleGroup roleToggleGrp;
    @FXML
    private ToggleButton administratorToggle;
    @FXML
    private ToggleButton customerToggle;

    @FXML
    private ToggleButton dealerToggle;
    @FXML
    private ToggleButton retailerToggle;
    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField userEmailTF;
    @FXML
    private Label roleRequired;


    public String role=null;
    public String userRandomId=null;
    public String userEmail = null;
    @FXML
    void handleSignIn(ActionEvent event) {
        if(customerToggle.isSelected()){
            role = customerToggle.getText();
        }else if(retailerToggle.isSelected()){
            role = retailerToggle.getText();
        }else if(dealerToggle.isSelected()){
            role = dealerToggle.getText();
        }else if(administratorToggle.isSelected()){
            role = administratorToggle.getText();
        }else{
            role = null;
        }

        ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
        if(!(role == null)){
            if(!userEmailTF.getText().equals("")){
                if(!passwordTF.getText().equals("")){
                    try{
                        boolean isMatch = false;
                        File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
                        Scanner fileReader = new Scanner(file);

                        while(fileReader.hasNext())
                        {
                            usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
                        }

                        for(UserInformation user : usersInfo){
                            if(user.getEmail().equals(userEmailTF.getText()) && user.getPassword().equals(passwordTF.getText()) && user.getRole().equals(role)){
                                isMatch = true;
                                userRandomId = user.getUserRandomId();
                                this.userEmail = user.getEmail();
                                loggedInUserName = user.getFirstName()  + " " + user.getLastName();
                                loggedInUserEmail = user.getEmail();
                                loggedInUserType = user.getRole();
                                loggedInUserID = user.getUserRandomId();
                                break;
                            }else{
                                System.out.println("Not Sign up");
                            }
                        }
                        if(isMatch){
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Congratulations!");
                            alert.setContentText("Successfully logged in.");
                            alert.showAndWait();
                            switchToDashboard(event);
                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Wrong!");
                            alert.setContentText("Please, check your email and password and role.");
                            alert.showAndWait();
                        }

                    }catch (Exception err){
                        err.printStackTrace();
                    }
                }else{
                    System.out.println(passwordTF);
                }
            }else{
                System.out.println(userEmailTF);
            }
            roleRequired.setVisible(false);
        }else{
            roleRequired.setVisible(true);
        }



    }
    @FXML
     void switchToSignUp(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(SignUpController.class.getResource("SignUp.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void switchToDashboard(ActionEvent event) throws IOException {
        try {
            FXMLScene scene = FXMLScene.load("/Dashboards/Dashboards.fxml");
            Parent root = scene.root;
            // sending data for dashboard. --------------------------------
            DashboardsController dashboardsController = (DashboardsController) scene.controller;
            dashboardsController.setSignedUserInfo(role,userEmailTF.getText(), userRandomId);
            dashboardsController.handleSidebar();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            System.out.println("$Error: " + e.getMessage());
        }
    }



}
