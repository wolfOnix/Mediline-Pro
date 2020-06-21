package onix.mediline.accounts.exceptions;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException (String email) {
        super ("Un cont cu adresa " + email + " este deja existent");
    }

}
