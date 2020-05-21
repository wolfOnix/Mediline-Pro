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


public class HomeAdm extends Home {

    @FXML
    private Button btNewAccountMed;

    @FXML
    public ImageView imgNewAccountMed, imgConfDelete;

    @FXML
    public Pane panNewAccountMed, panConfDelete;

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

    @FXML
    void handleBtLogout (ActionEvent event) throws IOException {
        super.handleBtLogout(event);
    }

}
