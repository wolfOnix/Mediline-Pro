package onix.mediline.appointments.management;

import onix.mediline.accounts.exceptions.UserNotFound;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.appointments.exceptions.AppointmentAlreadyOccupied;
import onix.mediline.appointments.exceptions.DatePassed;
import onix.mediline.appointments.exceptions.DateTooClose;
import onix.mediline.appointments.exceptions.TooManyAppointmentRequests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment implements Comparable<Appointment> {

    private static final String[] appointmentStates = {"Neconfirmat", "Aprobat", "Reprogramat", "Respins"};
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
                if (date.equals(a.getComplexDate()) && (a.getStareProgr().equals(appointmentStates[1]) || a.getStareProgr().equals(appointmentStates[2])))
                    throw new AppointmentAlreadyOccupied();
        }
    }

    public static void checkTooManyAppRequests(List<Appointment> app) throws TooManyAppointmentRequests {
        int s = 0;
        Date now = new Date();
        for (Appointment i : app)
            if (i.getStareProgr().equals(Appointment.getAppointmentStates()[0]) && i.getComplexDate().getTime() > now.getTime())
                s++;
        if (s >= 3)
            throw new TooManyAppointmentRequests();
    }

    public String getStareProgr() { return stareProgr; }
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

    @Override
    public int compareTo(Appointment o) {
        return this.getComplexDate().compareTo(o.getComplexDate());
    }
}
