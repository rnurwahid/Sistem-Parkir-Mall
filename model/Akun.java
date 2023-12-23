package model;

public class Akun {

    private String nama;
    private String alamat;

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

}
