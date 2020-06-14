package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PacPage3 extends PacPages {


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


}
