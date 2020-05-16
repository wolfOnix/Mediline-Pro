package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.roles.Admin;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class AdminManagement extends UsersManagement{

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_admin.json");

    public static void loadUsersFromFile() throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(AdminManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users_admin = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Admin>>() {});
    }

    public static void addAdmin (String flNume, String flPrenume, String flEmail, String flPassword, String flAdminKey) throws EmailAlreadyExistsException {
        checkUserDoesNotAlreadyExist(flEmail);
        //checkUserAdminKey(flAdminKey);
        users_admin.add(new Admin(flNume, flPrenume, flEmail, Encryption.encryptString(flEmail, flPassword)));
        addUserIntoFile();
    }

    private static void addUserIntoFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users_admin);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

}
