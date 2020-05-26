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
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.exceptions.EmailNotValid;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;


public class NewAccountMed extends NewAccount {

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    private Label lbActivationKey;

    @FXML
    void handleButtonCreateAccount (ActionEvent event) throws IOException {
        try {
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flEmail.getText().length() < 2)
                throw new CompleteAllFields();
            Encryption.checkEmailStructure(flEmail.getText());
            Medic m = MedManagement.addMedic(flNume.getText(), flPrenume.getText(), flEmail.getText());
            lbActivationKey.setText(m.getActivationKey());
            System.out.println("Cont creat cu succes!");
        } catch (EmailAlreadyExistsException e) {
            super.setErrorText(e);
        } catch (CompleteAllFields e) {
            super.setErrorText(e);
        } catch (EmailNotValid e) {
            super.setErrorText(e);
        }
    }

    @FXML
    void handleButtonCancel (ActionEvent event) throws IOException {
        try  {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("homeAdm.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
