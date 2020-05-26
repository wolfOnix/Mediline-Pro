package onix.mediline.accounts.management;

import onix.mediline.accounts.exceptions.EmailNotValid;
import onix.mediline.accounts.exceptions.NotStrongEnoughPassword;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public static void checkPasswordStrength (String flPassword) throws NotStrongEnoughPassword {
        boolean cp1 = false, cp2 = false;
        if (flPassword.length() < 8)
            throw new NotStrongEnoughPassword();
        char[] splitPassword = flPassword.toCharArray();
        for (char c : splitPassword)
        {
            if (Character.isDigit(c))
                cp1 = true;
            if (Character.isUpperCase(c))
                cp2 = true;
        }
        if (!cp1 || !cp2)
            throw new NotStrongEnoughPassword();
    }

    public static void checkEmailStructure (String flEmail) throws EmailNotValid {
        String emailRegularExpr = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (flEmail.length() < 5)
            throw new EmailNotValid();
        Pattern patt = Pattern.compile(emailRegularExpr);
        if (!patt.matcher(flEmail).matches() || flEmail == null)
            throw new EmailNotValid();
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
