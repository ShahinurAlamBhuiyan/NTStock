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
                        File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
                        Scanner fileReader = new Scanner(file);

                        while(fileReader.hasNext())
                        {
                            usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
                        }

                        for(UserInformation user : usersInfo){
                            if(user.getEmail().equals(userEmailTF.getText()) && user.getPassword().equals(passwordTF.getText()) && user.getRole().equals(role)){
                                System.out.println("login successfully");
                            }else{
                                System.out.println("Not Sign up");
                            }
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

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }
    // merge
}
