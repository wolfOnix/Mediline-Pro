package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;
import onix.mediline.appointments.management.Appointment;

import java.io.IOException;

public class PacPage1 extends PacPages {

    @FXML
    public ImageView imgNewAccountMed, imgConfDelete;

    @FXML
    public Pane panNewAccountMed, panConfDelete;

    @FXML
    private Label lbPrenume;

    @FXML
    private TableView<Appointment> myAppointment;

    @FXML
    private TableColumn<Appointment, String> TableColumnData, TableColumnOra, TableColumnStare;

    public void fillTvMyApps() {
        TableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
        TableColumnOra.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
        TableColumnStare.setCellValueFactory(new PropertyValueFactory<>("stareProgr"));
        ObservableList<Appointment> data = FXCollections.observableArrayList(Pac.getListaApp());
        myAppointment.setItems(data);
    }

    public void setPacient (User x) {
        Pac = (Pacient) x;
    }

    public void setLabelPrenume () {
        lbPrenume.setText(Pac.getPrenume());
    }

}
