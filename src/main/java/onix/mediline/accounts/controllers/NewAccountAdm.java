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
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.management.AdmManagement;
import javafx.scene.control.Label;

import java.io.IOException;

public class NewAccountAdm extends NewAccount {

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    private TextField flNume, flPrenume, flEmail;

    @FXML
    private PasswordField flPassword, flAdminKey;

    @FXML
    private Label lbErrMessage, lbInfoOverErr;

    @FXML
    void handleButtonCreateAccount (ActionEvent event) throws IOException {
        try {
            AdmManagement.addAdmin(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flAdminKey.getText());
            System.out.println("Cont creat cu succes (Admin)!");
            Stage AdminHomeStage = (Stage) btCreateAccount.getScene().getWindow();
            Parent AdminHome = FXMLLoader.load(getClass().getClassLoader().getResource("homeAdm.fxml"));
            Scene AdminHomeScene = new Scene(AdminHome);
            AdminHomeStage.setScene(AdminHomeScene);
        } catch (EmailAlreadyExistsException e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
            lbInfoOverErr.setText("");
        } catch (IOException e) {
            e.printStackTrace();
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

