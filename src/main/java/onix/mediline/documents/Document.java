package onix.mediline.documents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Document {

    private String titlu, tip, continut, dataEmitere, numePrenumePac;
    private static ObservableList<String> tipuri = FXCollections.observableArrayList("Concluzii consultație", "Interpretare analize", "Rețetă medicală", "Rezultat analize", "Rezultat investigații", "Schemă de tratament", "Scrisoare medicală", "Diverse");

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

}
