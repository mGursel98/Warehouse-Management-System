package Business_Logic;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Potrebitel {


    private StringProperty id;
    private StringProperty username;
    private StringProperty password;
    private StringProperty usertype;
    private StringProperty FirstName;
    private StringProperty LastName;

    public Potrebitel() {
    }

    public Potrebitel(String UserName, String Password)
    {
      this.username=new SimpleStringProperty(UserName);
      this.password=new SimpleStringProperty(Password);
    }


    public Potrebitel(String id, String username, String password, String usertype, String firstName, String lastName) {
        this.id = new SimpleStringProperty(id);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.usertype = new SimpleStringProperty(usertype);
        this.FirstName = new SimpleStringProperty(firstName);
        this.LastName = new SimpleStringProperty(lastName);
    }

    public Potrebitel(String id, String firstName, String lastName) {
        this.id=new SimpleStringProperty(id);
        this.FirstName=new SimpleStringProperty(firstName);
        this.LastName=new SimpleStringProperty(lastName);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return this.id;
    }

    public void setId(String id) {
        this.id.set(id);
    }


    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getUsertype() {
        return usertype.get();
    }

    public StringProperty usertypeProperty() {
        return this.usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype.set(usertype);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }
}
