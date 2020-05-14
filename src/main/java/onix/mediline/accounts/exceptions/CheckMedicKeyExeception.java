package onix.mediline.accounts.exceptions;

public class CheckMedicKeyExeception extends Exception{

    private String flActivationKey;

    public CheckMedicKeyExeception (String flActivationKey) {
        super(String.format("An account with the MedicID %s doesn't have the permision to login!", flActivationKey));
        this.flActivationKey = flActivationKey;
    }

    public String getflActivationKey() {
        return flActivationKey;
    }

}
