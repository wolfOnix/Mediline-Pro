package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.roles.Pacient;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class PacManagement {

    private static List<Pacient> users;
    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_pac.json");

    public static void loadUsersFromFile() throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(PacManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Pacient>>() {});
    }

    private static void checkUserDoesNotAlreadyExist(String flEmail) throws EmailAlreadyExistsException {
        for (Pacient i : users) {
            if (Objects.equals(flEmail, i.getFlEmail()))
                throw new EmailAlreadyExistsException(flEmail);
        }
    }

    public static void addPacient(String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData) throws EmailAlreadyExistsException {
        checkUserDoesNotAlreadyExist(flEmail);
        users.add(new Pacient(flNume,flPrenume, flEmail, encryptString(flEmail,flPassword), flCNP, flAdresa, flOras, flTelefon,flData));
        addUserIntoFile();
    }

    private static void addUserIntoFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static String encryptString (String key, String password) {
        MessageDigest md = getMessageDigest();
        md.update(key.getBytes(StandardCharsets.UTF_8));
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return new String(hashedPassword, StandardCharsets.UTF_8).replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

}
