package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivateAccountMed implements Initializable {


    @FXML
    private ComboBox<String> comboJudet = new ComboBox<String>();

    ObservableList<String> listaMF = FXCollections.observableArrayList("AB", "AG", "AR", "B", "BC", "BH", "BN", "BR", "BT", "BV", "BZ", "CJ", "CL", "CS", "CT", "CV", "DB", "DJ", "GJ", "GL", "GR", "HD", "HR", "IF", "IL", "IS", "MH", "MM", "MS", "NT", "OT", "PH", "SB", "SJ", "SM", "SV", "TL", "TM", "TR", "VL", "VN", "VS");

    @FXML
    private Label lbNume;

    @FXML
    private Label lbPrenume;

    @FXML
    private Label lbEmail;

    @FXML
    private PasswordField flPassword;

    @FXML
    private Label lbMedid;

    @FXML
    private TextField flAdresa;

    @FXML
    private TextField flOras;

    @FXML
    private TextField flTelefon;

    @FXML
    private TextField flEmailServ;

    @FXML
    private Button btCancel;

    @FXML
    private Button btActivateAccount;

    @FXML
    void handleButtonCancel(ActionEvent event) {
        try  { Stage CancelStage = (Stage) btCancel.getScene().getWindow();
            Parent Cancel = FXMLLoader.load(getClass().getClassLoader().getResource("activateAccountMedKey.fxml"));
            Scene CancelScene = new Scene(Cancel);
            CancelStage.setScene(CancelScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboJudet.setItems(listaMF);
    }

}
