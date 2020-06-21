package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import onix.mediline.accounts.exceptions.DelRequestAlreadySent;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.User;

public class MedPage5 extends MedPages {

    @FXML
    private Label flNume, flAdresa, flEmailServ, flPrenume, flTelefon;

    public void setup () {
        super.setup();
        flNume.setText(Med.getNume());
        flPrenume.setText(Med.getPrenume());
        flTelefon.setText(Med.getTelefon());
        flAdresa.setText(Med.getAdresa() + ", " + Med.getOras() + " (" + Med.getJudet() + ")");
        flEmailServ.setText(Med.getEmailServ());
    }

    @FXML
    public void requestDel(ActionEvent event) {
        try {
            if (Med.getRequestDelete())
                throw new DelRequestAlreadySent();
            User oldUser = Med;
            Med.setRequestDelete(true);
            UsersManagement.updateUser(oldUser, Med);
            setMessageLabel("Cererea de ștergere a contului fost trimisă");
        }  catch (DelRequestAlreadySent e) {
            super.setErrorText(e);
        }
    }

}