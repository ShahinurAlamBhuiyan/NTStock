package SignUp;

import SignIn.FXMLScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    @FXML
    private ChoiceBox<String> areaChoiceBox;
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
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return result;
    }
    @FXML
    void handleSignUp(ActionEvent event) {


        if(!fullNameTField.getText().equals("")){
            if(!emailTField.getText().equals("")){
                if(!passwordTField.getText().equals("")){
                    if(!(dobTField.getValue() == null)){
                        if(!(genderChoiceBox.getValue()==null)){
                            if(!(userTypeChoiceBox.getValue()==null)){
                                if(!(areaChoiceBox.getValue()==null)){
                                    if(termsCheckBox.isSelected()){
                                        System.out.println("Success");

                                        String singleUserFilePath = "AllTextFiles/"+userTypeChoiceBox.getValue()+"s/"+emailTField.getText()+""+userTypeChoiceBox.getValue()+""+generateRandomNumber()+".txt";
                                        String signUpAllUserPath = "AllTextFiles/All-Users/usersSignUpInfo.txt";

                                        try{
                                            FileWriter writer1 = new FileWriter(singleUserFilePath, true);
                                            writer1.write(emailTField.getText() + " " + passwordTField.getText() + " " +
                                                   userTypeChoiceBox.getValue() + " " + fullNameTField.getText() + " " +
                                                    genderChoiceBox.getValue()+ " " + dobTField.getValue() + " " +
                                                    areaChoiceBox.getValue() +" " + LocalDate.now() +"\n");

                                            FileWriter writer2 = new FileWriter(signUpAllUserPath, true);
                                            writer2.write(emailTField.getText() + " " + passwordTField.getText() + " " +
                                                    userTypeChoiceBox.getValue() + " " + fullNameTField.getText() + " " +
                                                    genderChoiceBox.getValue()+ " " + dobTField.getValue() + " " +
                                                    areaChoiceBox.getValue() +" " + LocalDate.now() +"\n");
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
                                    areaRequired.setVisible(false);
                                }else{
                                    areaRequired.setVisible(true);
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



        /*if(!fullNameTField.getText().equals("") &&
                !emailTField.getText().equals("") &&
                !userTypeBox.getText().equals("") &&
                termsCheckBox.isSelected() &&
                !genderBox.getText().equals("") &&
                dobTField.isShowWeekNumbers() &&
                !areaBox.getText().equals("") &&
                !String.valueOf(passwordTField.getText()).equals("")
        ){
//            if(emailText.getText().equals(reEmailText.getText()))
//            {
                try {
                    FileWriter writer = new FileWriter("userSignUpInfo.txt", true);
                    writer.write(fullNameTField.getText() + " " + emailTField.getText() + " " + passwordTField.getText() + " " + "\n");
                    writer.close();
                    System.out.println("Add successfully");
//                    JOptionPane.showMessageDialog(null,"Information saved successfully!");
//                    new ProfileFrame(emailText.getText(), String.valueOf(newPasswordText.getPassword()));
//                    dispose();

                } catch (Exception err) {
                    System.out.println(err);
                }
//            }else{
//                JOptionPane.showMessageDialog(null,"Your email is not matched!");
//            }

        }
        else{
//            JOptionPane.showMessageDialog(null, "Please fill up all information.");
            System.out.println("Please fill all data.");
        }*/
    }

    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("sign-in.fxml");
        Parent root = scene.root;

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userTypeChoiceBox.getItems().addAll(users);
        areaChoiceBox.getItems().addAll(areas);
        genderChoiceBox.getItems().addAll(genders);
    }
}
