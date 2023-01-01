package Dashboards.AdministratorDashboard;

import Dashboards.ComplainInformation;
import Dashboards.CustomerDashboard.SingleProductsController;
import Dashboards.SoldProductInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ComplainBoxContainerController implements Initializable {

    private List<ComplainInformation> allComplains;
    @FXML
    private GridPane complainContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allComplains = new ArrayList<>(getAllComplains());
        int column = 0;
        int row = 1;
        try{
            for(ComplainInformation complain : allComplains){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleComplainBox.fxml"));
                VBox complainBox = fxmlLoader.load();
                SingleComplainBoxController singleComplainBoxController = fxmlLoader.getController();
                singleComplainBoxController.setData(complain);

                if(column == 1){
                    column = 0;
                    ++row;
                }
                complainContainer.add(complainBox, column++, row);
                GridPane.setMargin(complainBox, new Insets(15));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    List<ComplainInformation> complains = new ArrayList<>();
    private List<ComplainInformation> getAllComplains(){
        try{
            File file  = new File("AllTextFiles/AllComplains/AllComplains.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                complains.add(new ComplainInformation(fileReader.next(), fileReader.next(), fileReader.next()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return complains;
    }
}
