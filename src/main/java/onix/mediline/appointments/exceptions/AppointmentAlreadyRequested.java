package onix.mediline.appointments.exceptions;

public class AppointmentAlreadyRequested extends Exception {

    public AppointmentAlreadyRequested () {
        super ("Ați efectuat deja o cerere de programare pentru data și ora introduse");
    }

}