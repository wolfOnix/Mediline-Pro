package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Admin;
import javafx.scene.control.Label;
import onix.mediline.accounts.roles.User;


public class AdmPage1 extends AdmPages {

    @FXML
    private Button btNewAccountMed;

    @FXML
    private Circle crDeleteRequestNotification;

    @FXML
    private Label lbNumePrenume;

    public void setup() {
        this.setLbPrenume();
        ObservableList<User> data = FXCollections.observableArrayList(UsersManagement.getAllMed());
        data.addAll(UsersManagement.getAllPac());
        int s = 0;
        for (User i : data) if (i.getRequestDelete()) s++;
        crDeleteRequestNotification.setVisible(s > 0);
    }

    public void setup(User x) {
        Adm = (Admin) x;
        this.setup();
    }

    public void setLbPrenume() {
        lbNumePrenume.setText(Adm.getNume() + " " + Adm.getPrenume());
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
