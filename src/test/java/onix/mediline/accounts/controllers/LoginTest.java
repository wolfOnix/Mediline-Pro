package onix.mediline.accounts.controllers;

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


import static org.junit.Assert.assertEquals;

public class LoginTest extends ApplicationTest {

    private Login LT;
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
    }
    @Test
    public void handleBtLogin() {
    }
}