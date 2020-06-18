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
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;
import onix.mediline.appointments.management.Appointment;

public class MedPage1 extends MedPages {

    @FXML
    private Label lbPrenume;

    @FXML
    private TableView<Appointment> tvTodayApps;

    @FXML
    private TableColumn<Appointment, String> colHM, colPatient;

    public void fillTvTodayApps () { // filtrare confirmate si ziua curenta
        try {
            colHM.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
            colPatient.setCellValueFactory(new PropertyValueFactory<>("numePrenumePac"));
            ObservableList<Appointment> data = FXCollections.observableArrayList(Med.retrieveApps());
            ObservableList<Appointment> confirmedApps = FXCollections.observableArrayList();
            for (Appointment i : data)
            {
                System.out.println(i.getStareProgr() + "VS Stocat: " + Appointment.getAppointmentStates()[2]);
                if (i.getStareProgr().equals(Appointment.getAppointmentStates()[1]) || i.getStareProgr().equals(Appointment.getAppointmentStates()[2]))
                    confirmedApps.add(i);
            }
            tvTodayApps.setItems(confirmedApps);
        } catch (UserNotFound ignored) { }
    }

    public void setMedic (User x) {
        Med = (Medic) x;
    }

    public void setLabelPrenume () {
        lbPrenume.setText(Med.getPrenume());
    }

}
