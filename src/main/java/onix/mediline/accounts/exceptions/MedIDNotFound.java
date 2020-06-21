package onix.mediline.accounts.exceptions;

public class MedIDNotFound extends Exception {

    public MedIDNotFound () {
        super ("MedID-ul introdus nu aparține niciunui medic de familie");
    }

}