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

import static onix.mediline.accounts.management.MedManagement.searchMedID;

public class PacPage4_2 extends PacPages {

    @FXML
    private Button btLogout;

    @FXML
    private Button btAccountSettings;

    @FXML
    private Pane pnNoMedID;

    @FXML
    private Button btPacPg1;

    @FXML
    private Pane pnMyAppointments;

    @FXML
    private Label btMyAppointmentsTxt;

    @FXML
    private Button btPacPg2;

    @FXML
    private Pane pnNewAppointment;

    @FXML
    private Label btNewAppointmentTxt;

    @FXML
    private Button btPacPg3;

    @FXML
    private Pane pnMyFiles;

    @FXML
    private Label btMyFilesTxt;

    @FXML
    private Button btPacPg4;

    @FXML
    private Pane pnMyMed;

    @FXML
    private Label btMyMedTxt;

    @FXML
    private TextField flMedid;

    @FXML
    private Button btMedid;

    @FXML
    private Label lbErrMessage;

    @FXML
    void handleBtLogout(ActionEvent event) throws IOException {
        super.handleBtLogout(event);

    }
    @FXML
    void ActionAddMedicForPac(ActionEvent event)  {
        try {
            System.out.println("Pag4_2");
            Medic med = MedManagement.searchMedID(flMedid.getText());
            PacManagement.AddPacientMedID(med.getMedid(),Pac);
        }
        catch (MedIDNotFound e) {
            super.setErrorText(e);
        }
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
