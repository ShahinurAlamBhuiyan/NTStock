package Auths.SignUp;

import Auths.SignIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private DatePicker dobTField;

    @FXML
    private TextField emailTField;

    @FXML
    private TextField fullNameTField;

    @FXML
    private PasswordField passwordTField;

    @FXML
    private Button signUpNowBtn;

    @FXML
    private ChoiceBox<String> userTypeChoiceBox;
    private String[] users = {"Customer", "Retailer", "Dealer", "Administrator"};

    private String[] areas = {"Dhaka", "Chittagong", "Feni", "Rajshahi", "Barishal", "Shyllet", "Khulna","Noakhali"};
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    private String[] genders = {"Male", "Female", "Others"};
    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private Label areaRequired;

    @FXML
    private Label dobRequired;
    @FXML
    private Label emailRequired;
    @FXML
    private Label genderRequired;

    @FXML
    private Label nameRequired;

    @FXML
    private Label passRequired;
    @FXML
    private Label roleRequired;
    @FXML
    private Label termsRequired;

    public int generateRandomNumber(){
        Random r = new Random();
        int low = 10000;
        int high = 10000000;
        int result = r.nextInt(high-low) + low;
        return result;
    }
    @FXML
    void handleSignUp(ActionEvent event) {
        System.out.println(generateRandomNumber());

        if(!fullNameTField.getText().equals("")){
            if(!emailTField.getText().equals("")){
                if(!passwordTField.getText().equals("")){
                    if(!(dobTField.getValue() == null)){
                        if(!(genderChoiceBox.getValue()==null)){
                            if(!(userTypeChoiceBox.getValue()==null)){
//                                if(!(areaChoiceBox.getValue()==null)){
                                    if(termsCheckBox.isSelected()){
                                        System.out.println("Success");
                                        int fileRandomValue = generateRandomNumber();
                                        String singleUserFilePath = "AllTextFiles/"+userTypeChoiceBox.getValue()+"s/"+emailTField.getText()+""+userTypeChoiceBox.getValue()+""+fileRandomValue+".txt";
                                        String AllUserPath = "AllTextFiles/All-Users/usersSignUpInfo.txt";

                                        try{
                                            FileWriter writer1 = new FileWriter(singleUserFilePath, true);
                                            writer1.write(emailTField.getText() + " " + passwordTField.getText() + " " +
                                                    userTypeChoiceBox.getValue() + " " + fullNameTField.getText() + " " +
                                                    genderChoiceBox.getValue()+ " " + dobTField.getValue() + " " + LocalDate.now() +" "+fileRandomValue+"\n");

                                            FileWriter writer2 = new FileWriter(AllUserPath, true);
                                            writer2.write(emailTField.getText() + " " + passwordTField.getText() + " " +
                                                    userTypeChoiceBox.getValue() + " " + fullNameTField.getText() + " " +
                                                    genderChoiceBox.getValue()+ " " + dobTField.getValue() + " "  + LocalDate.now() + " "+fileRandomValue+ "\n");
                                            writer1.close();
                                            writer2.close();
                                            System.out.println("Add successfully");
                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                            alert.setTitle("Congratulations!");
                                            alert.setContentText("Your account created successfully. Sign-in now!");
                                            alert.showAndWait();
                                            switchToSignIn(event);
                                        }catch (Exception e){
                                            System.out.println("not added");
                                            Alert alert = new Alert(Alert.AlertType.WARNING);
                                            alert.setTitle("Wrong!");
                                            alert.setContentText("Please, check your email and password and role.");
                                            alert.showAndWait();
                                        }



                                        termsRequired.setVisible(false);
                                    }else{
                                        termsRequired.setVisible(true);
                                    }
                                    roleRequired.setVisible(false);
                            }else{
                                roleRequired.setVisible(true);
                            }
                            genderRequired.setVisible(false);
                        }else{
                            genderRequired.setVisible(true);
                        }
                        dobRequired.setVisible(false);
                    }else{
                        dobRequired.setVisible(true);
                    }
                    passRequired.setVisible(false);
                }else{
                    passRequired.setVisible(true);
                }
                emailRequired.setVisible(false);
            }else{
                emailRequired.setVisible(true);
            }
            nameRequired.setVisible(false);
        }else{
            nameRequired.setVisible(true);
        }
    }

    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userTypeChoiceBox.getItems().addAll(users);
        genderChoiceBox.getItems().addAll(genders);
    }
}
