package onix.mediline.accounts.exceptions;

public class EmailAlreadyExistsException extends Exception {

    private String Email;

    public EmailAlreadyExistsException(String Email) {
        super(String.format("An account with the Email %s already exists!", Email));
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }
}
