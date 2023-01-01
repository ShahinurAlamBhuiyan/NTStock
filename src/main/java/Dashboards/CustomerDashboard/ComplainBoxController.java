package Dashboards.CustomerDashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class ComplainBoxController {

    @FXML
    private TextField ContactNoTF;

    @FXML
    private TextArea DescriptionTF;

    @FXML
    private TextField RetailerOrDealerNameTF;

    @FXML
    void handleSubmitBtn(ActionEvent event) throws IOException {
        if(!RetailerOrDealerNameTF.getText().equals("")){
            if(!DescriptionTF.getText().equals("")){
                if(!ContactNoTF.getText().equals("")){
                    String desc = DescriptionTF.getText();
                    desc = desc.replace(" ", "-");

                    String retailerOrDealerName = RetailerOrDealerNameTF.getText();
                    retailerOrDealerName = retailerOrDealerName.replace(" ", "-");
                    String complainerContact = ContactNoTF.getText();
                    FileWriter fw = new FileWriter("AllTextFiles/AllComplains/AllComplains.txt", true);
                    fw.write(retailerOrDealerName + " " + complainerContact + " " + desc+"\n");
                    fw.close();
                    System.out.println(desc);
                }
            }
        }
    }

}
