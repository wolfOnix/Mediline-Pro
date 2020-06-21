package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.management.Appointment;
import java.text.ParseException;

public class MedPage4 extends MedPages {

    @FXML
    private Label lbMedID, lbTelefon, lbOras, lbData, lbEmail, lbAdresa, lbSexul, lbCNP;

    public void fillMedID () {
        lbMedID.setText(Med.getMedid());
    }

    @FXML
    private TableView<Pacient> tvMyPac;

    @FXML
    private TableColumn<Appointment, String> colNume, colPrenume;

    public void setup () {
        super.setup();
        this.fillTvMyPac();
        this.fillMedID();
    }

    public void fillTvMyPac () {
        try {
            colNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
            colPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            ObservableList<Pacient> pac = FXCollections.observableArrayList();
            for (String i : Med.getListaPacEmail())
                pac.add((Pacient) UsersManagement.searchUser(i, 3));
            tvMyPac.setItems(pac);
        } catch (UserNotFound ignored) { }
    }

    @FXML
    void tvClicked (MouseEvent event) {
        Pacient p = tvMyPac.getSelectionModel().getSelectedItem();
        lbEmail.setText(p.getEmail());
        lbTelefon.setText(p.getTelefon());
        lbOras.setText(p.getOras());
        try {
            lbData.setText(Appointment.fromDateFormat(Appointment.toDateFormat(p.getDataNasterii(), "00:00"))[2]);
        } catch (ParseException ignore) { }
        lbAdresa.setText(p.getAdresa());
        lbSexul.setText(p.getSexul());
        lbCNP.setText(p.getCNP());
    }

}
