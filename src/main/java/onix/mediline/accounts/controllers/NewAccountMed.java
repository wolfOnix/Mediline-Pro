package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class NewAccountMed extends NewAccount {

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    private TextField flNume, flPrenume, flEmail;

    @FXML
    private Label lbNume, lbErrMessage, lbInfoOverErr;

    @FXML
    void handleButtonCancel(ActionEvent event) throws IOException {
        try  {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("homeAdmin.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
