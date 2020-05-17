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
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;

public class ActivateAccountMedKey {

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flActivationKey;

    @FXML
    private Button btForward, btCancel;

    @FXML
    private Label lbErrMessage, lbInfoOverErr;

    @FXML
    void handleButtonCancel(ActionEvent event) throws IOException {
        try  {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonForward (ActionEvent event) {
        try  {
            Medic med = (Medic) UsersManagement.searchUser(flEmail.getText(), 2);
            Stage FowardStage = (Stage) btForward.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("activateAccountMed.fxml"));
            Parent Foward = loader.load();
            ActivateAccountMed ActAccMed = loader.getController();
            ActAccMed.setEmail(flEmail.getText());
            Scene FowardScene = new Scene(Foward);
            FowardStage.setScene(FowardScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (UserNotFound e) {
            lbErrMessage.setText(e.getMessage());
            lbInfoOverErr.setText("");
        }
    }

}

