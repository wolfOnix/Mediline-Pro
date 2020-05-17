package onix.mediline.accounts.exceptions;

public class UserNotFound extends Exception {

    public UserNotFound () {
        super ("Nu s-a putut găsi niciun cont cu adresa de e-mail introdusă");
    }

}
