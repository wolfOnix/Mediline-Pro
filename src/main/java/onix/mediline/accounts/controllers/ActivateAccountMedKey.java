package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ActivateAccountMedKey {

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flActivationKey;

    @FXML
    private Button btForward;

    @FXML
    private Button btCancel;

    @FXML
    private Label lbErrMessage;

    @FXML
    void handleButtonCancel(ActionEvent event) throws IOException {
        try  { Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonForward(ActionEvent event) {
        try  { Stage FowardStage = (Stage) btCancel.getScene().getWindow();
            Parent Foward = FXMLLoader.load(getClass().getClassLoader().getResource("activateAccountMed.fxml"));
            Scene FowardScene = new Scene(Foward);
            FowardStage.setScene(FowardScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

