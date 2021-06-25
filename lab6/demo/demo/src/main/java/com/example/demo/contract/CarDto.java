package com.example.demo.contract;

import java.util.ArrayList;
import java.util.List;

public class CarDto {
    String model;
    String registrationNumber;
    int milleage;
    boolean hasAccidents;
    double price;
    int ID;
    List<AccidentSummaryDto> accident = new ArrayList<>();


    public List<AccidentSummaryDto> getAccident() {
        return accident;
    }

    public void setAccident(List<AccidentSummaryDto> accident) {
        this.accident = accident;
    }

    public CarDto(){}

    public CarDto(String model, String registrationNumber, int milleage, boolean hasAccidents, double price) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.milleage = milleage;
        this.hasAccidents = hasAccidents;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    public void setMilleage(int milleage) {
        this.milleage = milleage;
    }
    public int getMilleage() {
        return milleage;
    }

    public boolean isHasAccidents() {
        return hasAccidents;
    }

    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
