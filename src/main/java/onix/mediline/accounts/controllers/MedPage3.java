package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MedPage3 extends MedPages implements Initializable {

    @FXML
    private TextArea taDocContent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taDocContent.setWrapText(true);
    }

}
