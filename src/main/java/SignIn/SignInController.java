package SignIn;


import SignIn.FXMLScene;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {
    public void switchToSignUp(ActionEvent event) throws IOException {
        FXMLScene scene = FXMLScene.load("sign-up.fxml");
        Parent root = scene.root;

        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }
}
