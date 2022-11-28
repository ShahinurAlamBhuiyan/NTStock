package Dashboards;


import Auths.SignIn.SignInController;
import Auths.SignIn.UserInformation;
import Auths.SignUp.SignUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DashboardsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label UserNameLebel;

    @FXML
    private Label UserTypeLebel;

    @FXML
    private Label welcomeLebel;
    @FXML
    private Button HomeBtn;
    @FXML
    private Button chatBtn;



    @FXML
    void handleLogout(ActionEvent event) {
        try {
            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleClickedMouse(MouseEvent event) {
//        setBackground("-fx-background-color: blue");
    }


    public void getSignedUserInfo(String role, String uEmail, String uRandomID) {
        handleUser(role, uEmail, uRandomID);
        UserTypeLebel.setText(role);
        welcomeLebel.setText("Welcome " + role);

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
}
