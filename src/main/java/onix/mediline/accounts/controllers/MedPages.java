package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;

import java.io.IOException;
import java.util.Objects;

public abstract class MedPages extends Home {

    @FXML
    private Button btMedPg1, btMedPg2, btMedPg3, btMedPg4;

    protected static Medic Med;

    @FXML
    void ActionMedPg1 (MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btMedPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homeMed.fxml"));
            Parent Home = loader.load();
            MedPage1 HomeMed = loader.getController();
            HomeMed.setLabelPrenume();
            HomeMed.fillTvTodayApps();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ActionMedPg2 (MouseEvent event) throws IOException {
        /*try {
            FXMLLoader loader;
            Parent NewApp;
            if (Med.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                NewApp = loader.load();
            }
            else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage2.fxml"));
                NewApp = loader.load();
            }
            Scene NewAppScene = new Scene(NewApp);
            Stage NewAppStage = (Stage) btPacPg2.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void ActionMedPg3 (MouseEvent event) throws IOException {
        /*try {
            Stage MyFileStage = (Stage) btPacPg3.getScene().getWindow();
            Parent MyFile = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("PacPage3.fxml")));
            Scene MyFileScene = new Scene(MyFile);
            MyFileStage.setScene(MyFileScene);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void ActionMedPg4 (MouseEvent event) throws IOException {
        /*try {
            Stage PacPage4Stage = (Stage) btPacPg4.getScene().getWindow();
            FXMLLoader loader;
            Parent PacPage4 ;
            if (Med.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                PacPage4 = loader.load();
            } else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_1.fxml"));
                PacPage4 = loader.load();
                PacPage4_1 Page = loader.getController();
                Medic med = MedManagement.searchMedID(Med.getMedIDMedic());
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
        }*/
    }

}
