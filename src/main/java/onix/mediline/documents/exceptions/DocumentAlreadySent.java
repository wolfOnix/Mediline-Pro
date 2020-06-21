package onix.mediline.documents.exceptions;

public class DocumentAlreadySent extends Exception {

    public DocumentAlreadySent () {
        super ("Documentul este deja trimis");
    }

}