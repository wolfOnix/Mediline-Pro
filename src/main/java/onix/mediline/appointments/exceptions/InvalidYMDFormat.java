package onix.mediline.appointments.exceptions;

public class InvalidYMDFormat extends Exception {

    public InvalidYMDFormat () {
        super ("Data introdusă nu are un formatul necesar");
    }

}