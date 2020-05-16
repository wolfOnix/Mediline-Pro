package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.management.UsersManagement;


public class NewAccountPac extends NewAccount implements Initializable {

    @FXML
    private TextField flNume;

    @FXML
    private TextField flPrenume;

    @FXML
    private TextField flEmail;

    @FXML
    private PasswordField flPassword;

    @FXML
    private TextField flCNP;

    @FXML
    private TextField flAdresa;

    @FXML
    private TextField flOras;

    @FXML
    private TextField flTelefon;

    @FXML
    private DatePicker flData;

    @FXML
    private Button btCancel;

    @FXML
    private Button btCreateAccount;

    @FXML
    private Label lbErrMessage;

    @FXML
    void handlebuttonCancel(ActionEvent event) throws IOException {
        try  { Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleButtonRegistration(ActionEvent event) {
        try {
            PacManagement.addPacient(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flCNP.getText(), flAdresa.getText(),  flOras.getText(),  flTelefon.getText(), String.valueOf(flData.getValue()));
            System.out.println("Cont creat cu succes!");
        } catch (EmailAlreadyExistsException e) {
            lbErrMessage.setText(e.getMessage());
       }

    }
    @FXML
    private ComboBox<String> comboMF = new ComboBox<String>();

    ObservableList<String> listaMF = FXCollections.observableArrayList("M", "F");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboMF.setItems(listaMF);
    }

}
