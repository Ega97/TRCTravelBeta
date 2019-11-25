package com.example.trctravelbeta.model_pesanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class pExample {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<pDatum> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<pDatum> getData() {
        return data;
    }

    public void setData(List<pDatum> data) {
        this.data = data;
    }
}
