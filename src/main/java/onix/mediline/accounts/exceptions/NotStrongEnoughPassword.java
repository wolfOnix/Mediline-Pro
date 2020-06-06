package onix.mediline.accounts.exceptions;

public class NotStrongEnoughPassword extends Exception {

    public NotStrongEnoughPassword () {
        super ("Parola trebuie să conțină cel puțin o majusculă și cel puțin o cifră, având minim șapte caractere");
    }

}
