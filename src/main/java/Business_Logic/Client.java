package Business_Logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client
{


    private StringProperty client_id;
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty Address;
    private StringProperty Grad;

    Client(){}


    public Client(String client_id, String firstName, String lastName, String address, String grad) {
        this.client_id = new SimpleStringProperty(client_id);
        this.FirstName = new SimpleStringProperty(firstName);
        this.LastName = new SimpleStringProperty(lastName);
        this.Address = new SimpleStringProperty(address);
        this.Grad = new SimpleStringProperty(grad);

    }

    public String getClient_id() {
        return client_id.get();
    }

    public StringProperty client_idProperty() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id.set(client_id);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getAddress() {
        return Address.get();
    }

    public StringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
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
}
