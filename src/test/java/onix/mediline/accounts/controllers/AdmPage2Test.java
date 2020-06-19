package onix.mediline.accounts.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import onix.mediline.accounts.management.AdmManagement;
import onix.mediline.accounts.management.FileManagement;
import onix.mediline.accounts.management.MedManagement;
import onix.mediline.accounts.management.PacManagement;
import onix.mediline.accounts.roles.Admin;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.User;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AdmPage2Test extends ApplicationTest {

    private AdmPage2 AP2T;

    public String message(String x) {
        byte[] ptext = x.getBytes();
        String value = new String(ptext, StandardCharsets.UTF_8);
        return value;
    }

    @BeforeClass
    public static void setupClass() throws Exception {
        FileManagement.APPLICATION_FOLDER = ".mediline-test";
        FileManagement.initApplicationHomeDirIfNeeded();
        AdmManagement.loadUsersFromFile();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileManagement.getApplicationHomePath().toFile());
        AdmManagement.loadUsersFromFile();
        MedManagement.loadUsersFromFile();
        PacManagement.loadUsersFromFile();
        AP2T = new AdmPage2();
        AP2T.selectedUser = new Admin("TestNume","TestPrenume","test@yahoo.com","Testparola1");
        AP2T.selected = true;
        AdmManagement.addAdmin("TestNume","TestPrenume","test@yahoo.com","Testparola1","TestAdminKey");
        AP2T.lbMessage = new Label();
        AP2T.lbErrMessage = new Label();
        AP2T.lbAccType = new Label();
        AP2T.lbInfo = new Label();
        AP2T.colEmail = new TableColumn< User, String>() ;
        AP2T.colNumeFam = new TableColumn<User,String>();


    }
    @Test
    public void testconfirmDelAccount() {
        AP2T.confirmDelAccount();
        assertEquals(message("Utilizatorul a fost șters"),AP2T.lbMessage.getText());
    }
}