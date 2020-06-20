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

public class AdmManagement extends UsersManagement {

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_admin.json");
    private static final Path USERS_PATH2 = FileManagement.getPathToFile("storage", "adminKey.json");

    public static void loadUsersFromFile() throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(AdmManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        if (!Files.exists(USERS_PATH2))
            FileUtils.copyURLToFile(Objects.requireNonNull(AdmManagement.class.getClassLoader().getResource("json/adminKey.json")), USERS_PATH2.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users_admin = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Admin>>() {});
        ObjectMapper objectMapper2 = new ObjectMapper();
        adminKey = objectMapper2.readValue(USERS_PATH2.toFile(), new TypeReference<List<AdmKey>>() {});
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
        String encryptedTypedKey = Encryption.encryptString(adminKey.get(0).getKey(), typedKey);
        byte[] inputBytes = encryptedTypedKey.getBytes();
        String remasteredTypedKey = new String(inputBytes, StandardCharsets.UTF_8);
        byte[] keyBytes = adminKey.get(0).getPassword().getBytes();
        String remasteredAdminKey = new String(keyBytes, StandardCharsets.UTF_8);
        if (!remasteredTypedKey.equals(remasteredAdminKey))
            throw new CheckAdminKeyException();
    }

}
