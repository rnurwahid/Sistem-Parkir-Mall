package model;

public class Pengunjung extends Akun {
    private String nama;
    private String alamat;
    private String idPengunjung;

    public Akun setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public String getNama() {
        return this.nama;
    }

    public Akun setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public Pengunjung setIdPengunjung(String idPengunjung) {
        this.idPengunjung = idPengunjung;
        return this;
    }

    public String getIdPengunjung() {
        return this.idPengunjung;
    }
}