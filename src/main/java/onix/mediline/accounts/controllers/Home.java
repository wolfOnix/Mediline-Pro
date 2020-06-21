package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.roles.Admin;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public abstract class Home {

    @FXML
     Label lbErrMessage, lbGreeting, lbMessage;

    @FXML
    protected Button btLogout;

    protected void setErrorText (Exception e) {
        byte[] ptext = e.getMessage().getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        lbErrMessage.setText(value);
        lbMessage.setText("");
    }

    protected void setMessageLabel (String message) {
        byte[] ptext = message.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        lbMessage.setText(value);
        lbErrMessage.setText("");
    }

    @FXML
    void handleBtLogout (ActionEvent event) throws IOException {
        try  {
            Stage LoginStage = (Stage) btLogout.getScene().getWindow();
            Parent Login = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("index.fxml")));
            Scene LoginScene = new Scene(Login);
            LoginStage.setResizable(false);
            LoginStage.setScene(LoginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getBtLogout() {
        return btLogout;
    }

    public static void checkFieldLength(String fieldText) throws CompleteAllFields {
        if (fieldText == null || fieldText.equals("") || fieldText.equals("null"))
            throw new CompleteAllFields();
    }

}
