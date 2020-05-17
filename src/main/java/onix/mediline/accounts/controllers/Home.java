package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Home {

    @FXML
    private Button btLogout;

    @FXML
    void handleBtLogout (ActionEvent event) throws IOException {
        try  {
            Stage LoginStage = (Stage) btLogout.getScene().getWindow();
            Parent Login = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene LoginScene = new Scene(Login);
            LoginStage.setResizable(false);
            LoginStage.setScene(LoginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getBtLogout() {
        return btLogout;
    }

}
