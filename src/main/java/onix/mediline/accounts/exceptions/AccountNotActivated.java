package onix.mediline.accounts.exceptions;

public class AccountNotActivated extends Exception {

    public AccountNotActivated () {
        super ("Contul necesită activare. Folosiți cheia de activare la ‘Activare cont medical’ sau contactați administratorul");
    }

}
