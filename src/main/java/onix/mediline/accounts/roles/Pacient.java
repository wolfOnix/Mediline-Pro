package onix.mediline.accounts.roles;


public class Pacient extends User  {


    private String flCNP;
    private String flAdresa;
    private String flOras;
    private String flTelefon;
    private String flData;

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "flCNP='" + flCNP + '\'' +
                ", flAdresa='" + flAdresa + '\'' +
                ", flOras='" + flOras + '\'' +
                ", flTelefon='" + flTelefon + '\'' +
                ", flData='" + flData + '\'' +
                '}';
    }

    public String getFlCNP() {
        return flCNP;
    }

    public void setFlCNP(String flCNP) {
        this.flCNP = flCNP;
    }

    public String getFlAdresa() {
        return flAdresa;
    }

    public void setFlAdresa(String flAdresa) {
        this.flAdresa = flAdresa;
    }

    public String getFlOras() {
        return flOras;
    }

    public void setFlOras(String flOras) {
        this.flOras = flOras;
    }

    public String getFlTelefon() {
        return flTelefon;
    }

    public void setFlTelefon(String flTelefon) {
        this.flTelefon = flTelefon;
    }

    public String getFlData() {
        return flData;
    }

    public void setFlData(String flData) {
        this.flData = flData;
    }

    public Pacient(String flNume, String flPrenume, String flEmail, String flPassword, String flCNP, String flAdresa, String flOras, String flTelefon, String flData) {
        super("Pacient",flNume,flPrenume,flEmail,flPassword);
        this.flCNP = flCNP;
        this.flAdresa = flAdresa;
        this.flOras = flOras;
        this.flTelefon = flTelefon;
        this.flData = flData;
    }
}
