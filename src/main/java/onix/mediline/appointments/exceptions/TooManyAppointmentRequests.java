package onix.mediline.appointments.exceptions;

public class TooManyAppointmentRequests extends Exception {

    public TooManyAppointmentRequests () {
        super ("Nu puteți solicita mai mult de trei programări. Așteptați gestiunea programărilor anterioare");
    }

}