package onix.mediline.appointments.management;

import onix.mediline.appointments.exceptions.DatePassed;
import onix.mediline.appointments.exceptions.DateTooClose;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

    private static String[] appointmentStates = {"Neconfirmat", "Confirmat", "Confirmat și reprogramat", "Anulat"};
    private String stareProgr, dataProgr, oraProgr, emailPac, numePrenumePac;

    public Appointment () { super(); }

    public Appointment (String appDate, String appHM, String email, String nume, String prenume) throws ParseException {
        stareProgr = appointmentStates[0];
        dataProgr = fromDateFormat(toDateFormat(appDate, appHM))[2];
        oraProgr = appHM;
        emailPac = email;
        numePrenumePac = nume + " " + prenume;
    }

    public static Date toDateFormat (String data, String HM) throws ParseException {
        String TimeString = data + " " + HM;
        SimpleDateFormat completeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return completeDateFormat.parse(TimeString);
    }

    public static String[] fromDateFormat (Date date) throws ParseException {
        String[] dateAndTime = new String[3];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateAndTime[0] = dateFormat.format(date);
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        dateAndTime[1] = hourFormat.format(date);
        SimpleDateFormat dateFormatEU = new SimpleDateFormat("dd.MM.yyyy");
        dateAndTime[2] = dateFormatEU.format(date);
        return dateAndTime;
    }

    public static void checkDateApproach (Date date) throws DateTooClose {
        Date now = new Date();
        if (date.getTime() - now.getTime() < 3 * 60 * 60 * 1000)
            throw new DateTooClose();
    }

    public String getStareProgr() {
        return stareProgr;
    }
    public void setStareProgr(String appState) { stareProgr = appState; }

    public String getDataProgr () {
        return dataProgr;
    }
    public void setDataProgr (String appDate) {
        dataProgr = appDate;
    }

    public String getOraProgr () {
        return oraProgr;
    }
    public void setOraProgr (String appHM) {
        oraProgr = appHM;
    }

    public String getEmailPac () {
        return emailPac;
    }
    public void setEmailPac (String email) {
        emailPac = email;
    }

    public String getNumePrenumePac () {
        return numePrenumePac;
    }
    public void setNumePrenumePac (String nume, String prenume) {
        numePrenumePac = nume + " " + prenume;
    }

    public static String[] getAppointmentStates() { return appointmentStates; }
}
