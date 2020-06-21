package onix.mediline.documents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.documents.exceptions.DocumentAlreadySent;

public class Document {

    private String titlu, tip, continut, dataEmitere, numePrenumePac;
    private static final ObservableList<String> tipuri = FXCollections.observableArrayList("Concluzii consultatie", "Interpretare analize", "Reteta medicala", "Rezultat analize", "Rezultat investigatii", "Schema de tratament", "Scrisoare medicala", "Diverse");

    public Document() { }

    public Document(String title, String type, String content, String date, String numePrenume) {
        titlu = title;
        tip = type;
        continut = content;
        dataEmitere = date;
        numePrenumePac = numePrenume;
    }

    public static ObservableList<String> getTipuri() {
        return tipuri;
    }

    public static void checkDocumentAlreadySent (Document d, Pacient p) throws DocumentAlreadySent {
        for (Document i : p.getListaDoc())
            if (d.equals(i))
                throw new DocumentAlreadySent();
    }

    public String toString() {
        return " --- DOCUMENT MEDICAL FĂRĂ PARAFĂ ---\n\nTITLU: " + titlu + "\nTIP DOCUMENT: " + tip + "\nDATA EMITERII: " + dataEmitere + "\n\nCONȚINUTUL DOCUMENTULUI: " + continut + "\n\n\n --- Documentul a fost transmis prin cadrul aplicației Mediline ---";
    }

    public String getTitlu() { return titlu; }
    public void setTitlu(String title) { titlu = title; }

    public String getTip() { return tip; }
    public void setTip(String type) { tip = type; }

    public String getContinut() { return continut; }
    public void setContinut(String content) { continut = content; }

    public String getDataEmitere() { return dataEmitere; }
    public void setDataEmitere(String date) { dataEmitere = date; }

    public String getNumePrenumePac() { return numePrenumePac; }

    public boolean equals(Object o) {
        if (!(o instanceof Document)) return false;
        Document d = (Document) o;
        return d.getTitlu().equals(this.titlu) && d.getDataEmitere().equals(this.dataEmitere) && d.getTip().equals(this.tip);
    }

}
