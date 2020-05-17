package onix.mediline.accounts.roles;

import java.util.ArrayList;

public class Medic extends User  {

    private String activationKey, medID, adresa, oras, telefon, emailServiciu, judet;
    //private boolean contActiv;
    private ArrayList<Pacient> listaPac;

    public Medic () {
        super();
    }

    public Medic (String flNume, String flPrenume, String flEmail) {
        super (flNume, flPrenume, flEmail, "", false);
        // medID = generate (MedID);
        // activationKey = generate (activationKey);
        // Temporar ->
        medID = "AAA";
        activationKey = "22443";
        // <- Temporar
        adresa = "";
        oras = "";
        judet = "";
        telefon = "";
        emailServiciu = "";
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + " Cheieactivare = '" + activationKey + '\'' + ", MedID = '" + medID + '\'' + ", Adresa = '" + adresa + '\'' + ", Oras = '" + oras + '\'' + ", Judet = '" + judet + '\'' + ", Telefon = '" + telefon + '\'' + ", Emailserviciu = '" + emailServiciu + '\'' + '}';
    }

    public void attachPacient (Pacient p) {
        listaPac.add(p);
    }

    public String getActivationKey() {
        return activationKey;
    }

    public String getMedid() {
        return medID;
    }
    public void setMedid(String lbMedid) {
        medID = lbMedid;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String flAdresa) {
        adresa = flAdresa;
    }

    public String getOras() {
        return oras;
    }
    public void setOras(String flOras) {
        oras = flOras;
    }

    public String getJudet() {
        return judet;
    }
    public void setJudet(String cbJudet) {
        judet = cbJudet;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String flTelefon) {
        telefon = flTelefon;
    }

    public String getEmailServ() {
        return emailServiciu;
    }
    public void setEmailServ(String flEmailServ) {
        emailServiciu = flEmailServ;
    }

    public void setFirstPassword (String flPassword) {
        super.setParola(flPassword);
    }

    public ArrayList<Pacient> getListaPacienti () { return listaPac; }
    public void setListaPacienti (ArrayList<Pacient> lp) { listaPac = lp; }

}
