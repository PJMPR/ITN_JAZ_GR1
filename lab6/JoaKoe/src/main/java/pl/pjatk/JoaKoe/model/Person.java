package pl.pjatk.JoaKoe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Person.getAllByName",
        query = "select p from Person p where p.name = ?1")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    String name;
    String surname;
    int age;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    List<Adress> adresses = new ArrayList<Adress>();

    public List<Adress> getAddresses() {
        return adresses;
    }

    public void setAddresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
