package Slides.SlideTwo;

import Auths.SignUp.SignUpController;
import Slides.SlideOne.SlideOneController;
import Slides.SlideThree.SlideThreeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SlideTwoController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void handleNext(ActionEvent event) throws IOException {
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
    void handlePrev(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(SlideOneController.class.getResource("SlideOne.fxml"));
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
    void handleSkipSignUp(ActionEvent event) throws IOException {
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
