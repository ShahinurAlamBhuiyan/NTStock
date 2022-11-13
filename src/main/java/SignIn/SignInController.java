package SignIn;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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






    @FXML
    void handleSignIn(ActionEvent event) {
        String role;
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
                        String userType = null;
                        File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
                        Scanner fileReader = new Scanner(file);

                        while(fileReader.hasNext())
                        {
                            usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
                        }

                        for(UserInformation user : usersInfo){
                            if(user.getEmail().equals(userEmailTF.getText()) && user.getPassword().equals(passwordTF.getText()) && user.getRole().equals(role)){
                                isMatch = true;
                                userType = user.getRole();
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
                            if(userType.equals("Customer")){
                                switchToCustomerDashboard(event);
                            }else if(userType.equals("Retailer")){
                                switchToRetailerDashboard(event);
                            }else if(userType.equals("Dealer")){
                                switchToDealerDashboard(event);
                            }else if(userType.equals("Administrator")){
                                switchToAdministratorDashboard(event);
                            }
//                            switchToDashboard(event);
                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Wrong!");
                            alert.setContentText("Please, check your email and password and role.");
                            alert.showAndWait();
                        }

                    }catch (Exception err){
                        System.out.println(err);
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
        FXMLScene scene = FXMLScene.load("sign-up.fxml");
        Parent root = scene.root;

        Stage signupStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        signupStage.setScene(new Scene(root));
    }

    void switchToDashboard(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("administrator-dashboard.fxml");
        Parent root = scene.root;

        Stage customerStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        customerStage.setScene(new Scene(root));
    }

    void switchToCustomerDashboard(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("customer-dashboard.fxml");
        Parent root = scene.root;

        Stage customerStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        customerStage.setScene(new Scene(root));
    }

    void switchToRetailerDashboard(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("retailer-dashboard.fxml");
        Parent root = scene.root;

        Stage retailerStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        retailerStage.setScene(new Scene(root));
    }

    void switchToDealerDashboard(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("dealer-dashboard.fxml");
        Parent root = scene.root;

        Stage dealerStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        dealerStage.setScene(new Scene(root));
    }

    void switchToAdministratorDashboard(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("administrator-dashboard.fxml");
        Parent root = scene.root;

        Stage administratorStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        administratorStage.setScene(new Scene(root));
    }
    // merge nafis
}
