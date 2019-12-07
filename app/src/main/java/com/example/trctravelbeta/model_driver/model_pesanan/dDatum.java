package com.example.trctravelbeta.model_driver.model_pesanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dDatum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("JadwalId")
    @Expose
    private Integer jadwalId;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("titik_jemput")
    @Expose
    private String titikJemput;
    @SerializedName("jumlah_kursi")
    @Expose
    private Integer jumlahKursi;
    @SerializedName("total_bayar")
    @Expose
    private Integer totalBayar;
    @SerializedName("no_telp")
    @Expose
    private String noTelp;
    @SerializedName("detail_tujuan")
    @Expose
    private String detailTujuan;
    @SerializedName("metode_pembayaran")
    @Expose
    private String metodePembayaran;
    @SerializedName("createdAt")
    @Expose
    private Object createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Object updatedAt;
    @SerializedName("Customer")
    @Expose
    private dCustomer customer;
    @SerializedName("Jadwal")
    @Expose
    private dJadwal jadwal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJadwalId() {
        return jadwalId;
    }

    public void setJadwalId(Integer jadwalId) {
        this.jadwalId = jadwalId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getTitikJemput() {
        return titikJemput;
    }

    public void setTitikJemput(String titikJemput) {
        this.titikJemput = titikJemput;
    }

    public Integer getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(Integer jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public Integer getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Integer totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getDetailTujuan() {
        return detailTujuan;
    }

    public void setDetailTujuan(String detailTujuan) {
        this.detailTujuan = detailTujuan;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public dCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(dCustomer customer) {
        this.customer = customer;
    }

    public dJadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(dJadwal jadwal) {
        this.jadwal = jadwal;
    }
}
