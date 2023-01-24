package com.if5a.keajaibandunia;

import java.io.Serializable;

public class DataKeajaiban implements Serializable {
    private int foto;
    private String nama, umur, ditemukan, lokasi, tentang;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getDitemukan() {
        return ditemukan;
    }

    public void setDitemukan(String ditemukan) {
        this.ditemukan = ditemukan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTentang() {
        return tentang;
    }

    public void setTentang(String tentang) {
        this.tentang = tentang;
    }
}


