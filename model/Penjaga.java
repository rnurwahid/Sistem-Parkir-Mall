package model;

public class Penjaga extends Akun {
    private String idPenjaga;

    public Penjaga setIdPenjaga(String idPenjaga) {
        this.idPenjaga = idPenjaga;
        return this;
    }

    public String getIdPenjaga() {
        return this.idPenjaga;
    }

}