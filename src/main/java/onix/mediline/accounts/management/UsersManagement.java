package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.model.Admin;
import onix.mediline.accounts.model.Pacient;
import onix.mediline.accounts.model.User;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class UsersManagement {

    private static List<User> users;

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users.json");

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UsersManagement.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {});
    }
    private static void checkUserDoesNotAlreadyExist(String FlEmail,String role) throws EmailAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(role, user.getRole()) && Objects.equals(FlEmail, user.getFlEmail()))
                throw new EmailAlreadyExistsException(FlEmail);
        }
    }
    /* not for the momment
      private static void checkUserAdminKey(String flAdminKey) throws CheckAdminKeyException {
          for (User user : users) {
              Admin pers = (Admin) user ;
              if (Objects.equals("Admin", user.getRole()) && !Objects.equals(flAdminKey, pers.getFlAdminKey()))
                  throw new CheckAdminKeyException(flAdminKey);
          }
      }*/
    public static void addPacient(String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData) throws EmailAlreadyExistsException {
        checkUserDoesNotAlreadyExist(flEmail,"Pacient");
        users.add(new Pacient(flNume,flPrenume, flEmail, encodePassword(flEmail,flPassword), flCNP, flAdresa, flOras, flTelefon,flData));
        persistUsers();
    }
    public static void addAdmin(String flNume, String flPrenume, String flEmail, String flPassword, String flAdminKey) throws EmailAlreadyExistsException {
        checkUserDoesNotAlreadyExist(flEmail,"Admin");
        //checkUserAdminKey(flAdminKey);
        users.add(new Admin(flNume, flPrenume, flEmail,  encodePassword(flEmail, flPassword),  flAdminKey));
        persistUsers();
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
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
