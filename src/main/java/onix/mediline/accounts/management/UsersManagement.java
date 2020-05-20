package onix.mediline.accounts.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import onix.mediline.accounts.exceptions.CouldNotWriteUsersException;
import onix.mediline.accounts.exceptions.EmailAlreadyExistsException;
import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.roles.Admin;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UsersManagement {

    protected static List<Admin> users_admin;
    protected static List<Pacient> users_pacient;
    protected static List<Medic> users_medic;

    public static User searchUser (String flEmail, int roleConstraint) throws UserNotFound {
        if (roleConstraint != 2 && roleConstraint != 3)
            for (Admin i : users_admin)
                if (Objects.equals(flEmail, i.getEmail()))
                    return i;
        if (roleConstraint != 1 && roleConstraint != 3)
            for (Medic i : users_medic)
                if (Objects.equals(flEmail, i.getEmail()))
                    return i;
        if (roleConstraint != 1 && roleConstraint != 2)
            for (Pacient i : users_pacient)
                if (Objects.equals(flEmail, i.getEmail()))
                    return i;
        throw new UserNotFound();
    }

    public static void searchUserAlready (String flEmail) throws EmailAlreadyExistsException {
        try {
            searchUser(flEmail, 0);
            throw new EmailAlreadyExistsException(flEmail);
        } catch (UserNotFound e) { }
    }

    public static boolean checkKeyUnicity (String key, int keyConstraint) {
            for (Medic i : users_medic)
                if (keyConstraint == 0)
                {
                    if (Objects.equals(key, i.getMedid()))
                        return false;
                }
                else
                {
                    if (Objects.equals(key, i.getActivationKey()))
                        return false;
                }
            return  true;
    }

}