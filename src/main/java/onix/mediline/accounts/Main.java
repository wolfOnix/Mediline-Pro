package onix.mediline.accounts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AdmManagement.loadUsersFromFile();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
        primaryStage.initStyle(StageStyle.DECORATED); // Dezactivare Title Bar
        primaryStage.setTitle("Mediline");
        root.getStylesheets().add("style.css");
        primaryStage.getIcons().add(new Image("images/logo.png"));
        primaryStage.setResizable(false); // false pentru blocare dimensionare ferestre landscape
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
