package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.appointments.management.Appointment;

public class PacPage2 extends PacPages implements Initializable {

    @FXML
    private ComboBox<String> cbOra, cbMinut = new ComboBox<String>();

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

    @FXML
    private DatePicker flData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOra.setItems(lHR);
        cbMinut.setItems(lMN);
    }

    @FXML
    void handleBtLogout (ActionEvent event) throws IOException {
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
    @FXML
    void BtActionSendNewAppointment(ActionEvent event) {
        try {
            String dataN = String.valueOf(flData.getValue());
            String oraN = String.valueOf(cbOra.getValue());
            String minutN = String.valueOf(cbMinut.getValue());
            if (dataN == null || dataN == "" || dataN == "null")
                throw new CompleteAllFields();
            if (oraN == null || oraN == "" || oraN == "null")
                throw new CompleteAllFields();
            if (minutN == null || minutN == "" || minutN == "null")
                throw new CompleteAllFields();
            Appointment App = new Appointment("Neconfirmat",dataN,oraN);
            PacManagement.AddPacientApp(App,Pac);

        } catch (CompleteAllFields e) {
            super.setErrorText(e);
        }
    }

}
