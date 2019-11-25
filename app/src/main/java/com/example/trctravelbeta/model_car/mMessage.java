package com.example.trctravelbeta.model_car;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mMessage {

    @SerializedName("data")
    @Expose
    private List<mJadwal> data = null;
    @SerializedName("message")
    @Expose
    private String message;

    public List<mJadwal> getData() {
        return data;
    }

    public void setData(List<mJadwal> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
