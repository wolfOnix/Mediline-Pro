package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccountDone {

    @FXML
    private Button btIndex;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        Stage IndexStage = (Stage) btIndex.getScene().getWindow();
        Parent Index = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
        Scene IndexScene = new Scene(Index);
        IndexStage.setScene(IndexScene);
    }

}
