package onix.mediline.accounts.controllers;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.FileManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.appointments.management.Appointment;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class MedPage2Test extends ApplicationTest {

    private MedPage2 MP2T;
    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }

    @BeforeClass
    public static void setupCLASS() throws IOException {

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
        MP2T = new MedPage2();
        MedPage2.Med = MedManagement.getAllMed().get(0);
        MP2T.selected = true;
        MP2T.selectedApp = new Appointment("Testnume","Prenume", Date.valueOf(LocalDate.now()),"testEmail.com");
        MP2T.selectedApp.setStareProgr("Confirmat");
        MP2T.lbMessage = new Label();
        MP2T.lbErrMessage = new Label();
        MP2T.tvUnconfirmedApps = new TableView<Appointment>();
        MP2T.colDate = new TableColumn<Appointment,String>();
        MP2T.colHM = new TableColumn<Appointment,String>();
        MP2T.colPatient = new TableColumn<Appointment,String>();
        MP2T.colDate.setCellValueFactory(new PropertyValueFactory<>("dataProgr"));
        MP2T.colHM.setCellValueFactory(new PropertyValueFactory<>("oraProgr"));
        MP2T.colPatient.setCellValueFactory(new PropertyValueFactory<>("numePrenumePac"));
        PacManagement.addPacientApp(MP2T.selectedApp , PacManagement.getAllPac().get(0));
    }

    @Test
    public void testconfirmApp() {
        MP2T.confirmApp();
        assertEquals(message("Programarea a fost confirmată"),MP2T.lbMessage.getText());
    }
}