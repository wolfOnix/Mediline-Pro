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
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.MedicManagement;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivateAccountMed implements Initializable {


    @FXML
    private ComboBox<String> cbJudet = new ComboBox<String>();

    ObservableList<String> listaMF = FXCollections.observableArrayList("AB", "AG", "AR", "B", "BC", "BH", "BN", "BR", "BT", "BV", "BZ", "CJ", "CL", "CS", "CT", "CV", "DB", "DJ", "GJ", "GL", "GR", "HD", "HR", "IF", "IL", "IS", "MH", "MM", "MS", "NT", "OT", "PH", "SB", "SJ", "SM", "SV", "TL", "TM", "TR", "VL", "VN", "VS");

    @FXML
    private Label lbEmail, lbMedid, lbErrMessage, lbInfoOverErr;

    @FXML
    private PasswordField flPassword;

    @FXML
    private TextField flAdresa, flOras, flTelefon, flEmailServ, flPrenume, flNume;

    @FXML
    private Button btCancel, btActivateAccount;

    private Medic med;

    @FXML
    void handleBtFinishActivateAccount (ActionEvent event) throws IOException {
        try {
            MedicManagement.updateMedic(flNume.getText(), flPrenume.getText(), med.getEmail(), flPassword.getText(), flAdresa.getText(), flOras.getText(), cbJudet.getValue(), flTelefon.getText(), flEmailServ.getText(), true);
            System.out.println("Cont activat");
        } catch (CompleteAllFields e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
            lbInfoOverErr.setText("");
        } catch (UserNotFound e) {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
            lbInfoOverErr.setText("");
        }
    }

    @FXML
    void handleButtonCancel (ActionEvent event) {
        try {
            Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("activateAccountMedKey.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbJudet.setItems(listaMF);
    }

    public void setEmail (String email) {
        lbEmail.setText(email);
        try {
            cbJudet.setItems(listaMF);
            med = (Medic) UsersManagement.searchUser(lbEmail.getText(), 2);
            System.out.println("Medic: " + med);
            flNume.setText(med.getNume());
            flPrenume.setText(med.getPrenume());
            lbMedid.setText(med.getMedid());
        }   catch (UserNotFound e) {
            lbErrMessage.setText(e.getMessage());
            lbInfoOverErr.setText("");
        }
    }

}
