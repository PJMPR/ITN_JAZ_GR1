package pl.pjatk.JoaKoe.contract;

import pl.pjatk.JoaKoe.model.Adress;

public class AdressSummaryDto {
    int id;
    Adress.AdressType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adress.AdressType getType() {
        return type;
    }

    public void setType(Adress.AdressType type) {
        this.type = type;
    }
}
