package SignUp;

import SignIn.FXMLScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("sign-in.fxml");
        Parent root = scene.root;

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }
}
