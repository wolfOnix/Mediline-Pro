package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    public void fillTvTodayApps () {
        /*TableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
        TableColumnOra.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
        TableColumnStare.setCellValueFactory(new PropertyValueFactory<>("stareProgr"));
        ObservableList<Appointment> data = FXCollections.observableArrayList(Pac.getListaApp());
        myAppointment.setItems(data);*/
    }

    public void setMedic (User x) {
        Med = (Medic) x;
    }

    public void setLabelPrenume () {
        lbPrenume.setText(Med.getPrenume());
    }

}
