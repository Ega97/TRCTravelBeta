package com.example.trctravelbeta.model_driver.model_pesanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dExample {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<dDatum> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<dDatum> getOrders() {
        return data;
    }

    public void setData(List<dDatum> data) {
        this.data = data;
    }
}
