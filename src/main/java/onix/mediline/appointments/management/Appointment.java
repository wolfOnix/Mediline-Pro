package onix.mediline.appointments.management;

import java.util.Date;

public class Appointment {

    private static String[] appointmentStates = {"Neconfirmat", "Confirmat", "Confirmat și reprogramat", "Anulat"};
    private String state = appointmentStates[0];
    //private Date time;
    private String date;
    private String ora;
    public Appointment() { super(); }
    public Appointment(String state, String date, String ora) {
        this.state = state;
        this.date = date;
        this.ora = ora;
    }
    public static String[] getAppointmentStates() {
        return appointmentStates;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }
}
