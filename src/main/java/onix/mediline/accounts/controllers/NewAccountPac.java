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
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.*;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.appointments.management.Appointment;


public class NewAccountPac extends NewAccount implements Initializable {

    @FXML
    private TextField flPassword, flCNP, flAdresa, flOras, flTelefon;

    @FXML
    private DatePicker flData;

    @FXML
    private ComboBox<String> cbSexul = new ComboBox<String>();
    ObservableList<String> listaMF = FXCollections.observableArrayList("M", "F");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbSexul.setItems(listaMF);
    }

    @FXML
    private Button btCancel, btCreateAccount;

    @FXML
    void handlebuttonCancel(ActionEvent event) throws IOException {
        try { Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonRegistration (ActionEvent event) throws IOException{
        try {
            String dataN = String.valueOf(flData.getValue());
            Home.checkFieldLength(dataN);
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flEmail.getText().length() < 2 || flCNP.getText().length() != 13 || flAdresa.getText().length() < 2 || flOras.getText().length() < 2 || flTelefon.getText().length() < 10 || flTelefon.getText().length() > 17 || (!cbSexul.getValue().equals("M") && !cbSexul.getValue().equals("F")))
                throw new CompleteAllFields();
            Encryption.checkEmailStructure(flEmail.getText());
            Encryption.checkPasswordStrength(flPassword.getText());
            Date now = new Date();
            if ((now.getTime() / 1000) - (Appointment.toDateFormat(dataN, "00:00").getTime() / 1000) < 14 * 365 * 24 * 60 * 60)
                throw new TooYoungPatient();
            PacManagement.addPacient(flNume.getText(), flPrenume.getText(), flEmail.getText(), flPassword.getText(), flCNP.getText(), flAdresa.getText(),  flOras.getText(),  flTelefon.getText(), dataN, cbSexul.getValue());
            System.out.println("Cont creat cu succes!");
            Stage PacFinishedStage = (Stage) btCreateAccount.getScene().getWindow();
            Parent PacFinished = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountDone.fxml"));
            Scene PacFinishedScene = new Scene(PacFinished);
            PacFinishedStage.setScene(PacFinishedScene);
        } catch (CompleteAllFields | EmailAlreadyExistsException | NotStrongEnoughPassword | EmailNotValid | TooYoungPatient | ParseException e) {
            super.setErrorText(e);
        }

    }

}
