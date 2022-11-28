package Slides.SlideOne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SlideOne extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SlideOne.class.getResource("SlideOne.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NTStock");
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("file:icon.png"));
    }
    // merge with shahin

    public static void main(String[] args) {
        launch();
    }
}
