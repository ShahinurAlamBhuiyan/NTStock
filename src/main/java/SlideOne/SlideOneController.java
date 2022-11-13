package SlideOne;

import SignIn.FXMLScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SlideOneController {

    @FXML
    private Button nextBtn;

    @FXML
    private Button skipSignUpBtn;

    @FXML
    void handleNext(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("slide-two.fxml");
        Parent root = scene.root;

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }

    @FXML
    void handleSkipSignUp(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("sign-up.fxml");
        Parent root = scene.root;

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }

}
