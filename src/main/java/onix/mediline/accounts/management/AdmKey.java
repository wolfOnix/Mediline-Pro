package onix.mediline.accounts.management;

public class AdmKey {

    private String key, password;

    public AdmKey() { super(); }

    public AdmKey(String key, String password) {
        this.key = key;
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
