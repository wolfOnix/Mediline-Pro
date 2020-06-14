package onix.mediline.accounts.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import onix.mediline.accounts.exceptions.MedIDNotFound;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public abstract class PacPages extends Home {

    // Codul pentru conducerea la cele patru pagini

    @FXML
    public ImageView imgNewAccountMed, imgConfDelete;

    @FXML
    public Pane panNewAccountMed, panConfDelete;

    @FXML
    private Label lbGreeting;

    @FXML
    private Button btLogout;

    @FXML
    private Button btAccountSettings;

    @FXML
    private Button btPacPg1;

    @FXML
    private Pane pnMyAppointments;

    @FXML
    private Label btMyAppointmentsTxt;

    @FXML
    private Button btPacPg2;

    @FXML
    private Pane pnNewAppointment;

    @FXML
    private Label btNewAppointmentTxt;

    @FXML
    private Button btPacPg3;

    @FXML
    private Pane pnMyFiles;

    @FXML
    private Label btMyFilesTxt;

    @FXML
    private Button btPacPg4;

    @FXML
    private Pane pnMyMed;

    @FXML
    private Label btMyMedTxt;

    @FXML
    private Label lbErrMessage;

    protected static Pacient Pac;

    protected void setErrorText (Exception e) {
        try {
            byte ptext[] = e.getMessage().getBytes();
            String value = new String(ptext, "UTF-8");
            lbErrMessage.setText(value);
            //lbInfoOverErr.setText("");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    void handleBtLogout(ActionEvent event) throws IOException {
        super.handleBtLogout(event);
    }

    @FXML
    void ActionMyAppointments(MouseEvent event) throws IOException {
        try {
            Stage HomeStage = (Stage)  btPacPg1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homePac.fxml"));
            Parent Home = loader.load();
            PacPage1 HoPa = loader.getController();
            HoPa.setLabelPrenume();
            HoPa.setAppointment();
            Scene HomeScene = new Scene(Home);
            HomeStage.setScene(HomeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ActionNewAppointments(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader ;
            Parent NewApp;
            if (Pac.getMedIDMedic() == null) {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage4_2.fxml"));
                NewApp = loader.load();
            }
            else {
                loader = new FXMLLoader(getClass().getClassLoader().getResource("PacPage2.fxml"));
                NewApp = loader.load();
            }
            Scene NewAppScene = new Scene(NewApp);
            Stage NewAppStage = (Stage) pnMyAppointments.getScene().getWindow();
            NewAppStage.setScene(NewAppScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ActionMyFilesTxt(MouseEvent event) throws IOException {
        try {

            Stage MyFileStage = (Stage) pnMyFiles.getScene().getWindow();
            Parent MyFile = FXMLLoader.load(getClass().getClassLoader().getResource("PacPage3.fxml"));
            Scene MyFileScene = new Scene(MyFile);
            MyFileStage.setScene(MyFileScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ActionMyMed(MouseEvent event) throws IOException {
        try {

            Stage PacPage4Stage = (Stage) pnMyMed.getScene().getWindow();
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
                Page.setAdresa(med.getAdresa());
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
