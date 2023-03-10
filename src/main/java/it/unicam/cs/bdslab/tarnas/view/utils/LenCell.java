package it.unicam.cs.bdslab.tarnas.view.utils;

import it.unicam.cs.bdslab.tarnas.App;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class LenCell extends TableCell<RNAFile, RNAFile> {

    private final ImageButton imageButton;

    public LenCell(Image image) {
        this.imageButton = new ImageButton(image);
    }

    @Override
    protected void updateItem(RNAFile rnaFile, boolean empty) {
        super.updateItem(rnaFile, empty);
        if (rnaFile == null) {
            setGraphic(null);
            return;
        }
        setGraphic(imageButton);
        this.imageButton.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/len.fxml"));
                Parent root = loader.load();
                var stage = new Stage();
                var textArea = (TextArea) loader.getNamespace().get("rnaFileContent");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/img/tarnas-icon.png").toURI())));
                stage.setTitle("Preview");
                stage.setScene(new Scene(root, 600, 300));
                rnaFile.getContent().forEach(l -> textArea.appendText(l + "\n"));
                textArea.setScrollTop(Double.MAX_VALUE);
                stage.showAndWait();
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

}
