package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.exceptions.EmailNotValid;
import onix.mediline.accounts.exceptions.NotStrongEnoughPassword;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.Encryption;

import java.io.IOException;

public class NewAccountAdm extends NewAccount {

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    private PasswordField flPassword, flAdminKey;

    @FXML
    void handleButtonCreateAccount (ActionEvent event) throws IOException {
        try {
            //super.checkFields();
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flEmail.getText().length() < 2)
                throw new CompleteAllFields();
            Encryption.checkEmailStructure(flEmail.getText());
            Encryption.checkPasswordStrength(flPassword.getText());
            AdmManagement.addAdmin(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flAdminKey.getText());
            System.out.println("Cont creat cu succes (Admin)!");
            Stage AdminHomeStage = (Stage) btCreateAccount.getScene().getWindow();
            Parent AdminHome = FXMLLoader.load(getClass().getClassLoader().getResource("homeAdm.fxml"));
            Scene AdminHomeScene = new Scene(AdminHome);
            AdminHomeStage.setScene(AdminHomeScene);
        } catch (EmailAlreadyExistsException e) {
            super.setErrorText(e);
        } catch (NotStrongEnoughPassword e) {
            super.setErrorText(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CompleteAllFields e) {
            super.setErrorText(e);
        } catch (EmailNotValid e) {
            super.setErrorText(e);
        }
    }

    @FXML
    void handleButtonCancel (ActionEvent event) throws IOException {
        try {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

