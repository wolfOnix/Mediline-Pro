package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.roles.Admin;
import javafx.scene.control.Label;
import onix.mediline.accounts.roles.User;


public class AdmPage1 extends AdmPages {

    @FXML
    private Button btNewAccountMed;

    @FXML
    private Circle crDeleteRequestNotification;

    @FXML
    private Label lbPrenume;

    public void setup() {
        this.setLbPrenume();
    }

    public void setup(User x) {
        Adm = (Admin) x;
        this.setup();
    }

    public void setLbPrenume() {
        lbPrenume.setText(Adm.getPrenume());
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
