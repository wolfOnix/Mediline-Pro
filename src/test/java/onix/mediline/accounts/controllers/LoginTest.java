package onix.mediline.accounts.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.FileManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


import static org.junit.Assert.assertEquals;

public class LoginTest extends ApplicationTest {


    private Login LT;
    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }
    @BeforeClass
    public static void setupClass() throws Exception {
        FileManagement.APPLICATION_FOLDER = ".mediline-test";
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        MedManagement.loadUsersFromFile();
    }
    @Before
    public void setUP() throws IOException {
        FileUtils.cleanDirectory(FileManagement.getApplicationHomePath().toFile());
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AdmManagement.loadUsersFromFile();
        LT = new Login();
        LT.flPassword = new PasswordField();LT.flPassword.setText("TestPassword");
        LT.flEmail = new TextField();LT.flEmail.setText("testemail@yahoo.com");
        LT.lbErrMessage = new Label();

    }
    @Test
    public void testhandleBtLogin() throws IOException{
        LT.handleBtLogin();
        assertEquals(message("Nu există niciun cont cu adresa de e-mail introdusă"),LT.lbErrMessage.getText());
    }
}