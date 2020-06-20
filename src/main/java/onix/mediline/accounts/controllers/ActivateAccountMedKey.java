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
import onix.mediline.accounts.exceptions.AccountAlreadyActivated;
import onix.mediline.accounts.exceptions.CheckMedicKeyExeception;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;
import java.util.Objects;

public class ActivateAccountMedKey extends NewAccount {

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flActivationKey;

    @FXML
    private Button btCancel;

    @FXML
    void handleButtonCancel(ActionEvent event) {
        try  {
            Stage thisStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("index.fxml")));
            Scene CancelScene = new Scene(Cancel);
            thisStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonForward(ActionEvent event) {
        try  {
            Medic med = (Medic) UsersManagement.searchUser(flEmail.getText(), 2);
            if (med.getContActiv())
                throw new AccountAlreadyActivated();
            if(!flActivationKey.getText().equals(med.getActivationKey()))
                throw new CheckMedicKeyExeception();
            Stage thisStage = (Stage) btCancel.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("activateAccountMed.fxml"));
            Parent Forward = loader.load();
            ActivateAccountMed ActAccMed = loader.getController();
            ActAccMed.setEmail(flEmail.getText());
            Scene ForwardScene = new Scene(Forward);
            thisStage.setScene(ForwardScene);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserNotFound | AccountAlreadyActivated | CheckMedicKeyExeception e) {
            super.setErrorText(e);
        }
    }

}

