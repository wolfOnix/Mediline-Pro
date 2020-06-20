package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CheckAdminKeyException;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.roles.Admin;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class AdmManagement extends UsersManagement{

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_admin.json");
    private static final String adminKey = Encryption.encryptString("adminKey", ""); //"4???B7? ??L'L??7\u0016?e??P?:? H??f??\u00145p??\u0005?4??Z\u000F???;?Q#??Z??X???\\";

    public static void loadUsersFromFile() throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(AdmManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users_admin = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Admin>>() {});
    }

    public static void addAdmin (String flNume, String flPrenume, String flEmail, String flPassword, String flAdminKey) throws EmailAlreadyExistsException {
        searchUserAlready (flEmail);
        users_admin.add (new Admin(flNume, flPrenume, flEmail, Encryption.encryptString(flEmail, flPassword)));
        addUserIntoFile();
    }

    public static void addUserIntoFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users_admin);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static void checkAdminKey(String typedKey) throws CheckAdminKeyException {
        System.out.println("TYP: " + typedKey + " - TYP");
        System.out.println("ADM: " + adminKey + " - ADM");
        typedKey = typedKey.replace("\n","");
        byte[] ptext = typedKey.getBytes(), adminKeyText = adminKey.getBytes();
        String remasteredTypedKey = new String(ptext, StandardCharsets.UTF_8);
        String remasteredAdminKey = new String(adminKeyText, StandardCharsets.UTF_8);
        System.out.println("RTP: " + remasteredTypedKey + " - REMTYP");
        System.out.println("RAD: " + remasteredAdminKey + " - REMADM");
        if (!remasteredTypedKey.equals(remasteredAdminKey))
            throw new CheckAdminKeyException();
    }

}
