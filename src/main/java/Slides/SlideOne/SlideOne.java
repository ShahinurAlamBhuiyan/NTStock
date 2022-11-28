package Slides.SlideOne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SlideOne extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SlideOne.class.getResource("SlideOne.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NTStock");
//        stage.getIcons().add(new Image("/src/main/resources/Image/ntlogo.png"));
        File file = new File("src/main/resources/Image/ntlogo.png");
        Image image = new Image(file.toURI().toString());
        stage.getIcons().add(image);
        stage.setScene(scene);

        stage.show();
    }
    // merge with shahin branch
    public static void main(String[] args) {
        launch();
    }
}
