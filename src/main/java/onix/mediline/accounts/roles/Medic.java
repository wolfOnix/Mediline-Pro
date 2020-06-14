package onix.mediline.accounts.roles;

import onix.mediline.accounts.management.KeyGenerator;
import onix.mediline.accounts.management.UsersManagement;

import java.util.ArrayList;

public class Medic extends User  {

    private String activationKey, medID, adresa, oras, telefon, emailServiciu, judet;
    private ArrayList<String> listaPacienti;
    //private boolean contActiv;

    public Medic () {
        super();
    }

    public Medic (String flNume, String flPrenume, String flEmail) {
        super (flNume, flPrenume, flEmail, "", false);
        medID = KeyGenerator.generateKey(6);
        while (!UsersManagement.checkKeyUnicity(medID, 0))
            medID = KeyGenerator.generateKey(6);
        activationKey = KeyGenerator.generateKey(10);
        while (!UsersManagement.checkKeyUnicity(activationKey, 1))
            activationKey = KeyGenerator.generateKey(10);
        adresa = "";
        oras = "";
        judet = "";
        telefon = "";
        emailServiciu = "";
        listaPacienti = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() + ',' + " Cheieactivare = '" + activationKey + '\'' + ", MedID = '" + medID + '\'' + ", Adresa = '" + adresa + '\'' + ", Oras = '" + oras + '\'' + ", Judet = '" + judet + '\'' + ", Telefon = '" + telefon + '\'' + ", Emailserviciu = '" + emailServiciu + '\'' + '}';
    }

    public void attachPacient (String pacEmail) {
        if (!listaPacienti.contains(pacEmail))
            listaPacienti.add(pacEmail);
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

    public ArrayList<String> getListaPacienti () { return listaPacienti; }
    public void setListaPacienti (ArrayList<String> lp) { listaPacienti = lp; }

}
