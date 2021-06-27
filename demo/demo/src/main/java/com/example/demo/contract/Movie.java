package com.example.demo.contract;

public class Person {


    int ID;
    String nazwa;
    String kategoria;
    int rok_wydania;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getRok_wydania() {
        return rok_wydania;
    }

    public void setRok_wydania(int rok_wydania) {
        this.rok_wydania = rok_wydania;
    }
}