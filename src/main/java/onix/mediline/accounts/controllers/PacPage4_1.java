package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import onix.mediline.accounts.roles.Medic;

public class PacPage4_1 extends PacPages {

    @FXML
    private Label flNume, flAdresa, flEmailServ, flPrenume, flTelefon, flMedID;

    public void setup() { }

    public void setup(Medic med) {
        flNume.setText(med.getNume());
        flPrenume.setText(med.getPrenume());
        flTelefon.setText(med.getTelefon());
        flAdresa.setText(med.getAdresa() + ", " + med.getOras() + " (" + med.getJudet() + ")");
        flEmailServ.setText(med.getEmailServ());
        flMedID.setText(med.getMedid());
    }

}
