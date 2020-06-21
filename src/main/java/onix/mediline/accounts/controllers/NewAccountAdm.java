package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.*;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.UsersManagement;
import java.io.*;
import java.util.Objects;

public class NewAccountAdm extends NewAccount {

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    private PasswordField flPassword, flAdminKey;

    @FXML
    public void handleButtonCreateAccount (ActionEvent event) throws IOException {
        try {
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flEmail.getText().length() < 2)
                throw new CompleteAllFields();
            UsersManagement.searchUserAlready(flEmail.getText());
            Encryption.checkEmailStructure(flEmail.getText());
            Encryption.checkPasswordStrength(flPassword.getText());
            AdmManagement.checkAdminKey(flAdminKey.getText());
            AdmManagement.addAdmin(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flAdminKey.getText());
            Stage AdminFinishedStage = (Stage) btCreateAccount.getScene().getWindow();
            Parent AdminFinished = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("newAccountDone.fxml")));
            Scene AdminFinishedScene = new Scene(AdminFinished);
            AdminFinishedStage.setScene(AdminFinishedScene);
        } catch (EmailAlreadyExistsException | NotStrongEnoughPassword | CompleteAllFields | EmailNotValid | CheckAdminKeyException e) {
            super.setErrorText(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleButtonCancel (ActionEvent event) {
        try {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("index.fxml")));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}