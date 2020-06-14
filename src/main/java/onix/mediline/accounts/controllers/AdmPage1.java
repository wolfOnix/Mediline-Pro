package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.roles.Admin;
import javafx.scene.control.Label;
import onix.mediline.accounts.roles.User;


public class AdmPage1 extends Home {

    @FXML
    private Button btNewAccountMed;

    @FXML
    public ImageView imgNewAccountMed, imgConfDelete;

    @FXML
    public Pane panNewAccountMed, panConfDelete;

    @FXML
    private Label lbGreetingName;

    void setAdmin (User x) {
        Adm = (Admin) x;
    }

    void setLbGreetingName() {
        lbGreetingName.setText(Adm.getNume());
    }

    @FXML
    void handleBtNewMedic(MouseEvent event)throws IOException {
        try  {
            Stage NewMedic = (Stage) btNewAccountMed.getScene().getWindow();
            Parent Medic = FXMLLoader.load(getClass().getClassLoader().getResource("newAccountMed.fxml"));
            Scene NewMedicScene = new Scene(Medic);
            NewMedic.setScene(NewMedicScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
