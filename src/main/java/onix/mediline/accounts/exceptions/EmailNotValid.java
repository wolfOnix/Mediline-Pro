package onix.mediline.accounts.exceptions;

public class EmailNotValid extends Exception {

    public EmailNotValid () {
        super ("Adresa de e-mail introdusă nu are un format valid");
    }

}