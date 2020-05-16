package onix.mediline.accounts.controllers;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class Login {

    @FXML
    private Button btLogin, btNewAccount, btNewAdmin, btActivateAccount, closeButton;

    @FXML
    private Label lbErrMessage;

    @FXML
    void handleActionButtonNewAdmin(ActionEvent event) throws IOException {
        try  { Stage NewAdminStage = (Stage) btNewAdmin.getScene().getWindow();
            Parent NewAdmin = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountAdmin.fxml"));
            Scene NewAdminScene = new Scene(NewAdmin);
            NewAdminStage.setScene(NewAdminScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonNewAccount(ActionEvent event) throws IOException {
        try  { Stage NewAccountStage = (Stage) btNewAccount.getScene().getWindow();
            Parent NewAccount = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountPac.fxml"));
            Scene NewAccountScene = new Scene(NewAccount);
            NewAccountStage.setScene(NewAccountScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleButtonActivateAccount(ActionEvent event) throws IOException {
        try  { Stage ActiveAccountStage = (Stage) btNewAccount.getScene().getWindow();
            Parent ActiveAccount = FXMLLoader.load(getClass().getClassLoader().getResource("activateAccountMedKey.fxml"));
            Scene ActiveAccountScene = new Scene(ActiveAccount);
            ActiveAccountStage.setScene(ActiveAccountScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closeButtonAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
