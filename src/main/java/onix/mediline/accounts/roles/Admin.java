package onix.mediline.accounts.roles;


public class Admin extends User {


    private String flAdminKey;

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "flAdminKey='" + flAdminKey + "}";
    }

    public Admin(String flNume, String flPrenume, String flEmail, String flPassword, String flAdminKey) {
        super("Admin",flNume,flPrenume,flEmail,flPassword);
        this.flAdminKey = flAdminKey;
    }

    public void setFlAdminKey(String flAdminKey) {
        this.flAdminKey = flAdminKey;
    }

    public String getFlAdminKey() {
        return flAdminKey;
    }

}
