package onix.mediline.accounts.model;

import java.util.Objects;

public class Medic extends User  {

    private String flActivationKey;
    private String lbMedid;
    private String flAdresa;
    private String flOras;
    private String flTelefon;
    private String flEmailServ;

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "flActivationKey='" + flActivationKey + '\'' +
                ", lbMedid='" + lbMedid + '\'' +
                ", flAdresa='" + flAdresa + '\'' +
                ", flOras='" + flOras + '\'' +
                ", flTelefon='" + flTelefon + '\'' +
                ", flEmailServ='" + flEmailServ + '\'' +
                '}';
    }

    public String getFlActivationKey() {
        return flActivationKey;
    }

    public void setFlActivationKey(String flActivationKey) {
        this.flActivationKey = flActivationKey;
    }

    public String getLbMedid() {
        return lbMedid;
    }

    public void setLbMedid(String lbMedid) {
        this.lbMedid = lbMedid;
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

    public String getFlEmailServ() {
        return flEmailServ;
    }

    public void setFlEmailServ(String flEmailServ) {
        this.flEmailServ = flEmailServ;
    }


    public Medic(String flNume, String flPrenume, String flEmail, String flActivationKey, String lbMedid, String flAdresa, String flOras, String flTelefon, String flEmailServ, String flPassword) {
        super("Medic",flNume,flPrenume,flEmail,flPassword);
        this.flActivationKey = flActivationKey;
        this.lbMedid = lbMedid;
        this.flAdresa = flAdresa;
        this.flOras = flOras;
        this.flTelefon = flTelefon;
        this.flEmailServ = flEmailServ;
    }
}
