package onix.mediline.accounts.roles;

import java.util.Objects;

public class User {

    private String nume, prenume, email, parola;
    private boolean contActiv, requestDelete = false;

    public User() {
        super();
    }

    public User (String flNume, String flPrenume, String flEmail, String flPassword, boolean activationState) {
        nume = flNume;
        prenume = flPrenume;
        email = flEmail;
        parola = flPassword;
        contActiv = activationState;
    }

    @Override
    public String toString() {
        return "{ Nume = '" + nume + '\'' + ", Prenume = '" + prenume + '\'' + ", E-mail = '" + email + '\'' + ", Parola = '" + parola + '\'';
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
        return Objects.hash(parola);
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String flPrenume) {
        prenume = flPrenume;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String flEmail) {
        email = flEmail;
    }

    public String getParola() {
        return parola;
    }
    public void setParola(String flPassword) {
        parola = flPassword;
    }

    public boolean getContActiv () {
        return contActiv;
    }
    public void setContActiv (boolean activationState) {
        contActiv = activationState;
    }

    public boolean getRequestDelete () { return requestDelete; }
    public void setRequestDelete (boolean tkRequestDelete ) { requestDelete = tkRequestDelete; }

}
