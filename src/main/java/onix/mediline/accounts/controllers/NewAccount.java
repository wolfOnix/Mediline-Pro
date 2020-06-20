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
import java.nio.charset.StandardCharsets;

abstract public class NewAccount extends Home {

    @FXML
    protected TextField flNume, flPrenume, flEmail;

    @FXML
    Label lbInfoOverErr;

    protected void setErrorText (Exception e) {
        byte[] ptext = e.getMessage().getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        lbErrMessage.setText(value);
        lbInfoOverErr.setText("");
    }

}
