package onix.mediline.accounts.controllers;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import onix.mediline.accounts.management.*;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static onix.mediline.accounts.management.FileManagement.APPLICATION_FOLDER;
import static onix.mediline.accounts.management.FileManagement.USER_FOLDER;
import static org.junit.Assert.assertEquals;

public class ActivateAccountMedTest extends ApplicationTest{

    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }
    private ActivateAccountMed AAMT ;
    @BeforeClass
    public static void setupClass() throws Exception {
        FileManagement.APPLICATION_FOLDER = ".mediline+test";
        FileManagement.USER_FOLDER = System.getProperty("user.home");
        FileManagement.APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
        FileManagement.initApplicationHomeDirIfNeeded();
        MedManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileManagement.getPathToFile("storage", "users_med.json").toFile().delete();
        //FileUtils.cleanDirectory(FileManagement.getApplicationHomePath().toFile());
        MedManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        MedManagement.addMedic("Test","TestPre","med@yahoo.com");
        AAMT = new ActivateAccountMed();
        AAMT.flEmailServ = new TextField();AAMT.flEmailServ.setText("Testemail@yahoo.com");
        AAMT.flEmail =  new TextField();AAMT.flEmail.setText("test@yahoo.com");
        AAMT.flAdresa = new TextField();AAMT.flAdresa.setText("testAdresa");
        AAMT.flPrenume = new TextField();AAMT.flPrenume.setText("testAdresa");
        AAMT.flTelefon = new TextField();AAMT.flTelefon.setText("1234567890");
        AAMT.flOras = new TextField();AAMT.flOras.setText("testOras");
        AAMT.flPassword = new PasswordField();AAMT.flPassword.setText("testParola");
        AAMT.flNume = new TextField();AAMT.flNume.setText("TestNume");
        AAMT.cbJudet = new ComboBox<String>();AAMT.cbJudet.setValue("AR");
        AAMT.lbErrMessage = new Label();
        AAMT.lbInfoOverErr = new Label();
        AAMT.lbMessage = new Label();
        AAMT.lbGreeting = new Label();

    }

    @Test
    public void testhandleBtFinishActivateAccount() throws IOException {

        AAMT.handleBtFinishActivateAccount();

        assertEquals(message("Parola trebuie să conțină cel puțin o majusculă și cel puțin o cifră, având minim șapte caractere"),AAMT.lbErrMessage.getText());
        //assertEquals(message("Completați toate câmpurile și asigurați-vă că au un număr corespunzător de caractere"),AAMT.lbErrMessage.getText());
        //assertEquals(message("Adresa de e-mail introdusă nu are un format valid"),AAMT.lbErrMessage.getText());
        //assertEquals(message("Nu există niciun cont cu adresa de e-mail introdusă"),AAMT.lbErrMessage.getText());
    }

}