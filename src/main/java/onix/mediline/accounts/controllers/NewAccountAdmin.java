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
import onix.mediline.accounts.management.UsersManagement;

import java.io.IOException;

public class NewAccountAdmin extends NewAccount {

    @FXML
    private Button btCancel;

    @FXML
    private Button btCreateAccount;

    @FXML
    private TextField flNume;

    @FXML
    private TextField flPrenume;

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flPassword;

    @FXML
    private PasswordField flAdminKey;

    @FXML
    void handleButtonCancel(ActionEvent event) throws IOException {
        try {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonCreateAccount(ActionEvent event) throws IOException {
        try {
            UsersManagement.addAdmin(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flAdminKey.getText());
            System.out.println("Cont creat cu succes(Admin)!");
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } //catch (CheckAdminKeyException e) {
          //  System.out.println(e.getMessage());
        //}
        //Open AdminHopePage
        /*try  { Stage AdminHomeStage = (Stage) btCreateAccount.getScene().getWindow();
            Parent AdminHome = FXMLLoader.load(getClass().getClassLoader().getResource("homeAdmin.fxml"));
            Scene AdminHomeScene = new Scene(AdminHome);
            AdminHomeStage.setScene(AdminHomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  */
    }
}

