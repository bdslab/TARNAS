package it.unicam.cs.bdslab.tarnas.view;


import it.unicam.cs.bdslab.tarnas.App;
import it.unicam.cs.bdslab.tarnas.Main;
import it.unicam.cs.bdslab.tarnas.controller.AbstractionsController;
import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.controller.TranslatorController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileException;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
import it.unicam.cs.bdslab.tarnas.view.utils.DeleteCell;
import it.unicam.cs.bdslab.tarnas.view.utils.LenCell;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class HomeController {
    public static final Logger logger = Logger.getLogger("it.unicam.cs.bdslab.tarnas.view.HomeController");
    private TranslatorController translatorController;

    private IOController ioController;

    private CleanerController cleanerController;

    private AbstractionsController abstractionsController;

    private RNAFormat selectedFormat;

    private boolean isTranslating;

    @FXML
    private TableView<RNAFile> filesTable;

    @FXML
    private TableColumn<RNAFile, String> nameColumn;

    @FXML
    private TableColumn<RNAFile, String> formatColumn;

    @FXML
    private TableColumn<RNAFile, RNAFile> previewColumn;

    @FXML
    private TableColumn<RNAFile, RNAFile> deleteColumn;

    @FXML
    public MenuButton btnSelectFormatTranslation;

    //@FXML
    //public Button btnTranslate;

    @FXML
    public CheckBox chbxRmLinesContainingWord;

    @FXML
    public CheckBox chbxRmBlankLines;

    @FXML
    public CheckBox chbxMergeLines;

    @FXML
    public CheckBox chbxIncludeHeader;

    @FXML
    public CheckBox chbxRmAllComments;

    @FXML
    public CheckBox chbxCore;

    @FXML
    public CheckBox chbxCorePlus;

    @FXML
    public CheckBox chbxShape;

    @FXML
    public TextField textFieldRmLinesContainingWord;

    @FXML
    public CheckBox chbxSaveAsZIP;

    @FXML
    public TextField textFieldArchiveName;

    @FXML
    public BorderPane paneTranslationCleaning;

    @FXML
    public BorderPane abstractionsPane;

    @FXML
    public void initialize() {
        logger.info("Initializing...");
        this.isTranslating = false;
        // remove sorting
        this.nameColumn.setSortable(false);
        this.formatColumn.setSortable(false);
        this.deleteColumn.setSortable(false);
        this.previewColumn.setSortable(false);
        //disable cleaning and translation
        this.paneTranslationCleaning.setDisable(true);
        // init controllers
        this.cleanerController = CleanerController.getInstance();
        this.ioController = IOController.getInstance();
        this.translatorController = TranslatorController.getInstance();
        this.abstractionsController = AbstractionsController.getInstance();
        // load trash image
        var trashImage = new Image(Objects.requireNonNull(Main.class.getResource("/img/trash.png")).toExternalForm(), 18, 18, false, false);
        var lenImage = new Image(Objects.requireNonNull(Main.class.getResource("/img/lens-icon.jpeg")).toExternalForm(), 18, 18, false, false);
        //change table label
        this.filesTable.setPlaceholder(new Label("No files loaded"));
        this.filesTable.setId("fileTables");
        // set column values
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        this.formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));
        this.previewColumn.setCellValueFactory(rnaFile -> new ReadOnlyObjectWrapper<>(rnaFile.getValue()));
        this.deleteColumn.setCellValueFactory(rnaFile -> new ReadOnlyObjectWrapper<>(rnaFile.getValue()));
        // set custom cell
        this.previewColumn.setCellFactory(column -> new LenCell(lenImage));
        this.deleteColumn.setCellFactory(column -> new DeleteCell(trashImage, this.eventTableEmpty()));
        logger.info("Initialization done");
    }

    @FXML
    public void handleAddFile() {
        logger.info("ADD FILE button clicked");
        var fileChooser = new FileChooser();
        var selectedFile = fileChooser.showOpenDialog(this.getPrimaryStage());
        if (selectedFile != null) {
            var selectedRNAFile = Path.of(selectedFile.getPath());
            try {
                this.addFileToTable(selectedRNAFile);
                logger.info("File added successfully");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "", "", e.getMessage());
            }
        }
        logger.info("Exit add file");
    }

    @FXML
    public void handleAddFolder() {
        logger.info("ADD FOLDER button clicked");
        var directoryChooser = new DirectoryChooser();
        var selectedDirectory = directoryChooser.showDialog(this.getPrimaryStage());
        if (selectedDirectory != null) {
            try {
                var files = Files.walk(selectedDirectory.toPath())
                        .filter(Files::isRegularFile)
                        .toList();
                for (var f : files)
                    this.addFileToTable(f);

                logger.info("Folder added successfully");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "", "", e.getMessage());
            }
        }
        logger.info("Exit add file");
    }

    public List<RNAFile> clean(List<RNAFile> files) throws RNAFileException {
        var cleanedFiles = new ArrayList<RNAFile>();
        RNAFile tmp = null;
        try {
            for (var f : files) {
                tmp = f;
                if (this.chbxRmAllComments.isSelected()) {
                    f = this.cleanerController.removeLinesStartingWith(f, "#");
                    f = this.cleanerController.removeLinesStartingWith(f, ">");
                }
                if (this.chbxRmLinesContainingWord.isSelected())
                    f = this.cleanerController.removeLinesContaining(f, this.textFieldRmLinesContainingWord.getText());
                if (this.chbxRmBlankLines.isSelected())
                    f = this.cleanerController.removeWhiteSpaces(f);
                if (this.chbxRmBlankLines.isSelected())
                    f = this.cleanerController.mergeDBLines(f);
                cleanedFiles.add(f);
            }
        } catch (Exception e) {
            throw new RNAFileException("Error caused by : " + tmp.getFileName());
        }
        return cleanedFiles;

    }

    private List<RNAFile> translate(List<RNAFile> files) throws RNAFileException {
        List<RNAFile> translatedRNAFiles;
        translatedRNAFiles = this.translatorController.translateAllLoadedFiles(files, this.selectedFormat);
        if (!this.chbxIncludeHeader.isSelected())
            translatedRNAFiles = translatedRNAFiles.parallelStream()
                    .map(f -> this.cleanerController.removeHeader(f))
                    .toList();
        return translatedRNAFiles;
    }

    @FXML
    public void handleReset() {
        logger.info("RESET button clicked");
        // reset all data structures
        this.filesTable.getItems().clear();
        // reset controller files
        this.ioController.clearAllDataStructures();
        // disable translation and cleaning pane
        this.tableEmpty();
        logger.info("Reset done");
    }

    @FXML
    public void handleRun() {
        logger.info("RUN button clicked");
        var files = this.filesTable.getItems().stream().toList();
        try {
            if (isTranslating) {
                files = this.clean(files);
                files = this.translate(files);
                this.saveFilesTo(files);
            } else {
                files = this.abstractions(files);
                this.saveFilesTo(files);
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
            this.showAlert(Alert.AlertType.ERROR, "Error", "", e.getMessage());
        }
    }

    @FXML
    public void handleAbstractionSelected() {
        this.chbxMergeLines.setSelected(false);
        this.chbxRmAllComments.setSelected(false);
        this.chbxRmBlankLines.setSelected(false);
        this.chbxRmLinesContainingWord.setSelected(false);
        this.textFieldRmLinesContainingWord.setText("");
        this.chbxIncludeHeader.setSelected(false);
        this.btnSelectFormatTranslation.setText("Translate to");//easter egg
        this.isTranslating = false;
    }

    @FXML
    public void handleTranslationCleaningSelected() {
        this.chbxCore.setSelected(false);
        this.chbxCorePlus.setSelected(false);
        this.chbxShape.setSelected(false);
        this.isTranslating = true;
    }

    @FXML
    public void handleWriteFile() throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/writeFile.fxml"));
        Parent root = loader.load();
        var stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root, 700, 400));
        stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/img/tarnas-icon.png").toURI())));
        stage.setTitle("Edit File");
        var textArea = (TextArea) loader.getNamespace().get("txtAreaRnaFileContent");
        var saveButton = (Button) loader.getNamespace().get(("btnSaveWriteFile"));
        var cancelButton = (Button) loader.getNamespace().get(("btnCancelWriteFile"));
        saveButton.setOnAction(e -> {
            textArea.setEditable(false);
            stage.close();
        });
        cancelButton.setOnAction(e -> {
            logger.info(cancelButton.getText() + " button clicked");
            stage.close();
        });
        stage.showAndWait();
        if (!textArea.isEditable()) {
            if (textArea.getText().isEmpty())
                showAlert(Alert.AlertType.ERROR, "", "", "The content of the file cannot be empty");
            else {
                var dialog = new TextInputDialog("example.ct");
                dialog.setHeaderText("Digit the file name");
                dialog.initModality(Modality.APPLICATION_MODAL);
                String fileName;
                dialog.showAndWait();
                if (dialog.getEditor().getText().isEmpty()) {
                    this.showAlert(Alert.AlertType.ERROR, "Error", "", "The file cannot be empty");
                    logger.severe(dialog.getEditor().getId() + " is empty");
                } else {
                    fileName = dialog.getEditor().getText();
                    logger.info(fileName + " created");
                    File tmp = new File(Path.of(System.getProperty("user.dir")).resolve(fileName).toUri());
                    logger.info("write content on " + fileName);
                    Files.write(tmp.toPath(), textArea.getText().getBytes());
                    var selectedRNAFile = Path.of(tmp.getPath());
                    try {
                        this.addFileToTable(selectedRNAFile);
                    } catch (Exception e) {
                        showAlert(Alert.AlertType.ERROR, "", "", e.getMessage());
                    }
                    Files.delete(tmp.toPath());
                    // clear
                    dialog.getEditor().clear();
                }
            }
        }

    }

    private Stage getPrimaryStage() {
        return (Stage) this.filesTable.getScene().getWindow();
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.initOwner(this.getPrimaryStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void initSelectEventOnButtonItems(List<RNAFormat> availableTranslations) {
        this.btnSelectFormatTranslation.getItems().clear();
        availableTranslations.forEach(a -> {
            var item = new MenuItem(a.getName());
            item.setUserData(a);
            this.btnSelectFormatTranslation.getItems().add(item);
            item.setOnAction(e -> {
                this.selectedFormat = (RNAFormat) ((MenuItem) e.getSource()).getUserData();  // set RNAFormat enum
                this.btnSelectFormatTranslation.setText((((MenuItem) e.getSource()).getText())); // set String to display in MenuItem
                this.btnSelectFormatTranslation.setUserData(selectedFormat);
                this.handleTranslationCleaningSelected();
            });
        });
        //this.btnTranslate.setDisable(true);
    }

    private void addFileToTable(Path selectedRNAFile) throws RNAFileException {
        try {
            var rnaFile = this.ioController.loadFile(selectedRNAFile);
            this.filesTable.getItems().add(rnaFile);
            this.paneTranslationCleaning.setDisable(false);
            this.chbxMergeLines.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            this.abstractionsPane.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            // add event to select ButtonItem for destination format translation
            this.initSelectEventOnButtonItems(this.translatorController.getAvailableTranslations(rnaFile.getFormat()));
        } catch (Exception e) {
            logger.severe("Could not load file: " + selectedRNAFile);
            throw new RNAFileException("Error caused by: " + selectedRNAFile);
        }
    }

    private void saveFilesTo(List<RNAFile> rnaFiles) throws IOException {
        if ((this.chbxSaveAsZIP.isSelected()) && (this.textFieldArchiveName.getText().isEmpty() || this.textFieldArchiveName.getText().isBlank())) {
            showAlert(Alert.AlertType.ERROR, "", "", "Inserire un nome per lo zip!");
            return;
        }
        this.showAlert(Alert.AlertType.INFORMATION, "", "", "Choose the directory where to save the files");
        var directoryChooser = new DirectoryChooser();
        var selectedDirectory = directoryChooser.showDialog(this.getPrimaryStage());
        if (selectedDirectory != null) {
            // zip options
            if (this.chbxSaveAsZIP.isSelected()) {
                String folderName = this.textFieldArchiveName.getText();
                var zipPath = this.ioController.zipFiles(selectedDirectory.toPath(), folderName, rnaFiles);
                this.showAlert(Alert.AlertType.INFORMATION,
                        "",
                        "Files saved successfully",
                        rnaFiles.size() + " files saved in: " + zipPath);
                logger.info(rnaFiles.size() + " files saved in: " + zipPath);
            } else { // files options
                this.ioController.saveFilesTo(rnaFiles, selectedDirectory.toPath());
                this.showAlert(Alert.AlertType.INFORMATION,
                        "",
                        "Files saved successfully",
                        rnaFiles.size() + " files saved in: " + selectedDirectory.getPath());
                logger.info(rnaFiles.size() + " files saved in: " + selectedDirectory.getPath());
            }

        } else {
            logger.info("no files saved");
        }
    }

    private void tableEmpty() {
        if (this.filesTable.getItems().isEmpty()) {
            // reset checkboxes
            this.chbxMergeLines.setSelected(false);
            this.chbxRmLinesContainingWord.setSelected(false);
            this.chbxRmBlankLines.setSelected(false);
            this.chbxIncludeHeader.setSelected(false);
            this.chbxSaveAsZIP.setSelected(false);
            this.chbxRmAllComments.setSelected(false);
            this.chbxCore.setSelected(false);
            this.chbxCorePlus.setSelected(false);
            this.chbxShape.setSelected(false);
            // reset textAreas
            this.textFieldArchiveName.setText("");
            this.textFieldRmLinesContainingWord.setText("");
            // reset menu button
            this.btnSelectFormatTranslation.setText("Translate to");
            // reset translate button
            //this.btnTranslate.setDisable(true);
            // reset panes
            this.paneTranslationCleaning.setDisable(true);
        }
    }

    public List<RNAFile> abstractions(List<RNAFile> files) {

        logger.info("Abstractions button clicked");
        var abstractions = new ArrayList<RNAFile>();
        for (var f : files) {
            if (this.chbxCore.isSelected())
                abstractions.add(this.abstractionsController.getCore(f));
            if (this.chbxCorePlus.isSelected())
                abstractions.add(this.abstractionsController.getCorePlus(f));
            if (this.chbxShape.isSelected())
                abstractions.add(this.abstractionsController.getShape(f));
        }
        return abstractions;

    }

    private EventHandler<? super MouseEvent> eventTableEmpty() {
        return e -> this.tableEmpty();
    }

    @FXML
    public void handleHelp() {
        Alert helpDialog = new Alert(Alert.AlertType.INFORMATION);
        helpDialog.setTitle("Help");
        helpDialog.setHeaderText("How to Use This Application");
        helpDialog.setContentText("This is a simple help dialog. Use this space to provide helpful information about the application.");

        // Show the dialog
        helpDialog.showAndWait();
    }

    @FXML
    public void handleAbout() {
        Alert helpDialog = new Alert(Alert.AlertType.INFORMATION);
        helpDialog.setTitle("Help");
        helpDialog.setHeaderText("How to Use This Application");
        helpDialog.setContentText("This is a simple help dialog. Use this space to provide helpful information about the application.");

        // Show the dialog
        helpDialog.showAndWait();
    }

    @FXML
    public void handleContactUs() {
        // Create an alert dialog for help information
        Alert helpDialog = new Alert(Alert.AlertType.INFORMATION);
        helpDialog.setTitle("Contact Us");
        helpDialog.setHeaderText("Contact Us");

        // Create the text and hyperlinks for the content
        Text contactText = new Text(
                "TARNAS has been realised within the BioShape and Data Science Lab with the contribution of:\n" +
                        "Piero Jean Pier Hierro Canchari, Michela Quadrini, Piermichele Rosati, and Luca Tesei.\n\n"
        );

        // Hyperlink for the BioShape Lab
        Text labWebsiteText = new Text("\nLab website: ");
        Hyperlink bioShapeLink = new Hyperlink("https://bdslab.unicam.it/");
        bioShapeLink.setOnAction(e -> openLink("https://bdslab.unicam.it/"));

        Text rna2FunWebsiteText = new Text("\nRNA2Fun Project website: ");
        Hyperlink rna2FunLink = new Hyperlink("https://bdslab.unicam.it/rna2fun/");
        rna2FunLink.setOnAction(e -> openLink("https://bdslab.unicam.it/rna2fun/"));

        Text contactInfo = new Text(
                "\n\nFor any issue, please contact:\n" +
                        "Prof. Luca Tesei\n\n" +
                        "Email: luca.tesei@unicam.it\n" +
                        "Address: School of Sciences and Technology, Via Madonna delle Carceri 7, 62032, Camerino (MC), Italy\n\n" +
                        "Personal website: "
        );

        Hyperlink personalWebsiteLink = new Hyperlink("www.lucatesei.com");
        personalWebsiteLink.setOnAction(e -> openLink("http://www.lucatesei.com/"));

        // Use TextFlow to handle mixed text and hyperlinks
        TextFlow dialogContent = new TextFlow(contactText, labWebsiteText, bioShapeLink, rna2FunWebsiteText, rna2FunLink, contactInfo, personalWebsiteLink);

        // Set the content of the alert dialog
        helpDialog.getDialogPane().setContent(dialogContent);

        // Show the dialog
        helpDialog.showAndWait();
    }

    // Helper method to open links in the default browser
    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
