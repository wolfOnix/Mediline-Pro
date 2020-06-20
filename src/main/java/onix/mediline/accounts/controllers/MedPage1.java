package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.User;
import onix.mediline.appointments.management.Appointment;

import java.text.ParseException;
import java.util.Date;

public class MedPage1 extends MedPages {

    @FXML
    private Label lbPrenume, lbNrApps;

    @FXML
    private TableView<Appointment> tvTodayApps;

    @FXML
    private TableColumn<Appointment, String> colDate, colHM, colPatient;

    @Override
    public void setup() {
        super.setup();
        this.fillTvTodayApps();
        this.setLbPrenume();
    }

    public void setup(User x) {
        Med = (Medic) x;
        this.setup();
    }

    public void setLbPrenume() {
        lbPrenume.setText(Med.getPrenume());
    }

    public void fillTvTodayApps() {
        try {
            colDate.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
            colHM.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
            colPatient.setCellValueFactory(new PropertyValueFactory<>("numePrenumePac"));
            ObservableList<Appointment> data = FXCollections.observableArrayList(Med.retrieveApps());
            ObservableList<Appointment> confirmedApps = FXCollections.observableArrayList();
            for (Appointment i : data)
                if (i.getStareProgr().equals(Appointment.getAppointmentStates()[1]) || i.getStareProgr().equals(Appointment.getAppointmentStates()[2]))
                    confirmedApps.add(i);
            tvTodayApps.setItems(confirmedApps);
            setLbNrApps(confirmedApps);
        } catch (UserNotFound ignored) { }
    }

    public void setLbNrApps(ObservableList<Appointment> apps) {
        try {
            int s = 0;
            Date now = new Date();
            for (Appointment i : apps)
                if (i.getDataProgr().equals(Appointment.fromDateFormat(now)[2]) && (now.getTime() - i.getComplexDate().getTime() <= 10 * 60 * 1000))
                    s++;
            lbNrApps.setText("" + s);
        } catch (ParseException ignored) { }
    }

}