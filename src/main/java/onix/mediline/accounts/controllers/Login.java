package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import onix.mediline.accounts.exceptions.AccountNotActivated;
import onix.mediline.accounts.exceptions.IncorrectPassword;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Admin;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.User;

import java.io.IOException;

public class Login {

    @FXML
    private Button btLogin, btNewAccount, btNewAdmin, btActivateAccount, closeButton;

    @FXML
    private Label lbErrMessage;

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flPassword;

    @FXML
    void handleBtLogin (ActionEvent event) throws IOException {
        try {
            User user = UsersManagement.searchUser(flEmail.getText(), 0);
            System.out.println(flPassword.getText());
            System.out.println(user.getParola());
            if(!user.getParola().equals(Encryption.encryptString(user.getEmail(),flPassword.getText())))
                throw new IncorrectPassword();
            String homeName;
            boolean resizable = true;
            if (user instanceof Admin) {
                homeName = "homeAdm.fxml";
                System.out.println("Admin detectat");
                resizable = false;
            }
            else
                if (user instanceof Medic) {
                    homeName = "homeMed.fxml";
                    System.out.println("Medic detectat");
                }
                else {
                    homeName = "homePac.fxml";
                    System.out.println("Pacient detectat");
                }
            if (!user.getContActiv())
                throw new AccountNotActivated();
            /*Stage HomeStage = (Stage) btLogin.getScene().getWindow();
            HomeStage.setResizable(resizable);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(homeName));
            Parent Home = loader.load();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);*/
            Stage HomeStage = (Stage) btLogin.getScene().getWindow();
            // HomeStage.setResizable(resizable);
            Parent Home = FXMLLoader.load(getClass().getClassLoader().getResource(homeName));
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserNotFound e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
        } catch (AccountNotActivated e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
        } catch (IncorrectPassword e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
        }

    }

    @FXML
    void handleActionButtonNewAdmin (ActionEvent event) throws IOException {
        try {
            Stage NewAdminStage = (Stage) btNewAdmin.getScene().getWindow();
            Parent NewAdmin = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountAdm.fxml"));
            Scene NewAdminScene = new Scene(NewAdmin);
            NewAdminStage.setScene(NewAdminScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonNewAccount (ActionEvent event) throws IOException {
        try {
            Stage NewAccountStage = (Stage) btNewAccount.getScene().getWindow();
            Parent NewAccount = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountPac.fxml"));
            Scene NewAccountScene = new Scene(NewAccount);
            NewAccountStage.setScene(NewAccountScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonActivateAccount (ActionEvent event) throws IOException {
        try {
            Stage ActiveAccountStage = (Stage) btNewAccount.getScene().getWindow();
            Parent ActiveAccount = FXMLLoader.load(getClass().getClassLoader().getResource("activateAccountMedKey.fxml"));
            Scene ActiveAccountScene = new Scene(ActiveAccount);
            ActiveAccountStage.setScene(ActiveAccountScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closeButtonAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
