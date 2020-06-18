package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.NoRowSelected;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.exceptions.AppointmentAlreadyOccupied;
import onix.mediline.appointments.exceptions.DatePassed;
import onix.mediline.appointments.management.Appointment;
import onix.mediline.documents.Document;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

public class MedPage2 extends MedPages implements Initializable {

    private Appointment selectedApp;
    private boolean selected = false;

    @FXML
    private ComboBox<String> cbOra, cbMinut = new ComboBox<String>();

    @FXML
    private DatePicker dpData;

    @FXML
    private TableView<Appointment> tvUnconfirmedApps;

    @FXML
    private TableColumn<Appointment, String> colDate, colHM, colPatient;

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

    public void setup () {
        super.setup();
        this.fillTvUnconfirmedApps();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOra.setItems(lHR);
        cbMinut.setItems(lMN);
    }

    public void fillTvUnconfirmedApps () {
        try {
            colDate.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
            colHM.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
            colPatient.setCellValueFactory(new PropertyValueFactory<>("numePrenumePac"));
            ObservableList<Appointment> data = FXCollections.observableArrayList(Med.retrieveApps());
            ObservableList<Appointment> unconfirmedApps = FXCollections.observableArrayList();
            Date now = new Date();
            for (Appointment i : data)
                if (i.getStareProgr().equals(Appointment.getAppointmentStates()[0]) && i.getComplexDate().getTime() > now.getTime())
                    unconfirmedApps.add(i);
            tvUnconfirmedApps.setItems(unconfirmedApps);
        } catch (UserNotFound ignored) { }
    }

    @FXML
    void tvClicked (MouseEvent event) {
        selectedApp = tvUnconfirmedApps.getSelectionModel().getSelectedItem();
        selected = true;
    }

    public void confirmApp(MouseEvent event) {
        try {
            if (!selected)
                throw new NoRowSelected();
            Appointment oldApp = selectedApp;
            selectedApp.setStareProgr(Appointment.getAppointmentStates()[1]);
            Pacient p = (Pacient) UsersManagement.searchUser(selectedApp.getEmailPac(), 3);
            PacManagement.updateApp(oldApp, selectedApp, p);
            setMessageLabel("Programarea a fost confirmată");
            this.fillTvUnconfirmedApps();
        }  catch (NoRowSelected | UserNotFound e) {
            super.setErrorText(e);
        }
    }

    public void modifyApp(MouseEvent event) {
        try {
            if (!selected)
                throw new NoRowSelected();
            String dataN = String.valueOf(dpData.getValue());
            String oraN = String.valueOf(cbOra.getValue());
            String minutN = String.valueOf(cbMinut.getValue());
            checkFieldLength(dataN);
            checkFieldLength(oraN);
            checkFieldLength(minutN);
            String HM = oraN + ":" + minutN;
            Date fullDate = Appointment.toDateFormat(dataN, HM);
            Appointment.checkDateNotPast(fullDate);
            Appointment.checkAppointmentNotOccupied(Med, fullDate);
            Appointment oldApp = selectedApp;
            selectedApp.setComplexDate(fullDate);
            selectedApp.setStareProgr(Appointment.getAppointmentStates()[2]);
            Pacient p = (Pacient) UsersManagement.searchUser(selectedApp.getEmailPac(), 3);
            PacManagement.updateApp(oldApp, selectedApp, p);
            setMessageLabel("Programarea a fost modificată și confirmată");
            this.fillTvUnconfirmedApps();
        }  catch (NoRowSelected | UserNotFound | CompleteAllFields | ParseException | DatePassed | AppointmentAlreadyOccupied e) {
            super.setErrorText(e);
        }
    }

    public void cancelApp(MouseEvent event) {
        try {
            if (!selected)
                throw new NoRowSelected();
            Appointment oldApp = selectedApp;
            selectedApp.setStareProgr(Appointment.getAppointmentStates()[3]);
            Pacient p = (Pacient) UsersManagement.searchUser(selectedApp.getEmailPac(), 3);
            PacManagement.updateApp(oldApp, selectedApp, p);
            setMessageLabel("Programarea a fost anulată");
            this.fillTvUnconfirmedApps();
        }  catch (NoRowSelected | UserNotFound e) {
            super.setErrorText(e);
        }
    }

}
