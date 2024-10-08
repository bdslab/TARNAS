package it.unicam.cs.bdslab.tarnas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * TARNAS JavaFX App
 *
 * @author Piero Hierro, Piermichele Rosati
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/home.fxml")));
        stage.setTitle("TARNAS");
        stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/img/tarnas-icon.png").toURI())));
        stage.setScene(new Scene(root));
        stage.setMinWidth(1300);
        stage.setMinHeight(700);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}