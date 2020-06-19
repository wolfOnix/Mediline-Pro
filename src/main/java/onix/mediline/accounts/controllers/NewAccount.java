package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.exceptions.NotStrongEnoughPassword;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.roles.Admin;

import java.io.IOException;

abstract public class NewAccount extends Home {

    @FXML
    protected TextField flNume, flPrenume, flEmail;

    @FXML
    Label lbInfoOverErr;


    /*protected void setErrorText (Exception e) {
        try {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
            lbInfoOverErr.setText("");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }*/

    /*protected void checkFields () {
        try {
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flEmail.getText().length() < 2)
                throw new CompleteAllFields();
        } catch (CompleteAllFields e) {
            setErrorText(e);
        }
    }*/

}
