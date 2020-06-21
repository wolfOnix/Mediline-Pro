package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import onix.mediline.accounts.roles.Admin;

import java.io.IOException;

public abstract class AdmPages extends Home {

    protected static Admin Adm;

    @FXML
    private Button btAdmPg1;

    public abstract void setup();

    @FXML
    public void ActionAdmPg1 (ActionEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btLogout.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homeAdm.fxml"));
            Parent Home = loader.load();
            AdmPage1 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionAdmPgNewMed (MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btAdmPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("NewAccountMed.fxml"));
            Parent Home = loader.load();
            NewAccountMed controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionAdmPg2 (MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btAdmPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AdmPage2.fxml"));
            Parent Home = loader.load();
            AdmPage2 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionAdmPg3 (MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btAdmPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AdmPage3.fxml"));
            Parent Home = loader.load();
            AdmPage3 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
