package onix.mediline.accounts.roles;

public class Admin extends User {

    public Admin () {
        super();
    }

    public Admin (String flNume, String flPrenume, String flEmail, String flPassword) {
        super(flNume, flPrenume, flEmail, flPassword);
    }

    @Override
    public String toString() { return super.toString(); }

}