package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import onix.mediline.accounts.roles.Medic;

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

    public void setup() { }

    public void setup(Medic med) {
        setAdresa(med.getAdresa() + ", " + med.getOras() + " (" + med.getJudet() + ")");
        setEmailServ(med.getEmailServ());
        setMedID(med.getMedid());
        setNume(med.getNume());
        setPrenume(med.getPrenume());
        setTelefon(med.getTelefon());
    }

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

}
