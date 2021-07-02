package pl.pjatk.JoaKoe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Car.getAllByModel",
        query = "select c from Car c where c.model = ?1")
public class Car {

    private String model;
    private String registrationNumber;
    private int milleage;
    private boolean hasAccidents;
    private double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;


    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    List<Accident> accidents = new ArrayList<Accident>();

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getMilleage() {
        return milleage;
    }

    public void setMilleage(int milleage) {
        this.milleage = milleage;
    }

    public boolean isHasAccidents() {
        return hasAccidents;
    }

    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}