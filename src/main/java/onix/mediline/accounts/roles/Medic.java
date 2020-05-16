package onix.mediline.accounts.roles;

import java.util.ArrayList;

public class Medic extends User  {

    private String cheieActivare, medID, adresa, oras, telefon, emailServiciu;
    private boolean contActiv = false;
    private ArrayList<Pacient> listaPac;

    public Medic () {
        super();
    }

    public Medic(String flNume, String flPrenume, String flEmail, String flActivationKey, String lbMedid, String flAdresa, String flOras, String flTelefon, String flEmailServ, String flPassword) {
        super(flNume, flPrenume, flEmail, flPassword);
        this.cheieActivare = flActivationKey;
        this.medID = lbMedid;
        this.adresa = flAdresa;
        this.oras = flOras;
        this.telefon = flTelefon;
        this.emailServiciu = flEmailServ;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                " Cheieactivare = '" + cheieActivare + '\'' +
                ", MedID = '" + medID + '\'' +
                ", Adresa = '" + adresa + '\'' +
                ", Oras = '" + oras + '\'' +
                ", Telefon = '" + telefon + '\'' +
                ", Emailserviciu = '" + emailServiciu + '\'' +
                ", Contactiv = '" + contActiv + '\'' +
                '}';
    }

    public String getFlActivationKey() {
        return cheieActivare;
    }

    public void setFlActivationKey(String flActivationKey) {
        this.cheieActivare = flActivationKey;
    }

    public String getLbMedid() {
        return medID;
    }

    public void setLbMedid(String lbMedid) {
        this.medID = lbMedid;
    }

    public String getFlAdresa() {
        return adresa;
    }

    public void setFlAdresa(String flAdresa) {
        this.adresa = flAdresa;
    }

    public String getFlOras() {
        return oras;
    }

    public void setFlOras(String flOras) {
        this.oras = flOras;
    }

    public String getFlTelefon() {
        return telefon;
    }

    public void setFlTelefon(String flTelefon) {
        this.telefon = flTelefon;
    }

    public String getFlEmailServ() {
        return emailServiciu;
    }

    public void setFlEmailServ(String flEmailServ) {
        this.emailServiciu = flEmailServ;
    }

}
