package model;

public class Kendaraan {
    private String idKendaraan;
    private String namaKendaraan;
    private int tarifKendaraan;

    public Kendaraan setIdKendaraan(String idKendaraan) {
        this.idKendaraan = idKendaraan;
        return this;
    }

    public Kendaraan setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
        return this;
    }

    public Kendaraan setTarifKendaraan(int tarifKendaraan) {
        this.tarifKendaraan = tarifKendaraan;
        return this;
    }

    public String getIdKendaraan() {
        return idKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public int getTarifKendaraan() {
        return tarifKendaraan;
    }

    public boolean isIsAvailable() {
        return false;
    }

}
