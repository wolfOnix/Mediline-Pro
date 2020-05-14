package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.management.UsersManagement;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Pacient", "Administrator");
    }

   /* @FXML
    public void handleRegisterAction() {
        try {
            UsersManagement.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Cont creat cu succes!");
        } catch (EmailAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }*/
}
