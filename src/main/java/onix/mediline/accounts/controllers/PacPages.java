package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import javafx.scene.input.MouseEvent;
import onix.mediline.appointments.management.Appointment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class PacPages extends Home {

    @FXML
    private Button btPacPg1, btPacPg2, btPacPg3, btPacPg4;

    protected static Pacient Pac;

    @FXML
    void ActionMyAppointments(MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btPacPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homePac.fxml"));
            Parent Home = loader.load();
            PacPage1 HomePac = loader.getController();
            HomePac.setLabelPrenume();
            HomePac.fillTvMyApps();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ActionNewAppointments(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader;
            Parent NewApp;
            MedManagement.searchMedID(Pac.getMedIDMedic());
            if (Pac.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                NewApp = loader.load();
            } else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage2.fxml"));
                NewApp = loader.load();
            }
            Scene NewAppScene = new Scene(NewApp);
            Stage NewAppStage = (Stage) btPacPg2.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MedIDNotFound e) {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
            Parent NewApp = loader.load();
            Scene NewAppScene = new Scene(NewApp);
            Stage NewAppStage = (Stage) btPacPg2.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        }
    }

    @FXML
    void ActionMyFilesTxt (MouseEvent event) throws IOException {
        try {
            Stage MyFileStage = (Stage) btPacPg3.getScene().getWindow();
            Parent MyFile = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("PacPage3.fxml")));
            Scene MyFileScene = new Scene(MyFile);
            MyFileStage.setScene(MyFileScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ActionMyMed (MouseEvent event) throws IOException {
        try {
            Stage PacPage4Stage = (Stage) btPacPg4.getScene().getWindow();
            FXMLLoader loader;
            Parent PacPage4 ;
            if (Pac.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                PacPage4 = loader.load();
            } else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_1.fxml"));
                PacPage4 = loader.load();
                PacPage4_1 Page = loader.getController();
                Medic med = MedManagement.searchMedID(Pac.getMedIDMedic());
                System.out.println(med.getPrenume());
                Page.setAdresa(med.getAdresa() + ", " + med.getOras() + " (" + med.getJudet() + ")");
                Page.setEmailServ(med.getEmailServ());
                Page.setMedID(med.getMedid());
                Page.setNume(med.getNume());
                Page.setPrenume(med.getPrenume());
                Page.setTelefon(med.getTelefon());
            }
            Scene PacPage4Scene = new Scene(PacPage4);
            PacPage4Stage.setScene(PacPage4Scene);
        } catch (MedIDNotFound e) {
            Stage PacPage4Stage = (Stage) btPacPg4.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
            Parent PacPage4 = loader.load();
            Scene PacPage4Scene = new Scene(PacPage4);
            PacPage4Stage.setScene(PacPage4Scene);
        }
    }

}
