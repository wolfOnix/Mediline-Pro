package onix.mediline.appointments.exceptions;

public class DatePassed extends Exception {

    public DatePassed () {
        super ("Selectați o dată care încă nu a trecut");
    }

}