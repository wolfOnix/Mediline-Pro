package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.NoRowSelected;
import onix.mediline.appointments.management.Appointment;
import onix.mediline.documents.Document;

public class PacPage3 extends PacPages {

    private Document selectedDoc;
    private boolean selected = false;

    @FXML
    private Button btSaveDoc;

    @FXML
    private Label lbNrDocs;

    @FXML
    private TableView<Document> tvMyDocs;

    @FXML
    private TableColumn<Appointment, String> colTitlu, colTip, colContinut, colData;

    public void fillTvMyDocs () {
        colTitlu.setCellValueFactory(new PropertyValueFactory<>("titlu"));
        colTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
        colContinut.setCellValueFactory(new PropertyValueFactory<>("continut"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataEmitere"));
        ObservableList<Document> doc = FXCollections.observableArrayList(Pac.getListaDoc());
        tvMyDocs.setItems(doc);
    }

    public void setLbNrDocs () {
        lbNrDocs.setText("" + Pac.getListaDoc().size());
    }

    @FXML
    void tvClicked (MouseEvent event) {
        selectedDoc = tvMyDocs.getSelectionModel().getSelectedItem();
        selected = true;
    }

    public void saveDoc () {
        try {
            if (!selected)
                throw new NoRowSelected();
            /* SALVARE ÎN FIȘIER .txt */
            setMessageLabel("Documentul a fost salvat în folderul Descărcări"); // Sau deschidem prompt și își alege pacientul unde vrea să salveze
        }  catch (NoRowSelected e) {
            super.setErrorText(e);
        }
    }

}
