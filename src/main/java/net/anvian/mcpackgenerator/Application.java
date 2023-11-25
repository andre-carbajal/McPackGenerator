package net.anvian.mcpackgenerator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 90);

        stage.setTitle("McPackGenerator v2.2");
        stage.getIcons().add(new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("icon.png"))));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}