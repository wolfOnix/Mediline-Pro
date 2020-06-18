package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.management.Appointment;
import onix.mediline.documents.Document;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class PacManagement extends UsersManagement {

    private static final Path USERS_PATH = FileManagement.getPathToFile("storage", "users_pac.json");

    public static void loadUsersFromFile () throws IOException {
        if (!Files.exists(USERS_PATH))
            FileUtils.copyURLToFile(Objects.requireNonNull(PacManagement.class.getClassLoader().getResource("json/users.json")), USERS_PATH.toFile());
        ObjectMapper objectMapper = new ObjectMapper();
        users_pacient = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Pacient>>() {});
    }

    public static void addPacient(String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData, String cbSexul) throws EmailAlreadyExistsException {
        searchUserAlready (flEmail);
        users_pacient.add (new Pacient (flNume,flPrenume, flEmail, Encryption.encryptString(flEmail,flPassword), flCNP, flAdresa, flOras, flTelefon, flData, cbSexul));
        addUserIntoFile();
    }

    public static void attachDoc(Document doc, Pacient p) {
        p.addDoc(doc);
        addUserIntoFile();
    }

    public static void addPacientMedID(String flIDMedic, Pacient p) {
        p.setMedIDMedic(flIDMedic);
        addUserIntoFile();
    }

    public static void addPacientApp(Appointment n, Pacient p) {
        p.addApp(n);
        addUserIntoFile();
    }

    public static void updateApp(Appointment oldApp, Appointment updatedApp, Pacient p) {
        p.updateApp(oldApp, updatedApp);
        addUserIntoFile();
    }

    private static void addUserIntoFile () {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users_pacient);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

}
