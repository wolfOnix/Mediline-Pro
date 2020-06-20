package onix.mediline.accounts.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.roles.Pacient;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.roles.User;
import java.io.IOException;
import java.util.Objects;

public abstract class PacPages extends Home {

    @FXML
    private Button btPacPg1;

    protected static Pacient Pac;

    public abstract void setup();

    @FXML
    void ActionPacPg1(MouseEvent event) {
        try {
            Stage HomeStage = (Stage)  btPacPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homePac.fxml"));
            Parent Home = loader.load();
            PacPage1 HomePac = loader.getController();
            HomePac.setup();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionPacPg2(MouseEvent event) throws IOException {
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
            Stage NewAppStage = (Stage) btPacPg1.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MedIDNotFound e) {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
            Parent NewApp = loader.load();
            Scene NewAppScene = new Scene(NewApp);
            Stage NewAppStage = (Stage) btPacPg1.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        }
    }

    @FXML
    public void ActionPacPg3(MouseEvent event) {
        try {
            Stage MyFileStage = (Stage) btPacPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("PacPage3.fxml")));
            Parent Next = loader.load();
            PacPage3 controller = loader.getController();
            controller.setup();
            Scene MyFileScene = new Scene(Next);
            MyFileStage.setScene(MyFileScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionPacPg4(MouseEvent event) throws IOException {
        try {
            Stage PacPage4Stage = (Stage) btPacPg1.getScene().getWindow();
            FXMLLoader loader;
            Parent PacPage4 ;
            if (Pac.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                PacPage4 = loader.load();
            } else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_1.fxml"));
                PacPage4 = loader.load();
                PacPage4_1 controller = loader.getController();
                controller.setup(MedManagement.searchMedID(Pac.getMedIDMedic()));
            }
            Scene PacPage4Scene = new Scene(PacPage4);
            PacPage4Stage.setScene(PacPage4Scene);
        } catch (MedIDNotFound e) {
            Stage PacPage4Stage = (Stage) btPacPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
            Parent PacPage4 = loader.load();
            Scene PacPage4Scene = new Scene(PacPage4);
            PacPage4Stage.setScene(PacPage4Scene);
        }
    }

}
