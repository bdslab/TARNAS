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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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

    private Boolean isTranslating;

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
    public CheckBox chbxGenerateStatistics;

    @FXML
    public CheckBox chbxGenerateNonCanonicalPairs;

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
        this.isTranslating = null;
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
        this.formatColumn.setCellValueFactory(rnaFile -> new ReadOnlyObjectWrapper<>(rnaFile.getValue().getFormat().getName()));
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
                        .filter(f ->
                        {
                            var pathSelectedDir = selectedDirectory.toPath().getFileName().toString();
                            var pathFromDirName = f.toString().substring(f.toString().indexOf(pathSelectedDir));
                            var pathBetweenDirAndFile = pathFromDirName.substring(0, pathFromDirName.lastIndexOf(f.getFileName().toString()));
                            return (!f.getFileName().toString().startsWith(".") && !pathBetweenDirAndFile.contains("."));
                        })
                        .toList();
                for (var f : files)
                    this.addFileToTable(f);

                logger.info("Folder added successfully");
            } catch (Exception e) {
                // Uncomment the following line in case you would like to show which file was not loaded due to a parsing error. If uncommented, the app will stop as soon as it will find an error.
                //showAlert(Alert.AlertType.ERROR, "", "", e.getMessage());
            }
        }
        logger.info("Exit add file");
    }

    public List<RNAFile> clean(List<RNAFile> files) throws RNAFileException {
        var cleanedFiles = new ArrayList<RNAFile>();

        for (var f : files) {
            try {
                // Determine the options from checkboxes
                boolean removeComments = chbxRmAllComments.isSelected();
                boolean removeEmptyLines = chbxRmBlankLines.isSelected();
                boolean mergeLines = chbxMergeLines.isSelected();

                // If the "remove lines containing word" checkbox is selected, retrieve the word; otherwise null
                String stringToBeRemoved = chbxRmLinesContainingWord.isSelected()
                        ? textFieldRmLinesContainingWord.getText()
                        : null;

                var cleanedFile = cleanerController.clean(
                        f,
                        removeComments,
                        stringToBeRemoved,
                        removeEmptyLines,
                        mergeLines
                );

                cleanedFiles.add(cleanedFile);
            } catch (Exception e) {
                throw new RNAFileException("Error caused by: " + f.getFileName());
            }
        }
        return cleanedFiles;
    }


    private List<RNAFile> translate(List<RNAFile> files) throws RNAFileException {
        var translatedFiles = new ArrayList<RNAFile>();

        for (var file : files) {
            try {
                // Translate the file to the desired format
                var translatedFile = translatorController.translate(file, selectedFormat);

                // Optionally remove the header, if the user doesn't want to include it
                if (!chbxIncludeHeader.isSelected()) {
                    translatedFile = cleanerController.removeHeader(translatedFile);
                }

                translatedFiles.add(translatedFile);
            } catch (Exception e) {
                throw new RNAFileException("Error caused by: " + file.getFileName());
            }
        }
        return translatedFiles;
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
        var files = ioController.getLoadedRNAFiles();
        try {
            if (this.isTranslating == null) {
                showAlert(Alert.AlertType.INFORMATION, "", "", "You must select an option before running!");
                return;
            }
            if (this.isTranslating) {
                files = clean(files);
                // checks is format is selected
                if (this.selectedFormat != null)
                    files = this.translate(files);
                saveFilesTo(files);
            } else {
                files = this.abstractions(files);
                saveFilesTo(files);
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
        this.btnSelectFormatTranslation.setText("Translate to");
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
    }

    private void addFileToTable(Path selectedRNAFile) throws RNAFileException {
        try {
            var rnaFile = this.ioController.loadFile(selectedRNAFile);
            this.filesTable.getItems().add(rnaFile);
            this.paneTranslationCleaning.setDisable(false);
            this.chbxMergeLines.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            this.abstractionsPane.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            this.chbxGenerateNonCanonicalPairs.setDisable(this.ioController.getRecognizedFormat() != RNAML);
            // add event to select ButtonItem for destination format translation
            this.initSelectEventOnButtonItems(this.translatorController.getAvailableTranslations(rnaFile.getFormat()));
        } catch (Exception e) {
            logger.severe("Could not load file: " + selectedRNAFile);
            throw new RNAFileException("Error caused by: " + selectedRNAFile);
        }
    }

    private void saveFilesTo(List<RNAFile> rnaFiles) throws IOException {
        // If ZIP is selected, ensure a valid archive name is provided
        String archiveName = "";
        if (chbxSaveAsZIP.isSelected()) {
            if (textFieldArchiveName.getText().isBlank()) {
                showAlert(Alert.AlertType.ERROR, "", "", "Please enter a name for the zip!");
                return;
            }
            archiveName = textFieldArchiveName.getText().trim();
        }

        showAlert(Alert.AlertType.INFORMATION, "", "", "Choose the directory where to save the files");
        var directoryChooser = new DirectoryChooser();
        var selectedDirectory = directoryChooser.showDialog(this.getPrimaryStage());

        if (selectedDirectory == null) {
            logger.info("No directory selected, no files saved");
            return;
        }

        // Save the files
        ioController.saveFiles(
                rnaFiles,
                selectedDirectory.toPath(),
                chbxGenerateNonCanonicalPairs.isSelected(),
                chbxGenerateStatistics.isSelected(),
                archiveName
        );

        // Determine the final path for displaying in the alert and logs
        String finalPath;
        if (chbxSaveAsZIP.isSelected())
            finalPath = selectedDirectory.toPath().resolve(archiveName + ".zip").toString();
        else
            finalPath = selectedDirectory.getPath();

        showAlert(
                Alert.AlertType.INFORMATION,
                "",
                "Files saved successfully",
                "Files saved in: " + finalPath
        );
        logger.info(rnaFiles.size() + " files saved in: " + finalPath);
    }


    private void tableEmpty() {
        if (this.filesTable.getItems().isEmpty()) {
            this.selectedFormat = null;
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
            this.chbxGenerateNonCanonicalPairs.setSelected(false);
            this.chbxGenerateStatistics.setSelected(false);
            // reset textAreas
            this.textFieldArchiveName.setText("");
            this.textFieldRmLinesContainingWord.setText("");
            // reset menu button
            this.btnSelectFormatTranslation.setText("Translate to");
            // reset panes
            this.paneTranslationCleaning.setDisable(true);
            this.isTranslating = null;
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
        String helpContent = """
                            <h2>General information</h2>
                               RNA secondary structure analysis, including comparison and classification, plays a fundamental
                                       role in facing different problems, such as the prediction of RNA functions and the study of
                                       regulating gene expression. Existing tools for RNA analysis do not take secondary structures as
                                       input in the same formats due to the lack of an input standard to represent RNA secondary
                                       structures.
                                       <br>TARNAS supports translations of RNA secondary structures in the following formats:
                                       <ul>
                                       <li>BPSEQ - <a href="https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html" target="_blank">https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html</a></li>
                                       <li>CT - <a href="https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html" target="_blank">https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html</a></li>
                                       <li>Dot-Bracket - <a href="https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html" target="_blank">https://www.ibi.vu.nl/programs/k2nwww/static/data_formats.html</a></li>
                                       <li>RNAML - <a href="https://pmc.ncbi.nlm.nih.gov/articles/PMC1370290/" target="_blank">https://pmc.ncbi.nlm.nih.gov/articles/PMC1370290/</a></li>
                                       <li>arc-annotated sequence - <a href="https://github.com/bdslab/aspralign" target="_blank">https://github.com/bdslab/aspralign</a></li>
                                       <li>Fasta (only primary structure) - <a href="https://www.ncbi.nlm.nih.gov/genbank/fastaformat/" target="_blank">https://www.ncbi.nlm.nih.gov/genbank/fastaformat/</a></li>
                                       </ul>
                                       <br>
                                       Moreover, TARNAS allows the user to abstract the RNA secondary structure into three forms, i.e.,
                                       Core, Core Plus and Shape, and to edit or delete the header of files.
                               <br><br>
                               <h2>How to use TARNAS</h2>
                                       There are three main scenarios for using the TARNAS application:
                                       <ol>
                                           <li>RNA secondary structure translations</li>
                                           <li>Deleting or retaining comments, blank lines and headers of the file</li>
                                           <li>Abstracting RNA secondary structures into three views: Core, Core Plus and Shape</li>
                                       </ol>
                                       <em>RNA secondary structure translations scenario.</em>
                                       <br><br>
                                       Step 1. In the first step of this scenario, a user should upload the RNA secondary structure provided
                                       in a supported format.
                                       <br>The file can be uploaded directly from a local drive (use the &quot;Browse&quot; button
                                       to browse through the local repositories).
                                       <br>There are two examples stored in the system and ready for
                                       processing. Uploaded data can be viewed in the text area after clicking the &quot;Preview&quot; button and
                                       edited before further processing.
                                       <br><br>
                                       Step 2. In this step, the user can decide whether to include or not the header and the output format.
                                       <br>The user selects the additional option &quot;include reader&quot; to include the header and the format in the
                                       dropdown menu.
                                       <br><br>
                                       Step 3. To start the transformation of secondary structure, the &quot;Run&quot; button should be clicked.
                                       <br><br>
                                       <em>Deleting or retaining comments, blank lines and headers of the file.</em>
                                       <br><br>
                                       Step 1. In the first step of this scenario, a user should upload the RNA secondary structure provided
                                       in a supported format.
                                       <br>The file can be uploaded directly from a local drive (use the &quot;Browse&quot; button
                                       to browse through the local repositories).
                                       <br>There are two examples stored in the system and ready for
                                       processing. Uploaded data can be viewed in the text area after clicking the &quot;Preview&quot; button and
                                       edited before further processing.
                                       <br><br>
                                       Step 2. In this step, the user can decide to remove all comments, lines containing a particular word
                                       or empty lines by selecting the relative option.
                                       <br>If the user intends to delete lines containing a particular word, it is necessary to specify the word in the box.
                                       <br><br>
                                       Step 3. To start editing or delete the comments, the &quot;Run&quot; button should be clicked.
                                       <br><br>
                                       <em>Abstracting RNA secondary structures into three views: Core, Core Plus and Shape</em>
                                       <br><br>
                                       Step 1. In the first step of this scenario, a user should upload the RNA secondary structure provided
                                       in a supported format.
                                       <br>The file can be uploaded directly from a local drive (use the &quot;Browse&quot; button
                                       to browse through the local repositories).
                                       <br>There are two examples stored in the system and ready for
                                       processing. Uploaded data can be viewed in the text area after clicking the &quot;Preview&quot; button and
                                       edited before further processing.
                                       <br><br>
                                       Step 2. In this step, the user can decide the type of abstractions, such as Core, Core Plus, or Shape by selecting the corresponding option.
                                       <br><br>
                                       Step 3. To start editing or delete the comments, the &quot;Run&quot; button should be clicked.
                """;

        showAlertWithContent("Help", "How to Use This Application", helpContent);
    }

    @FXML
    public void handleAbout() {
        String aboutContent = """
                        <h2>About TARNAS</h2>TARNAS is a tool that translates RNA secondary structures into different formats, including
                              BPSEQ, CT, RNAML, Dot-Bracket, FASTA (only primary structure) and arc-annotated sequence.
                              <br>
                              Moreover, TARNAS allows us to abstract RNA secondary structures into three views, namely Core,
                              Core Plus and Shape.
                              <br>Finally, TARNAS permits to delete or retain comments, blank lines and
                              headers of the files.
                              <br>TARNAS is developed as a standalone desktop application and as a web app.
                              <br>The standalone desktop application can be found at <a href="https://github.com/bdslab/TARNAS" target="_blank">https://github.com/bdslab/TARNAS</a> and the
                              web app is at <a href="https://bdslab.unicam.it/tarnas/" target="_blank">https://bdslab.unicam.it/tarnas/</a>
                             <br><br>
                        <h2>Citations</h2>
                        Any published work that has made use of TARNAS may cite the following paper:
                            <br><br>
                            Michela Quadrini, Piero Hierro Canchari, Piermichele Rosati, and Luca Tesei, TARNAS, a
                            TrAnslator for RNA Secondary structure formats.
                        <br><br>
                        <h2>Acknowledgements and Funding</h2><em>This work was supported by the European Union - Next-Generation EU - National Recovery and
                            Resilience Plan (NRRP) - MISSION 4 COMPONENT 2, INVESTMENT N. 1.1, CALL PRIN 2022
                            PNRR D.D. 1409 of 14th Sep 2022 - RNA2FUN CUP N. J53D23014960001- RNA2Fun:
                            <a href="https://bdslab.unicam.it/rna2fun/" target="_blank">https://bdslab.unicam.it/rna2fun/</a></em>
                """;

        showAlertWithContent("About TARNAS", "About This Application", aboutContent);
    }

    @FXML
    public void handleContactUs() {
        String contactUsContent = """
                <h2>Contact Us</h2>
                        <b class="bigger_text">TARNAS has been realised within the <a href="http://www.emanuelamerelli.eu/bigdata/doku.php" target="_blank">BioShape and Data Science Lab</a> with the contribution of Piero Jean Pier Hierro Canchari, Michela Quadrini, Piermichele Rosati and Luca Tesei.</b>
                        <p>Lab website: <a href="https://bdslab.unicam.it" target="_blank">https://bdslab.unicam.it</a></p>
                
                        <p>RNA2Fun Project website: <a href="https://bdslab.unicam.it/rna2fun/" target="_blank">https://bdslab.unicam.it/rna2fun/</a></p>
                
                        <b class="bigger_text">For any issue, please contact:</b>
                        <p>Prof. Luca Tesei</p>
                        <p>email: luca.tesei&#64;unicam.it</p>
                
                        <p>address: School of Sciences and Technology, Via Madonna delle Carceri 7, 62032, Camerino (MC), Italy</p>
                
                        <p>Personal website: <a href="http://www.lucatesei.com" target="_blank">http://www.lucatesei.com</a></p>
                """;
        showAlertWithContent("About TARNAS", "Contact Us", contactUsContent);
    }

    /**
     * General method to display a resizable Alert dialog with HTML content.
     *
     * @param title       The title of the Alert dialog.
     * @param header      The header text of the Alert dialog.
     * @param htmlContent The HTML content to display inside the WebView.
     */
    private void showAlertWithContent(String title, String header, String htmlContent) {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle(title);
        alertDialog.setHeaderText(header);

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(htmlContent);

        // Set initial size for the WebView
        webView.setPrefSize(1000, 600);

        // Allow resizing of the alert dialog
        alertDialog.setResizable(true);

        // Adjust WebView size when the dialog is resized
        alertDialog.widthProperty().addListener((obs, oldVal, newVal) -> {
            webView.setPrefWidth(newVal.doubleValue() - 50);  // Adjust width
        });

        alertDialog.heightProperty().addListener((obs, oldVal, newVal) -> {
            webView.setPrefHeight(newVal.doubleValue() - 100);  // Adjust height
        });

        // Intercept navigation requests and open them in the system's default browser
        webEngine.locationProperty().addListener((obs, oldLocation, newLocation) -> {
            if (newLocation != null && newLocation.startsWith("http")) {
                try {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(new URI(newLocation));  // Open the URL in the default system browser
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                webEngine.loadContent(htmlContent);  // Prevent navigation in the WebView by reloading the original content
            }
        });

        // Set the WebView as the content of the dialog
        alertDialog.getDialogPane().setContent(webView);

        // Show the dialog
        alertDialog.showAndWait();
    }
}
