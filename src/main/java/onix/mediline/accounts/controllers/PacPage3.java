package onix.mediline.accounts.controllers;

import javafx.animation.Animation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import onix.mediline.accounts.exceptions.NoRowSelected;
import onix.mediline.appointments.management.Appointment;
import onix.mediline.documents.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

    public void setup () {
        this.setLbNrDocs();
        this.fillTvMyDocs();
        /*colContinut.setCellFactory(tc -> {
            TableCell<Appointment, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(colContinut.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });*/
        colContinut.setCellFactory(param -> {
            return new TableCell<Appointment, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        Text text = new Text(item);
                        text.setStyle("-fx-text-alignment:justify;");
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty().subtract(20));
                        setGraphic(text);
                    }
                }
            };
        });
    }

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
            Stage stage = (Stage) btSaveDoc.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Salvare document");
            fileChooser.setInitialFileName("mysave");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
            File file = fileChooser.showSaveDialog(stage);
                if(file != null)
                    try {
                        PrintWriter writer;
                        writer = new PrintWriter(file);
                        writer.println(selectedDoc);
                        writer.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
            /* SALVARE ÎN FIȘIER .txt */
            setMessageLabel("Documentul a fost salvat "); // Sau deschidem prompt și își alege pacientul unde vrea să salveze
        }  catch (NoRowSelected e) {
            super.setErrorText(e);
        }
    }

}
