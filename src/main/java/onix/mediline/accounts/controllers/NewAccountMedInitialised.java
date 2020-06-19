package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccountMedInitialised extends AdmPages {

    @FXML
    private TextField flActivationKey;

    @FXML
    private Button btHome;

    @FXML
    void handleButtonActionHome(ActionEvent event) {
        try {
            Stage AdminHomeStage = (Stage) btHome.getScene().getWindow();
            Parent AdminHome = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene AdminHomeScene = new Scene(AdminHome);
            AdminHomeStage.setScene(AdminHomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Medkey(String key) {
        flActivationKey.setText(key);
    }

    @Override
    public void setup() {

    }
}
