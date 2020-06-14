package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.appointments.management.Appointment;

import java.net.URL;
import java.util.ResourceBundle;

public class MedPage2 extends MedPages implements Initializable {

    @FXML
    private ComboBox<String> cbOra, cbMinut = new ComboBox<String>();

    @FXML
    private TableView<Appointment> tvUnconfirmedApps;

    @FXML
    private TableColumn<Appointment, String> colDate, colHM, colPatient;

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

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
            tvUnconfirmedApps.setItems(data);
        } catch (UserNotFound ignored) { }
    }

}
