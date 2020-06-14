package onix.mediline.accounts.roles;

import onix.mediline.appointments.exceptions.AppointmentAlreadyRequested;
import onix.mediline.appointments.management.Appointment;

import java.util.ArrayList;
import java.util.List;

public class Pacient extends User  {

    private String cnp, adresa, oras, telefon, dataNasterii, medIDMedic, sexul;
    private List<Appointment> listaApp;

    public Pacient () {
        super();
    }

    public Pacient (String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData, String cbSexul) {
        super(flNume, flPrenume, flEmail, flPassword, true);
        cnp = flCNP;
        adresa = flAdresa;
        oras = flOras;
        telefon = flTelefon;
        dataNasterii = flData;
        sexul = cbSexul;
        medIDMedic = null;
        listaApp = new ArrayList<>();
    }

    public void addApp (Appointment n) {
        listaApp.add(n);
    }

    public String toStringApp() {
        String buffer = "{" ;
        for (Appointment i : listaApp)
            buffer = buffer + i.toString();
        buffer += "}";
        return buffer;
    }

    public void checkDoubleAppointment (String date, String HM) throws AppointmentAlreadyRequested {
        for (Appointment i : listaApp)
            if (i.getStareProgr().equals(Appointment.getAppointmentStates()[0])) // Caută între cererile neconfirmate
                if (date.equals(i.getDataProgr()) && HM.equals(i.getOraProgr()))
                    throw new AppointmentAlreadyRequested();
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + ", CNP ='" + cnp + '\'' + ", Adresa = '" + adresa + '\'' + ", Oras = '" + oras + '\'' + ", Telefon = '" + telefon + '\'' + ", Datanasterii = '" + dataNasterii + '\'' + ", medIDMedic = '" + medIDMedic + '\'' + ", listaApp = '" + toStringApp() + '\'' +  '}';
    }

    public String getCNP () { return cnp; }
    public void setCNP (String flCNP) { cnp = flCNP; }

    public String getAdresa () { return adresa; }
    public void setAdresa (String flAdresa) { adresa = flAdresa; }

    public String getOras () { return oras; }
    public void setOras (String flOras) { oras = flOras; }

    public String getTelefon () { return telefon; }
    public void setTelefon (String flTelefon) { telefon = flTelefon; }

    public String getDataNasterii () { return dataNasterii; }
    public void setDataNasterii (String flData) { dataNasterii = flData; }

    public String getMedIDMedic () { return medIDMedic; }
    public void setMedIDMedic (String flMedID) { medIDMedic = flMedID; }

    public String getSexul() { return sexul; }
    public void setSexul (String cbSexul) { sexul = cbSexul; }

    public List<Appointment> getListaApp() {
        return listaApp;
    }
    public void setListaApp (List<Appointment> listaApp) {
        this.listaApp = listaApp;
    }

}