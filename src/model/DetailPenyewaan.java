package model;

public class DetailPenyewaan {
    private static final String totalBiaya = null;
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

    public int getTarifSewa() {
        return tarifSewa;
    }

    public void setTarifSewa(int tarifSewa) {
        this.tarifSewa = tarifSewa;
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

    public void setJumlahBeli(int jumlah) {
    }

    public void setTotalBiaya(double totalBiaya) {
    }

    public String getTotalBiaya() {

        return totalBiaya;
    }

}
