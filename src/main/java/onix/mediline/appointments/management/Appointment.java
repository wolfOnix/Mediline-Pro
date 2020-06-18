package onix.mediline.appointments.management;

import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.exceptions.AppointmentAlreadyOccupied;
import onix.mediline.appointments.exceptions.DatePassed;
import onix.mediline.appointments.exceptions.DateTooClose;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

    private static String[] appointmentStates = {"Neconfirmat", "Confirmat", "Reprogramat", "Anulat"};
    private String stareProgr, dataProgr, oraProgr, numePrenumePac, emailPac;
    private Date complexDate;

    public Appointment () { super(); }

    public Appointment (String nume, String prenume, Date date, String email) throws ParseException {
        stareProgr = appointmentStates[0];
        dataProgr = fromDateFormat(date)[2];
        oraProgr = fromDateFormat(date)[1];
        numePrenumePac = nume + " " + prenume;
        complexDate = date;
        emailPac = email;
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

    public static void checkDateNotPast(Date date) throws DatePassed {
        Date now = new Date();
        if (date.getTime() < now.getTime())
            throw new DatePassed();
    }

    public static void checkAppointmentNotOccupied(Medic med, Date date) throws UserNotFound, AppointmentAlreadyOccupied {
        for (String i : med.getListaPacEmail())
        {
            Pacient pac = ((Pacient) UsersManagement.searchUser(i, 3));
            for (Appointment a : pac.getListaApp())
                if (date.equals(a.getComplexDate()))
                    throw new AppointmentAlreadyOccupied();
        }
    }

    public String getStareProgr() {
        return stareProgr;
    }
    public void setStareProgr(String appState) { stareProgr = appState; }

    public String getDataProgr() {
        return dataProgr;
    }

    public String getOraProgr() {
        return oraProgr;
    }

    public String getEmailPac() { return emailPac; }

    public Date getComplexDate() { return complexDate; }
    public void setComplexDate(Date date) throws ParseException {
        complexDate = date;
        dataProgr = fromDateFormat(date)[2];
        oraProgr = fromDateFormat(date)[1];
    }

    public String getNumePrenumePac() {
        return numePrenumePac;
    }
    public void setNumePrenumePac(String nume, String prenume) {
        numePrenumePac = nume + " " + prenume;
    }

    public static String[] getAppointmentStates() { return appointmentStates; }
}
