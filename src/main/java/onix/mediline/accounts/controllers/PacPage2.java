package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.appointments.exceptions.AppointmentAlreadyRequested;
import onix.mediline.appointments.exceptions.DateTooClose;
import onix.mediline.appointments.management.Appointment;

public class PacPage2 extends PacPages implements Initializable {

    @FXML
    private Button btSendApp;

    @FXML
    private ComboBox<String> cbOra, cbMinut = new ComboBox<String>();

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

    @FXML
    private DatePicker flData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOra.setItems(lHR);
        cbMinut.setItems(lMN);
    }

    @FXML
    void BtActionSendNewAppointment(ActionEvent event) {
        try {
            String dataN = String.valueOf(flData.getValue());
            String oraN = String.valueOf(cbOra.getValue());
            String minutN = String.valueOf(cbMinut.getValue());
            checkFieldLength(dataN);
            checkFieldLength(oraN);
            checkFieldLength(minutN);
            String HM = oraN + ":" + minutN;
            Appointment.checkDateApproach(Appointment.toDateFormat(dataN, HM));
            Pac.checkDoubleAppointment(Appointment.fromDateFormat(Appointment.toDateFormat(dataN, HM))[2], HM);
            Appointment App = new Appointment(dataN, HM, Pac.getEmail(), Pac.getNume(), Pac.getPrenume());
            PacManagement.addPacientApp(App, Pac);
            setMessageLabel("Cererea de programare a fost trimisă. Medicul de familie urmează să gestioneze programarea");
        } catch (CompleteAllFields | ParseException | DateTooClose | AppointmentAlreadyRequested e) {
            super.setErrorText(e);
        }
    }

}
