package Dashboards;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static Slides.SlideOne.SlideOne.loggedInUserID;
import static Slides.SlideOne.SlideOne.loggedInUserType;

public class UsersProfileController implements Initializable {

    @FXML
    private VBox PersonalInfoBox;

    @FXML
    private VBox ShopInfoBox;

    void showBox(){
        if(loggedInUserType.equals("Customer") || loggedInUserType.equals("Administrator")){ShopInfoBox.setVisible(false);}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showBox();
    }
}
