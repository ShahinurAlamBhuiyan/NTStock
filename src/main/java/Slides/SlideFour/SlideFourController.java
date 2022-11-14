package Slides.SlideFour;

import Auths.SignUp.SignUpController;
import Slides.SlideThree.SlideThreeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SlideFourController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void handlePrev(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(SlideThreeController.class.getResource("SlideThree.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleSignUp(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(SignUpController.class.getResource("SignUp.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
