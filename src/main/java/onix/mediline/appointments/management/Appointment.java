package onix.mediline.appointments.management;

import java.util.Date;

public class Appointment {

    private static String[] appointmentStates = {"Neconfirmat", "Confirmat", "Confirmat și reprogramat", "Anulat"};
    private String state = appointmentStates[0];
    private Date time;

    public Appointment (String ymd, String hr, String mn, String MedID) {

    }

}
