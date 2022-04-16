package Business_Logic;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Formulqr {


    private StringProperty for_id;
    private StringProperty infoClient;
    private StringProperty period;
    private StringProperty grad;
    private DoubleProperty cena;


    public Formulqr(){}

    public Formulqr(String for_id, String infoClient, String period, String grad, Double cena) {
        this.for_id = new SimpleStringProperty(for_id);
        this.infoClient = new SimpleStringProperty(infoClient);
        this.period = new SimpleStringProperty(period);
        this.grad = new SimpleStringProperty(grad);
        this.cena = new SimpleDoubleProperty(cena);
    }


    public String getFor_id() {
        return for_id.get();
    }

    public StringProperty for_idProperty() {
        return for_id;
    }

    public void setFor_id(String for_id) {
        this.for_id.set(for_id);
    }

    public String getInfoClient() {
        return infoClient.get();
    }

    public StringProperty infoClientProperty() {
        return infoClient;
    }

    public void setInfoClient(String infoClient) {
        this.infoClient.set(infoClient);
    }

    public String getPeriod() {
        return period.get();
    }

    public StringProperty periodProperty() {
        return period;
    }

    public void setPeriod(String period) {
        this.period.set(period);
    }

    public String getGrad() {
        return grad.get();
    }

    public StringProperty gradProperty() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad.set(grad);
    }

    public double getCena() {
        return cena.get();
    }

    public DoubleProperty cenaProperty() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena.set(cena);
    }
}
