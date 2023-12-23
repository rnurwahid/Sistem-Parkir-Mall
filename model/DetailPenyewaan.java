package model;

public class DetailPenyewaan {
    private String idDetailPenyewaan;
    private Penyewaan penyewaan;
    private Kendaraan kendaraan;
    private int tarifSewa;
    private double waktuMasuk;
    private double waktuKeluar;
    private int subTotal;

    public String getIdDetailPenyewaan() {
        return idDetailPenyewaan;
    }

    public void setIdDetailPenyewaan(String idDetailPenyewaan) {
        this.idDetailPenyewaan = idDetailPenyewaan;
    }

    public Penyewaan getPenyewaan() {
        return penyewaan;
    }

    public void setPenyewaan(Penyewaan penyewaan) {
        this.penyewaan = penyewaan;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public int getTarifKendaraan() {
        return tarifKendaraan;
    }

    public void setTarifKendaraan(int tarifKendaraan) {
        this.tarifKendaraan = tarifKendaraan;
    }

    public double getWaktuMasuk() {
        return waktuMasuk;
    }

    public void setWaktuMasuk(double waktuMasuk) {
        this.waktuMasuk = waktuMasuk;
    }

    public double getWaktuKeluar() {
        return waktuKeluar;
    }

    public void setWaktuKeluar(double waktuKeluar) {
        this.waktuKeluar = waktuKeluar;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

}
