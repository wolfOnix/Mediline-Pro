package onix.mediline.registration.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import onix.mediline.registration.example.services.UserService;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserService.loadUsersFromFile();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
        primaryStage.initStyle(StageStyle.DECORATED); // Dezactivare Title Bar
        primaryStage.setTitle("Mediline");
        //root.getStylesheets().add("style.css");
        primaryStage.getIcons().add(new Image("images/logo.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }
}
