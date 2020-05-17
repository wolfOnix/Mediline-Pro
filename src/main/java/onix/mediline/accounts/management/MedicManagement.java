package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CompleteAllFields;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.roles.Medic;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class MedicManagement extends UsersManagement {

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_med.json");

    public static void loadUsersFromFile() throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(AdminManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users_medic = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Medic>>() {});
    }

    public static Medic addMedic (String flNume, String flPrenume, String flEmail) throws EmailAlreadyExistsException {
        checkUserDoesNotAlreadyExist(flEmail);
        //checkUserAdminKey(flAdminKey);
        Medic m = new Medic(flNume, flPrenume, flEmail);
        users_medic.add(m);
        addUserIntoFile();
        return m;
    }

    public static void updateMedic (String flNume, String flPrenume, String flEmail, String flPassword, String flAdresa, String flOras, String cbJudet, String flTelefon, String flEmailServ, boolean activationState) throws CompleteAllFields, UserNotFound {
        Medic med = (Medic) UsersManagement.searchUser(flEmail, 2);
        med.setNume(flNume);
        med.setPrenume(flPrenume);
        med.setParola(Encryption.encryptString(flEmail, flPassword));
        med.setAdresa(flAdresa);
        med.setOras(flOras);
        med.setJudet(cbJudet);
        med.setTelefon(flTelefon);
        med.setEmailServ(flEmailServ);
        med.setContActiv(activationState);
        addUserIntoFile();
    }

    private static void addUserIntoFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users_medic);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

}
