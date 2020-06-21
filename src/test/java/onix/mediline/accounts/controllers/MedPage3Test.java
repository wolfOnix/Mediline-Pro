package onix.mediline.accounts.controllers;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.FileManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.management.Appointment;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDate;

import static onix.mediline.accounts.management.FileManagement.APPLICATION_FOLDER;
import static onix.mediline.accounts.management.FileManagement.USER_FOLDER;
import static org.junit.Assert.*;

public class MedPage3Test extends ApplicationTest {

    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }

    private MedPage3 MP3T;
    @BeforeClass
    public static void setupCLASS() throws IOException {

        FileManagement.APPLICATION_FOLDER = ".mediline+test";
        FileManagement.USER_FOLDER = System.getProperty("user.home");
        FileManagement.APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
        FileManagement.initApplicationHomeDirIfNeeded();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();

    }
    @Before
    public void setUp() throws Exception {

        FileManagement.getPathToFile("storage", "users_med.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_pac.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_admin.json").toFile().delete();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();

        PacManagement.addPacient("TestNume","TestPrenume","testEmail.com","Parola1","1234567890098","Adresa","oras","1234567890","2020-12-15","M");
        MedManagement.addMedic("Test","TestPre","med@yahoo.com");
        MedManagement.updateMedic("Test","TestPre","med@yahoo.com","Parola1","Adresa","Oras","AR","1234567890","servE@yahoo.com",true);
        MedManagement.attachPacEmail("testEmail.com",MedManagement.getAllMed().get(0));


        MP3T = new MedPage3();
        MP3T.selected = true;
        MP3T.selectedPac = new Pacient("TestNume","TestPrenume","testEmail.com","Parola1","1234567890098","Adresa","oras","1234567890","2020-12-15","M");

        MP3T.dpData = new DatePicker(); MP3T.dpData.setValue(LocalDate.now());
        MP3T.flDocTitle = new TextField();MP3T.flDocTitle.setText("Doctor");
        MP3T.cbDocType = new ComboBox<String>(); MP3T.cbDocType.setValue("TestCab");
        MP3T.taDocContent = new TextArea() ; MP3T.taDocContent.setText("TestCont");
        MP3T.lbMessage = new Label();
        MP3T.lbErrMessage = new Label();

        MP3T.colCNP = new TableColumn<Appointment, String>();
        MP3T.colNume = new TableColumn<Appointment, String>();
        MP3T.colPrenume = new TableColumn<Appointment , String>();

        MP3T.colNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        MP3T.colPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        MP3T.colCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
    }

    @Test
    public void testsendDoc() {
        MP3T.sendDoc();
        assertEquals(message("Documentul a fost trimis pacientului"),MP3T.lbMessage.getText());
    }
}