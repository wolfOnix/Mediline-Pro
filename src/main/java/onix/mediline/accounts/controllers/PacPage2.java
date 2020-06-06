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

public class PacPage2 extends Home implements Initializable {

    @FXML
    private ComboBox<String> cbOra, cbMinut = new ComboBox<String>();

    ObservableList<String> lHR = FXCollections.observableArrayList("08", "09" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" );
    ObservableList<String> lMN = FXCollections.observableArrayList("00", "10" , "20" , "30" , "40" , "50" );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbOra.setItems(lHR);
        cbMinut.setItems(lMN);
    }

    @FXML
    void handleBtLogout (ActionEvent event) throws IOException {
        super.handleBtLogout(event);
    }

}
