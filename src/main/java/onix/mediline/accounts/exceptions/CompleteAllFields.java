package onix.mediline.accounts.exceptions;

public class CompleteAllFields extends Exception {

    public CompleteAllFields (String email) {
        super ("Toate câmpurile trebuie completate");
    }

}
