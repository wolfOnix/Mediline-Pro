package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PacPage4_1 extends PacPages {

    @FXML
    private Button btLogout;

    @FXML
    private Button btAccountSettings;

    @FXML
    private Label flNume;

    @FXML
    private Label flAdresa;

    @FXML
    private Label flEmailServ;

    @FXML
    private Label flPrenume;

    @FXML
    private Label flTelefon;

    @FXML
    private Label flMedID;

    public void setNume(String Nume) {
        flNume.setText(Nume);
    }

    public void setAdresa(String Cabinet) {
        flAdresa.setText(Cabinet);
    }

    public void setEmailServ(String EmailServ) {
        flEmailServ.setText(EmailServ);
    }

    public void setPrenume(String Prenume) {
        flPrenume.setText(Prenume);
    }

    public void setTelefon(String Telefon) {
        flTelefon.setText(Telefon);
    }

    public void setMedID(String MedID) {
        flMedID.setText(MedID);
    }

    @FXML
    void handleBtLogout(ActionEvent event) throws IOException {
        super.handleBtLogout(event);
    }
    @FXML
    void ActionMyAppointments(MouseEvent event) throws IOException {
        super.ActionMyAppointments(event);
    }

    @FXML
    void ActionMyFilesTxt(MouseEvent event) throws IOException {
        super.ActionMyFilesTxt(event);
    }

    @FXML
    void ActionMyMed(MouseEvent event) throws IOException {
        super.ActionMyMed(event);
    }

    @FXML
    void ActionNewAppointments(MouseEvent event) throws IOException {
        super.ActionNewAppointments(event);
    }

}
