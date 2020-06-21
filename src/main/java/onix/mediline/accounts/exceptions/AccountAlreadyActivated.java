package onix.mediline.accounts.exceptions;

public class AccountAlreadyActivated extends Exception {

    public AccountAlreadyActivated () {
        super ("Contul introdus este deja activat");
    }

}