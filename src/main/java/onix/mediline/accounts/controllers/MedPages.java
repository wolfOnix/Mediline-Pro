package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.appointments.management.Appointment;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public abstract class MedPages extends Home {

    @FXML
    private Button btMedPg1;

    @FXML
    private Label lbCurrentDate;

    protected static Medic Med;

    public void setup() {
        this.setLbDate();
    }

    @FXML
    public void ActionMedPg1(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homeMed.fxml"));
            Parent Home = loader.load();
            MedPage1 HomeMed = loader.getController();
            HomeMed.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionMedPg2(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MedPage2.fxml"));
            Parent Home = loader.load();
            MedPage2 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionMedPg3(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MedPage3.fxml"));
            Parent Home = loader.load();
            MedPage3 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionMedPg4(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MedPage4.fxml"));
            Parent Home = loader.load();
            MedPage4 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionMedPg5(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MedPage5.fxml"));
            Parent Home = loader.load();
            MedPage5 controller = loader.getController();
            controller.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLbDate () {
        try {
            lbCurrentDate.setText(Appointment.fromDateFormat(new Date())[2]);
        } catch (ParseException ignored) { }
    }

}
