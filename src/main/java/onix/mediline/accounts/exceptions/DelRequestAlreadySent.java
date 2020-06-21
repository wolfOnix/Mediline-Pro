package onix.mediline.accounts.exceptions;

public class DelRequestAlreadySent  extends Exception {

    public DelRequestAlreadySent () {
        super ("Cererea de ștergere a contului este deja trimisă și este în curs de procesare");
    }

}