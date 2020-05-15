package onix.mediline.accounts.roles;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

//@JsonDeserialize(as = Admin.class, Pacient.class)
public class User {

    private String role;
    private String flNume;
    private String flPrenume;
    private String flEmail;
    private String flPassword;

    public User() {
        super();
    }

    public User (String role, String flNume, String flPrenume, String flEmail, String flPassword) {
        this.role = role;
        this.flNume = flNume;
        this.flPrenume = flPrenume;
        this.flEmail = flEmail;
        this.flPassword = flPassword;
    }

    @Override
    public String toString() {
        return "UserDTO{ role='" + role + '\'' +
                ", flNume='" + flNume + '\'' +
                ", flPrenume='" + flPrenume + '\'' +
                ", flEmail='" + flEmail + '\'' +
                ", flPassword='" + flPassword + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(flEmail, user.flEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flPassword);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFlNume() {
        return flNume;
    }

    public void setFlNume(String flNume) {
        this.flNume = flNume;
    }

    public String getFlPrenume() {
        return flPrenume;
    }

    public void setFlPrenume(String flPrenume) {
        this.flPrenume = flPrenume;
    }

    public String getFlEmail() {
        return flEmail;
    }

    public void setFlEmail(String flEmail) {
        this.flEmail = flEmail;
    }

    public String getFlPassword() {
        return flPassword;
    }

    public void setFlPassword(String flPassword) {
        this.flPassword = flPassword;
    }



}
