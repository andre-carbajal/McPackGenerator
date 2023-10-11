package net.anvian.mcpackgenerator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import net.anvian.mcpackgenerator.util.Compressor;
import net.anvian.mcpackgenerator.util.FolderLocation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WindowController {

    @FXML
    private TextField dir;

    @FXML
    void searchAction() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        try {
            File selectedDirectory = directoryChooser.showDialog(null);
            if (selectedDirectory != null){
                Path path = Paths.get(selectedDirectory.toURI());
                FolderLocation.setPath(path);
                dir.setText(String.valueOf(path));
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void generateAction() {

        Path path = FolderLocation.getPath();

        if (path == null) {
            showError("Please select a folder");
            return;
        }

        String zipFileName = getZipFileName(path);

        if (Files.exists(Paths.get(zipFileName))) {
            showError("File already exists");
            return;
        }

        Compressor.compress(zipFileName);

        if (!Files.exists(Paths.get(zipFileName))) {
            showError("Failed to create the zip file");
        }
    }

    @FXML
    void cleanAction() {
        FolderLocation.setPath(null);
        dir.setText("Folder location");
    }

    private String getZipFileName(Path path) {
        return path + ".mcpack";
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

}
