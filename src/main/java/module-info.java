module net.anvian.mcpackgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.anvian.mcpackgenerator to javafx.fxml;
    exports net.anvian.mcpackgenerator;
}