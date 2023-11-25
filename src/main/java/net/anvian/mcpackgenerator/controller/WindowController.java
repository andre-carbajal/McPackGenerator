package net.anvian.mcpackgenerator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import net.anvian.mcpackgenerator.compress.Compressor;
import net.anvian.mcpackgenerator.compress.ICompress;
import net.anvian.mcpackgenerator.util.AlertService;
import net.anvian.mcpackgenerator.util.FolderLocation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WindowController {

    private static final ICompress compressor = new Compressor();

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
            AlertService.alertError("Please select a folder");
        }
    }

    @FXML
    void generateAction() {

        Path path = FolderLocation.getPath();

        if (path == null) {
            AlertService.alertError("Please select a folder");
            return;
        }

        String zipFileName = getZipFileName(path);

        if (fileExists(zipFileName)) {
            AlertService.alertError("File already exists");
            return;
        }

        compressor.compress(zipFileName);

        if (!fileExists(zipFileName)) {
           AlertService.alertError("Failed to create the zip file");
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

    private boolean fileExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }

}
