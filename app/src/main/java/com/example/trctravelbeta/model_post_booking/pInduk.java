package com.example.trctravelbeta.model_post_booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class pInduk {
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
