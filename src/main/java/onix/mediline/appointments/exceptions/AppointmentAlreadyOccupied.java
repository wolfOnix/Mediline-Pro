package onix.mediline.appointments.exceptions;

public class AppointmentAlreadyOccupied extends Exception {

    public AppointmentAlreadyOccupied () {
        super ("Nu este loc liber pentru data și ora aleasă");
    }

}