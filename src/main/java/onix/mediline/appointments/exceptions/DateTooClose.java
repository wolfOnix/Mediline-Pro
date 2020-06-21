package onix.mediline.appointments.exceptions;

public class DateTooClose extends Exception {

    public DateTooClose () {
        super ("Selectați momentul programării cu cel puțin trei ore după momentul actual");
    }

}