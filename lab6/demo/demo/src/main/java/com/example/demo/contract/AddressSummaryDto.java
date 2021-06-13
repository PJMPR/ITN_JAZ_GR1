package com.example.demo.contract;

import com.example.demo.model.Address;

public class AddressSummaryDto {
    int id;
    Address.AddressType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address.AddressType getType() {
        return type;
    }

    public void setType(Address.AddressType type) {
        this.type = type;
    }
}
