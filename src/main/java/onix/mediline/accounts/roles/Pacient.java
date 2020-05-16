package onix.mediline.accounts.roles;

public class Pacient extends User  {

    private String cnp, adresa, oras, telefon, dataNasterii;

    public Pacient () {
        super();
    }

    public Pacient(String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData) {
        super(flNume, flPrenume, flEmail, flPassword);
        this.cnp = flCNP;
        this.adresa = flAdresa;
        this.oras = flOras;
        this.telefon = flTelefon;
        this.dataNasterii = flData;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", CNP ='" + cnp + '\'' +
                ", Adresa = '" + adresa + '\'' +
                ", Oras = '" + oras + '\'' +
                ", Telefon = '" + telefon + '\'' +
                ", Datanasterii = '" + dataNasterii + '\'' +
                '}';
    }

    public String getFlCNP() {
        return cnp;
    }

    public void setFlCNP(String flCNP) {
        this.cnp = flCNP;
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

    public String getFlData() {
        return dataNasterii;
    }

    public void setFlData(String flData) {
        this.dataNasterii = flData;
    }

}
