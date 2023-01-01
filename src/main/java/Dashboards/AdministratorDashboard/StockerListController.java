package Dashboards.AdministratorDashboard;

import Auths.SignIn.UserInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class StockerListController implements Initializable {
    @FXML
    private TableView<UserInformation> AllStockersTable;

    @FXML
    private Button BgButton;

    @FXML
    private TableColumn<UserInformation, String> StockerAddress;

    @FXML
    private TableColumn<UserInformation, String> StockerContact;

    @FXML
    private TableColumn<UserInformation, String> StockerName;

    @FXML
    private TableColumn<UserInformation, String> StockerUID;

    @FXML
    private Label TotalStockerLabel;

    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
    ObservableList<UserInformation> stockerListR = FXCollections.observableArrayList(usersInfo);

    void getAllStocker() {
        try{
            File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                if(user.getIsStocker().equals("true")){
                    stockerListR.add(user);
                }
            }
            TotalStockerLabel.setText("Total Stocker: "+ stockerListR.size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllStocker();
        StockerName.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("userName"));
        StockerAddress.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("email"));
        StockerContact.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("contactNo"));
        StockerUID.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("userRandomId"));

        AllStockersTable.setItems(stockerListR);
    }
}
