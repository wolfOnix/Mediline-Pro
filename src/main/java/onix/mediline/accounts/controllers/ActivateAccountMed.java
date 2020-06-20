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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.EmailNotValid;
import onix.mediline.accounts.exceptions.NotStrongEnoughPassword;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.Encryption;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ActivateAccountMed extends NewAccount implements Initializable {

    @FXML
    ComboBox<String> cbJudet = new ComboBox<>();

    ObservableList<String> listaMF = FXCollections.observableArrayList("AB", "AG", "AR", "B", "BC", "BH", "BN", "BR", "BT", "BV", "BZ", "CJ", "CL", "CS", "CT", "CV", "DB", "DJ", "GJ", "GL", "GR", "HD", "HR", "IF", "IL", "IS", "MH", "MM", "MS", "NT", "OT", "PH", "SB", "SJ", "SM", "SV", "TL", "TM", "TR", "VL", "VN", "VS");

    @FXML
    private Label lbEmail, lbMedid;

    @FXML
    PasswordField flPassword;

    @FXML
    TextField flAdresa, flOras, flTelefon, flEmailServ;

    @FXML
    private Button btCancel;

    private Medic med;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbJudet.setItems(listaMF);
    }

    @FXML
    void handleBtFinishActivateAccount() throws IOException {
        try {
            if (flNume.getText().length() < 2 || flPrenume.getText().length() < 2 || flAdresa.getText().length() < 2 || cbJudet.getValue().length() != 2 || flOras.getText().length() < 2 || flTelefon.getText().length() < 10 || flTelefon.getText().length() > 17)
                throw new CompleteAllFields();
            Encryption.checkPasswordStrength(flPassword.getText());
            Encryption.checkEmailStructure(flEmailServ.getText());
            MedManagement.updateMedic(flNume.getText(), flPrenume.getText(), med.getEmail(), flPassword.getText(), flAdresa.getText(), flOras.getText(), cbJudet.getValue(), flTelefon.getText(), flEmailServ.getText(), true);
            Stage thisStage = (Stage) btCancel.getScene().getWindow();
            Parent nextResource = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("newAccountDone.fxml")));
            Scene nextScene = new Scene(nextResource);
            thisStage.setScene(nextScene);
        } catch (CompleteAllFields | UserNotFound | NotStrongEnoughPassword | EmailNotValid e) {
            super.setErrorText(e);
        }
    }

    @FXML
    void handleButtonCancel (ActionEvent event) {
        try {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("activateAccountMedKey.fxml")));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEmail (String email) {
        lbEmail.setText(email);
        try {
            cbJudet.setItems(listaMF);
            med = (Medic) UsersManagement.searchUser(lbEmail.getText(), 2);
            flNume.setText(med.getNume());
            flPrenume.setText(med.getPrenume());
            lbMedid.setText(med.getMedid());
        } catch (UserNotFound e) {
            super.setErrorText(e);
        }
    }

}
