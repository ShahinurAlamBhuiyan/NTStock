package Dashboards.AdministratorDashboard;

import Auths.SignIn.UserInformation;
import Dashboards.ComplainInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SingleComplainBoxController {
    @FXML
    private VBox complainBox;
    @FXML
    private TextField ComplaintContactTF;

    @FXML
    private TextField DescriptionTF;

    @FXML
    private TextField retailerNameTF;

    @FXML
    void handleDeleteBtn(ActionEvent event) {

    }
    public void setData(ComplainInformation complainInformation){
        ArrayList<ComplainInformation> complains = new ArrayList<>();
        try{
            File file = new File("AllTextFiles/AllComplains/AllComplains.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                complains.add(new ComplainInformation(fileReader.next(), fileReader.next(), fileReader.next()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        complainBox.setStyle("-fx-border-radius: 20;" +"-fx-background-radius: 20;" +
                "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1),10,0,0,10);" +
                "-fx-background-color: rgb(32,73,46);"+
                "-fx-border-color: green;"+"-fx-pref-width:750;");
        retailerNameTF.setText(complainInformation.getRetailerOrDealerFirstName());
        ComplaintContactTF.setText(complainInformation.getComplainerPhoneNo());
        DescriptionTF.setText(complainInformation.getDescription());
    }

}
