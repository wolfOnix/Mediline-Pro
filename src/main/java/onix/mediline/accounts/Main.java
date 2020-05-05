package onix.mediline.accounts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import onix.mediline.accounts.services.UserService;

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
        root.getStylesheets().add("style.css");
        primaryStage.getIcons().add(new Image("images/logo.png"));
        primaryStage.setResizable(false); // false pentru blocare dimensionare ferestre landscape, true in rest?
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
