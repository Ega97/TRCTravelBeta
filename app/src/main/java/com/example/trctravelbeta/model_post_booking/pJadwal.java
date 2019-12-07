package com.example.trctravelbeta.model_post_booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pJadwal {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tanggal_berangkat")
    @Expose
    private String tanggalBerangkat;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("jam_berangkat")
    @Expose
    private String jamBerangkat;
    @SerializedName("MobilId")
    @Expose
    private Integer mobilId;
    @SerializedName("jumlah_kursi")
    @Expose
    private Integer jumlahKursi;
    @SerializedName("kursi_kosong")
    @Expose
    private Integer kursiKosong;
    @SerializedName("kursi_terisi")
    @Expose
    private Integer kursiTerisi;
    @SerializedName("harga_perkursi")
    @Expose
    private Integer hargaPerkursi;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public Integer getMobilId() {
        return mobilId;
    }

    public void setMobilId(Integer mobilId) {
        this.mobilId = mobilId;
    }

    public Integer getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(Integer jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public Integer getKursiKosong() {
        return kursiKosong;
    }

    public void setKursiKosong(Integer kursiKosong) {
        this.kursiKosong = kursiKosong;
    }

    public Integer getKursiTerisi() {
        return kursiTerisi;
    }

    public void setKursiTerisi(Integer kursiTerisi) {
        this.kursiTerisi = kursiTerisi;
    }

    public Integer getHargaPerkursi() {
        return hargaPerkursi;
    }

    public void setHargaPerkursi(Integer hargaPerkursi) {
        this.hargaPerkursi = hargaPerkursi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
