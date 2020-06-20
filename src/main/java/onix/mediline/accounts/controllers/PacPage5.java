package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import onix.mediline.accounts.exceptions.DelRequestAlreadySent;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.User;

public class PacPage5 extends PacPages {

    @FXML
    private Label lbNume, lbPrenume, lbTelefon, lbOras, lbData, lbEmail, lbAdresa, lbSexul, lbCNP;

    @Override
    public void setup() {
        lbNume.setText(Pac.getNume());
        lbPrenume.setText(Pac.getPrenume());
        lbTelefon.setText(Pac.getTelefon());
        lbAdresa.setText(Pac.getAdresa());
        lbOras.setText(Pac.getOras());
        lbData.setText(Pac.getDataNasterii());
        lbEmail.setText(Pac.getEmail());
        lbSexul.setText(Pac.getSexul());
        lbCNP.setText(Pac.getCNP());
    }

    @FXML
    public void requestDel(ActionEvent event) {
        try {
            if (Pac.getRequestDelete())
                throw new DelRequestAlreadySent();
            User oldUser = Pac;
            Pac.setRequestDelete(true);
            UsersManagement.updateUser(oldUser, Pac);
            setMessageLabel("Cererea de ștergere a contului fost trimisă");
        }  catch (DelRequestAlreadySent e) {
            super.setErrorText(e);
        }
    }

}
