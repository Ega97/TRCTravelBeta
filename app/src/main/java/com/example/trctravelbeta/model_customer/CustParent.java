package com.example.trctravelbeta.model_customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustParent {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("customer")
    @Expose
    private Customer customer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}