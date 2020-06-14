package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.roles.Medic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static onix.mediline.accounts.management.MedManagement.searchMedID;

public class PacPage4_2 extends PacPages {

    @FXML
    private TextField flMedid;

    @FXML
    private Label lbMessage;

    @FXML
    void ActionAddMedicForPac(ActionEvent event)  {
        try {
            System.out.println("Pag4_2");
            Medic med = MedManagement.searchMedID(flMedid.getText());
            PacManagement.AddPacientMedID(med.getMedid(), Pac);
            MedManagement.attachPacEmail(Pac.getEmail(), med);
            ActionMyMed(null);
        }
        catch (MedIDNotFound | IOException e) {
            super.setErrorText(e);
        }
    }

}
