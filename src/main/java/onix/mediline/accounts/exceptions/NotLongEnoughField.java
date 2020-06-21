package onix.mediline.accounts.exceptions;

public class NotLongEnoughField extends Exception {

    public NotLongEnoughField () {
        super ("Dimensiunea minimă a câmpurilor este de două caractere alfanumerice");
    }

}
