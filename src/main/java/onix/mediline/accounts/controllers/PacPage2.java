package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.appointments.exceptions.AppointmentAlreadyOccupied;
import onix.mediline.appointments.exceptions.AppointmentAlreadyRequested;
import onix.mediline.appointments.exceptions.DateTooClose;
import onix.mediline.appointments.exceptions.TooManyAppointmentRequests;
import onix.mediline.appointments.management.Appointment;

public class PacPage2 extends PacPages implements Initializable {

    @FXML
    private Button btSendApp;

    @FXML
    public ComboBox<String> cbOra  = new ComboBox<>();
    @FXML
    public ComboBox<String> cbMinut = new ComboBox<>();

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

    @FXML
    public DatePicker flData;

    public void setup () { }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOra.setItems(lHR);
        cbMinut.setItems(lMN);
    }

    @FXML
    void BtActionSendNewAppointment() {
        try {
            String dataN = String.valueOf(flData.getValue());
            String oraN = String.valueOf(cbOra.getValue());
            String minutN = String.valueOf(cbMinut.getValue());
            checkFieldLength(dataN);
            checkFieldLength(oraN);
            checkFieldLength(minutN);
            String HM = oraN + ":" + minutN;
            Date fullDate = Appointment.toDateFormat(dataN, HM);
            Appointment.checkDateApproach(fullDate);
            Appointment.checkTooManyAppRequests(Pac.getListaApp());
            Appointment.checkAppointmentNotOccupied(MedManagement.searchMedID(Pac.getMedIDMedic()), fullDate);
            Pac.checkDoubleAppointment(Appointment.fromDateFormat(Appointment.toDateFormat(dataN, HM))[2], HM);
            Appointment App = new Appointment(Pac.getNume(), Pac.getPrenume(), fullDate, Pac.getEmail());
            PacManagement.addPacientApp(App, Pac);
            setMessageLabel("Cererea de programare a fost trimisă. Medicul de familie urmează să gestioneze programarea");
        } catch (CompleteAllFields | DateTooClose | AppointmentAlreadyRequested | AppointmentAlreadyOccupied | UserNotFound | TooManyAppointmentRequests | MedIDNotFound e) {
            super.setErrorText(e);
        } catch (ParseException ignored) { }
    }

}
