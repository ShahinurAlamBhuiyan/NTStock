package Dashboards.AdministratorDashboard;

import Auths.SignIn.UserInformation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AllRetailersController implements Initializable {

    @FXML
    private Label RetailerName;
    @FXML
    private Label AllRetailer;


    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
    ArrayList<UserInformation> retailerList = new ArrayList<>();
    void getAllRetailers() {
        try{
            File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                if(user.getRole().equals("Retailer")){
                    retailerList.add(user);
//                    RetailerList.setText(user.getUsername());
                }
            }

            for(UserInformation retailer : retailerList){
                RetailerName.setText(retailer.getUsername());
                AllRetailer.setText("");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public AllRetailersController() {
        /*getAllRetailers();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllRetailers();
    }
}
