package onix.mediline.accounts.roles;

public class Pacient extends User  {

    private String cnp, adresa, oras, telefon, dataNasterii, medIDMedic, sexul;

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
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + ", CNP ='" + cnp + '\'' + ", Adresa = '" + adresa + '\'' + ", Oras = '" + oras + '\'' + ", Telefon = '" + telefon + '\'' + ", Datanasterii = '" + dataNasterii + '\'' + '}';
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

}