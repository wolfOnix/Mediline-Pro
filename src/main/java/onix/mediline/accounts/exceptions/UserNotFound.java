package onix.mediline.accounts.exceptions;

public class UserNotFound extends Exception {

    public UserNotFound () {
        super ("Nu există niciun cont cu adresa de e-mail introdusă");
    }

}
