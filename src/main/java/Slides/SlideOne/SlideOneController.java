package Slides.SlideOne;

import Slides.SlideTwo.SlideTwoController;
import Auths.SignUp.SignUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SlideOneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button nextBtn;
    @FXML
    private Button skipSignUpBtn;
    @FXML
    void handleNext(ActionEvent event) throws IOException {
//        FXMLScene scene = FXMLScene.load("Slides.SlideTwo.fxml");
//        Parent root = scene.root;
//
//        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
//        loginStage.setScene(new Scene(root));

        try {
            root = FXMLLoader.load(SlideTwoController.class.getResource("SlideTwo.fxml"));
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
