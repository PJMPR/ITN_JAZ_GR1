package pl.pjatk.JoaKoe.contract;

import pl.pjatk.JoaKoe.model.Adress;

public class AdressDto {

    int id;
    String city;
    String country;
    String adressLine;
    String postalCode;
    Adress.AdressType type;

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

    public Adress.AdressType getType() {
        return type;
    }

    public void setType(Adress.AdressType type) {
        this.type = type;
    }
}
