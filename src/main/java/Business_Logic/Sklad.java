package Business_Logic;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sklad {


    private StringProperty sklad_id;
    private StringProperty Razmeri;
    private StringProperty Opisanie;
    private StringProperty Grad;
    private DoubleProperty Cena;
    private StringProperty Vid_stoka;

   public Sklad(){}



    public Sklad(String sklad_id, String razmeri, String opisanie, String grad, Double cena, String vidstoka) {

        this.sklad_id = new SimpleStringProperty(sklad_id);
        this.Razmeri = new SimpleStringProperty(razmeri);
        this.Opisanie = new SimpleStringProperty(opisanie);
        this.Grad = new SimpleStringProperty(grad);
        this.Cena = new SimpleDoubleProperty(cena);
        this.Vid_stoka = new SimpleStringProperty(vidstoka);

    }

    public String getSklad_id() {
        return sklad_id.get();
    }

    public StringProperty sklad_idProperty() {
        return sklad_id;
    }

    public void setSklad_id(String sklad_id) {
        this.sklad_id.set(sklad_id);
    }

    public String getRazmeri() {
        return Razmeri.get();
    }

    public StringProperty razmeriProperty() {
        return Razmeri;
    }

    public void setRazmeri(String razmeri) {
        this.Razmeri.set(razmeri);
    }

    public String getOpisanie() {
        return Opisanie.get();
    }

    public StringProperty opisanieProperty() {
        return Opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.Opisanie.set(opisanie);
    }

    public String getGrad() {
        return Grad.get();
    }

    public StringProperty gradProperty() {
        return Grad;
    }

    public void setGrad(String grad) {
        this.Grad.set(grad);
    }

    public double getCena() {
        return Cena.get();
    }

    public DoubleProperty cenaProperty() {
        return Cena;
    }

    public void setCena(double cena) {
        this.Cena.set(cena);
    }

    public String getVid_stoka() {
        return Vid_stoka.get();
    }

    public StringProperty vid_stokaProperty() {
        return Vid_stoka;
    }

    public void setVid_stoka(String vid_stoka) {
        this.Vid_stoka.set(vid_stoka);
    }
}
