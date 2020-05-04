package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAccountPac extends NewAccount implements Initializable {

    @FXML
    private ComboBox<String> comboMF = new ComboBox<String>();

    ObservableList<String> listaMF = FXCollections.observableArrayList("M", "F");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboMF.setItems(listaMF);
    }

}
