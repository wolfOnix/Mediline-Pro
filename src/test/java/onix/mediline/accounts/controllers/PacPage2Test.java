package onix.mediline.accounts.controllers;

import javafx.scene.control.DatePicker;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.FileManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.roles.Pacient;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.scene.control.Label;
import org.testfx.framework.junit.ApplicationTest;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDate;

import static onix.mediline.accounts.management.FileManagement.APPLICATION_FOLDER;
import static onix.mediline.accounts.management.FileManagement.USER_FOLDER;
import static org.junit.Assert.assertEquals;


public class PacPage2Test extends ApplicationTest {


    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }

    private PacPage2 PP2T;
    @BeforeClass
    public static void setupClass() throws Exception {
        FileManagement.APPLICATION_FOLDER = ".mediline+test";
        FileManagement.USER_FOLDER = System.getProperty("user.home");
        FileManagement.APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
        FileManagement.initApplicationHomeDirIfNeeded();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        FileManagement.getPathToFile("storage", "users_med.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_pac.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_admin.json").toFile().delete();

    }

    @Before
    public void setUp() throws Exception {

        FileManagement.getPathToFile("storage", "users_med.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_pac.json").toFile().delete();
        FileManagement.getPathToFile("storage", "users_admin.json").toFile().delete();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        PP2T = new PacPage2();
        PP2T.flData = new DatePicker();PP2T.flData.setValue(LocalDate.now().plusDays(1));
        PP2T.cbOra.setValue("13");
        PP2T.cbMinut.setValue("10");
        PP2T.lbMessage = new Label();
        PP2T.lbErrMessage = new Label();
        MedManagement.addMedic("Test","TestPre","med@yahoo.com");
        MedManagement.updateMedic("Test","TestPre","med@yahoo.com","Parola1","Adresa","Oras","AR","1234567890","servE@yahoo.com",true);
        PP2T.Pac = new Pacient("TestNume","TestPrenume","testEmail.com","Parola1","1234567890098","Adresa","Orad","1234567890","2020-12-15","M");
        PP2T.Pac.setMedIDMedic(MedManagement.getAllMed().get(0).getMedid());
        PacManagement.addPacient("TestNume","TestPrenume","testEmail.com","Parola1","1234567890098","Adresa","oras","1234567890","2020-12-15","M");
        MedManagement.attachPacEmail("testEmail.com",MedManagement.getAllMed().get(0));

    }

    @Test
    public void testbtActionSendNewAppointment() {
        PP2T.BtActionSendNewAppointment();
        System.out.println(PP2T.lbErrMessage.getText());
        assertEquals(message("Cererea de programare a fost trimisă. Medicul de familie urmează să gestioneze programarea"),PP2T.lbMessage.getText());
    }
}