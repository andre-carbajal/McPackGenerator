package net.anvian.mcpackgenerator.util;

import javafx.scene.control.Alert;

public class AlertService {
    public static void alertConfirmation(String txt) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(txt);
        alert.showAndWait();
    }
    public static void alertError(String txt) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(txt);
        alert.showAndWait();
    }
}
