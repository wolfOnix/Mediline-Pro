package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.NoRowSelected;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.management.Appointment;
import onix.mediline.documents.Document;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class MedPage3 extends MedPages implements Initializable {

    private Pacient selectedPac;
    private boolean selected = false;

    @FXML
    private Button btSendDoc;

    @FXML
    private DatePicker dpData;

    @FXML
    private TextArea taDocContent;

    @FXML
    private TextField flDocTitle;

    @FXML
    private TableView<Pacient> tvMyPac;

    @FXML
    private TableColumn<Appointment, String> colNume, colPrenume, colCNP;

    @FXML
    private ComboBox<String> cbDocType = new ComboBox<String>();

    public void setup () {
        super.setup();
        this.fillTvMyPac();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taDocContent.setWrapText(true);
        cbDocType.setItems(Document.getTipuri());
    }

    public void fillTvMyPac () {
        try {
            colNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
            colPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            colCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
            ObservableList<Pacient> pac = FXCollections.observableArrayList();
            for (String i : Med.getListaPacEmail())
                pac.add((Pacient) UsersManagement.searchUser(i, 3));
            tvMyPac.setItems(pac);
        } catch (UserNotFound ignored) { }
    }

    @FXML
    void tvClicked (MouseEvent event) {
        selectedPac = tvMyPac.getSelectionModel().getSelectedItem();
        selected = true;
    }

    public void sendDoc () {
        try {
            if (!selected)
                throw new NoRowSelected();
            String date = String.valueOf(dpData.getValue());
            checkFieldLength(date);
            if (flDocTitle.getText().length() < 2 || cbDocType.getValue().length() < 2 || taDocContent.getText().length() < 2)
                throw new CompleteAllFields();
            Document doc = new Document(flDocTitle.getText(), cbDocType.getValue(), taDocContent.getText(), Appointment.fromDateFormat(Appointment.toDateFormat(date, "00:00"))[2], selectedPac.getNume() + " " + selectedPac.getPrenume());
            PacManagement.attachDoc(doc, selectedPac);
            setMessageLabel("Documentul a fost trimis pacientului");
        }  catch (CompleteAllFields | NoRowSelected e) {
            super.setErrorText(e);
        } catch (ParseException ignore) { }
    }

}
