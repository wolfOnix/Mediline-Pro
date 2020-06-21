package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;
import onix.mediline.appointments.management.Appointment;

import java.util.Date;

public class PacPage1 extends PacPages {

    @FXML
    private Label lbPrenume, lbNrConfApps, lbNrModifApps;

    @FXML
    private TableView<Appointment> myAppointment;

    @FXML
    private TableColumn<Appointment, String> TableColumnData, TableColumnOra, TableColumnStare;

    public void setup() {
        this.fillTvMyApps();
        this.setLbPrenume();
    }

    public void setup(User x) {
        Pac = (Pacient) x;
        this.setup();
    }

    public void fillTvMyApps() {
        TableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
        TableColumnOra.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
        TableColumnStare.setCellValueFactory(new PropertyValueFactory<>("stareProgr"));
        ObservableList<Appointment> data = FXCollections.observableArrayList(Pac.getListaApp());
        ObservableList<Appointment> actualApps = FXCollections.observableArrayList();
        Date now = new Date();
        for (Appointment i : data)
            if (now.getTime() - i.getComplexDate().getTime() <= 3 * 60 * 60 * 1000)
                actualApps.add(i);
        myAppointment.setItems(actualApps);
        setLbNrDocs(actualApps);
    }

    public void setLbPrenume() {
        lbPrenume.setText(Pac.getPrenume());
    }

    public void setLbNrDocs(ObservableList<Appointment> apps) {
        int sConf = 0, sModif = 0;
        for (Appointment i : apps) {
            if (i.getStareProgr().equals(Appointment.getAppointmentStates()[1]))
                sConf++;
            else
                if (i.getStareProgr().equals(Appointment.getAppointmentStates()[2]))
                    sModif++;
        }
        lbNrConfApps.setText("" + (sConf + sModif));
        lbNrModifApps.setText("" + sModif);
    }

}
