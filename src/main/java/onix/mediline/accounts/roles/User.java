package onix.mediline.accounts.roles;

import java.util.Objects;

public class User {

    private String nume, prenume, email, password;

    public User() {
        super();
    }

    public User (String flNume, String flPrenume, String flEmail, String flPassword) {
        nume = flNume;
        prenume = flPrenume;
        email = flEmail;
        password = flPassword;
    }

    @Override
    public String toString() {
        return "{ Nume = '" + nume + '\'' +
                ", Prenume = '" + prenume + '\'' +
                ", E-mail = '" + email + '\'' +
                ", Parola = '" + password + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFlPrenume() {
        return prenume;
    }

    public void setFlPrenume(String flPrenume) {
        this.prenume = flPrenume;
    }

    public String getFlEmail() {
        return email;
    }

    public void setFlEmail(String flEmail) {
        this.email = flEmail;
    }

    public String getFlPassword() {
        return password;
    }

    public void setFlPassword(String flPassword) {
        this.password = flPassword;
    }

}
