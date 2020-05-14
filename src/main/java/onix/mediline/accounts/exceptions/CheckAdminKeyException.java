package onix.mediline.accounts.exceptions;

public class CheckAdminKeyException extends Exception{

    private String flAdminKey;

    public CheckAdminKeyException(String flAdminKey) {
        super(String.format("An account with the AdminKey %s doesn't have the permision to login!", flAdminKey));
        this.flAdminKey = flAdminKey;
    }

    public String getFlAdminKey() {
        return flAdminKey;
    }

}
