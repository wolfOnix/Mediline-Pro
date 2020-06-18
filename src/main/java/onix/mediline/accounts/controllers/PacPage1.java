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

    public void setup () {
        this.fillTvMyApps();
        this.setLbPrenume();
        this.setLbNrDocs();
    }

    public void fillTvMyApps() {
        TableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
        TableColumnOra.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
        TableColumnStare.setCellValueFactory(new PropertyValueFactory<>("stareProgr"));
        ObservableList<Appointment> data = FXCollections.observableArrayList(Pac.getListaApp());
        ObservableList<Appointment> actualApps = FXCollections.observableArrayList();
        Date now = new Date();
        for (Appointment i : data)
            if (i.getComplexDate().getTime() - now.getTime() >= 3 * 60 * 60 * 1000)
                actualApps.add(i);
        myAppointment.setItems(actualApps);
    }

    public void setPacient(User x) {
        Pac = (Pacient) x;
    }

    public void setLbPrenume() {
        lbPrenume.setText(Pac.getPrenume());
    }

    public void setLbNrDocs() {
        int sConf = 0, sModif = 0;
        Date now = new Date();
        for (Appointment i : Pac.getListaApp()) {
            if (i.getStareProgr().equals(Appointment.getAppointmentStates()[1]) && (i.getComplexDate().getTime() - now.getTime() >= 3 * 60 * 60 * 1000))
                sConf++;
            else
                if (i.getStareProgr().equals(Appointment.getAppointmentStates()[2]) && (i.getComplexDate().getTime() - now.getTime() >= 3 * 60 * 60 * 1000))
                    sModif++;
        }
        lbNrConfApps.setText("" + (sConf + sModif));
        lbNrModifApps.setText("" + sModif);
    }

}
