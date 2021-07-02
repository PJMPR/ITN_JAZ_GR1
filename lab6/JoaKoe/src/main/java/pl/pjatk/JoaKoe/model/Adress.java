package pl.pjatk.JoaKoe.model;

import javax.persistence.*;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String city;
    String country;
    String adressLine;
    String postalCode;
    AdressType type;

    @ManyToOne
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdressLine() {
        return adressLine;
    }

    public void setAdressLine(String adressLine) {
        this.adressLine = adressLine;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AdressType getType() {
        return type;
    }

    public void setType(AdressType type) {
        this.type = type;
    }

    public enum AdressType{
        contact, home, office
    }
}
