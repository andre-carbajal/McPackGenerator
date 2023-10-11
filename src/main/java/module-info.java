module net.anvian.mcpackgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.anvian.mcpackgenerator to javafx.fxml;
    exports net.anvian.mcpackgenerator;
    exports net.anvian.mcpackgenerator.controller;
    opens net.anvian.mcpackgenerator.controller to javafx.fxml;
}