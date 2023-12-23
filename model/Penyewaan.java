package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Penyewaan {
    private String idPenyewaan;
    private Pengunjung pengunjung;
    private Penjaga penjaga;
    private int total;
    private LocalDate tanggal;
    private ArrayList<DetailPenyewaan> detailPenyewaans;

    public String getIdPenyewaan() {
        return idPenyewaan;
    }

    public Penyewaan setIdPenyewaan(String idPenyewaan) {
        this.idPenyewaan = idPenyewaan;
        return this;
    }

    public Pengunjung getPengunjung() {
        return pengunjung;
    }

    public Penyewaan setPengunjung(Pengunjung pengunjung) {
        this.pengunjung = pengunjung;
        return this;
    }

    public Penjaga getPenjaga() {
        return penjaga;
    }

    public Penyewaan setPenjual(Penjaga penjaga) {
        this.penjaga = penjaga;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Penyewaan setTotal(int total) {
        this.total = total;
        return this;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public Penyewaan setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
        return this;
    }

    public ArrayList<DetailPenyewaan> getDetailPenyewaans() {
        return detailPenyewaans;
    }

    public Penyewaan setDetailPenyewaans(ArrayList<DetailPenyewaan> detailPenyewaans) {
        this.detailPenyewaans = detailPenyewaans;
        return this;
    }

}