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
    private TableColumn<Appointment, String> TableColumnData;

    @FXML
    private TableColumn<Appointment, String> TableColumnOra;

    @FXML
    private TableColumn<Appointment, String> TableColumnStare;

    public void setAppointment() {
        TableColumnData.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumnOra.setCellValueFactory(new PropertyValueFactory<>("ora"));
        TableColumnStare.setCellValueFactory(new PropertyValueFactory<>("state"));
        ObservableList<Appointment> data = FXCollections.observableArrayList(Pac.getListaApp());
        myAppointment.setItems(data);
    }

    public void setPacient(User x) {
        Pac = (Pacient) x;
    }

    public void setLabelPrenume() {
        lbPrenume.setText(Pac.getPrenume());
    }

    @FXML
    void handleBtLogout(ActionEvent event) throws IOException {
        super.handleBtLogout(event);
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
