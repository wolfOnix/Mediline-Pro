package onix.mediline.accounts.exceptions;

public class TooYoungPatient extends Exception {

    public TooYoungPatient () {
        super ("Pentru a vă face un cont, trebuie să aveți cel puțin 14 ani");
    }

}