package Dashboards;

import Auths.SignIn.UserInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static Slides.SlideOne.SlideOne.loggedInUserID;
import static Slides.SlideOne.SlideOne.loggedInUserEmail;
import static Slides.SlideOne.SlideOne.loggedInUserType;

public class UsersProfileController implements Initializable {
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField FirstNameTF;
    @FXML
    private TextField LastNameTF;
    @FXML
    private TextField NIDTF;
    @FXML
    private TextField PhoneNumberTF;
    @FXML
    private  TextField UIDTF;
    @FXML
    private VBox PersonalInfoBox;
    @FXML
    private VBox ShopInfoBox;

    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
    void showBox(){
        if(loggedInUserType.equals("Customer") || loggedInUserType.equals("Administrator")){ShopInfoBox.setVisible(false);}
        setUserDataToTextFiled();
    }
    public void setUserDataToTextFiled(){
        try{
            String filePath = "AllTextFiles/"+loggedInUserType+"s/"+loggedInUserEmail+loggedInUserType+loggedInUserID+".txt";
            File file  = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
        }catch(Exception e){
            System.out.println("error 52");
            e.printStackTrace();
        }
        for (UserInformation user : usersInfo){
            FirstNameTF.setText(user.getFirstName());
            LastNameTF.setText(user.getLastName());
            EmailTF.setText(user.getEmail());
            NIDTF.setText(user.getNidNo());
            PhoneNumberTF.setText(user.getContactNo());
            UIDTF.setText(user.getUserRandomId());
        }
    }

    @FXML
    void handleSaveBtn(ActionEvent event) {
        if (!FirstNameTF.getText().equals(""))
            if (!LastNameTF.getText().equals(""))
                    if (!NIDTF.getText().equals(""))
                        if (!PhoneNumberTF.getText().equals("")) {
                            try{
                                String filePath = "AllTextFiles/"+loggedInUserType+"s/"+loggedInUserEmail+loggedInUserType+loggedInUserID+".txt";
                                FileWriter writer = new FileWriter(filePath);
                                writer.write(EmailTF.getText()+" "+usersInfo.get(0).getPassword()+" "+
                                        loggedInUserType+" "+FirstNameTF.getText()+" "+
                                        LastNameTF.getText()+" "+usersInfo.get(0).getGender()+" "+
                                        usersInfo.get(0).getBirthday()+" "+
                                        usersInfo.get(0).getCreatingTime()+" "+
                                        loggedInUserID+" "
                                        +PhoneNumberTF.getText()+" " +NIDTF.getText()+"\n");
                                writer.close();
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Congratulations!");
                                alert.setContentText("Your data saved!");
                                alert.showAndWait();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showBox();
    }
}
