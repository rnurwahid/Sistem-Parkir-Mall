package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;

import model.Kendaraan;
import model.DetailPenyewaan;
import model.Pengunjung;
import model.Penjaga;
import model.Penyewaan;

public class ParkirController {
    HashMap<String, Kendaraan> kendaraans = new HashMap();
    ArrayList<Penyewaan> penyewaans = new ArrayList<>();
    HashMap<String, Pengunjung> pengunjungs = new HashMap();
    HashMap<String, Penjaga> penjagas = new HashMap();

    public void setUp() {
        Kendaraan kendaraan1 = new Kendaraan();
        Kendaraan kendaraan2 = new Kendaraan();
        kendaraan1
                .setIdKendaraan("A1")
                .setNamaKendaraan("Roda Dua")
                .setTarifKendaraan(3000);

        kendaraan2
                .setNamKendaraan("B1")
                .setIdKendaraan("Roda Empat")
                .setTarifKendaraan(5000);

        kendaraans.put(kendaraan1.getIdKendaraan(), kendaraan1);
        kendaraans.put(kendaraan2.getIdKendaraan(), kendaraan2);

        Pengunjung Pengunjung1 = new Pengunjung();
        Pengunjung Pengunjung2 = new Pengunjung();
        Pengunjung1
                .setIrnengunjung("01")
                .setName("Doraemon");

        Pengunjung2.setIdPengunjung("02")
                .setName("Nobita");

        Pengunjungs.put(Pengunjung1.getIdPengunjung(), Pengunjung1);
        Pengunjungs.put(Pengunjung2.getIdPengunjung(), Pengunjung2);

        Penjaga penjaga1 = new Penjaga();
        Penjaga penjaga2 = new Penjaga();
        penjaga1
                .setIdPenjaga("01")
                .setName("Giant");

        penjaga2
                .setIdPenjaga("02")
                .setName("Suneo");

        penjagas.put(penjaga1.getIdPenjaga(), penjaga1);
        penjagas.put(penjaga2.getIdPenjaga(), penjaga2);
    }

    public void lihatDaftarKendaraan() {
        System.out.println();
        System.out.println("==== Tarif Kendaraan ====");
        for (Map.Entry<String, Kendaraan> kendaraan : kendaraans.entrySet()) {
            String key = kendaraan.getKey();
            Kendaraan tKendaraan = kendaraan.getValue();
            if (tKendaraan.isIsAvailable()) {
                System.out.println("Kode Kendaraan \t :" + key);
                System.out.println("Jenis Kendaraan \t\t :" + tKendaraan.getNamaKendaraan());
                System.out.println("Tarif \t\t :" + tKendaraan.getTarifKendaraan());
                System.out.println();
            }

        }
    }

    public Kendaraan getKendaraan(String idKendaraan) {
        return kendaraans.get(idKendaraan);
    }

    public Penjaga getPenjaga(String idPenjaga) {
        return penjagas.get(idPenjaga);
    }

    public Pengunjung getPengunjung(String idPengunjung) {
        return Pengunjungs.get(idPengunjung);
    }

    public void transaksi() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DetailPenyewaan> tDetailPenyewaans = new ArrayList<>();

        System.out.println();
        System.out.print("Silahkan masukkan kode kendaraan\t: ");
        String kodeKendaraan = scanner.nextLine();
        System.out.print("Waktu Masuk\t: ");
        double waktuMasuk = Double.parseDouble(scanner.nextLine());
        System.out.print("Waktu Keluar\t: ");
        double waktuKeluar = Double.parseDouble(scanner.nextLine());

        DetailPenyewaan rn = new DetailPenyewaan();
        Kendaraan tKendaraan = getKendaraan(kodeKendaraan);
        // Assuming jumlah is defined and initialized properly elsewhere
        int jumlah = 1; // Just as an example, it should be properly defined and set
        rn.setIdDetailPenyewaan("rn" + jumlah);
        rn.setKendaraan(tKendaraan);
        rn.setTarifSewa(tKendaraan.getTarifKendaraan());
        rn.setJumlahBeli(jumlah);
        rn.setSubTotal(tKendaraan.getTarifKendaraan() * jumlah);
        tDetailPenyewaans.add(rn);

        System.out.println("\n===Berikut Tarif Parkir Anda===");
        tampilkanDaftarSewaan(tDetailPenyewaans);
        System.out.println("\nTOTAL: " + hitungTotalSewa(tDetailPenyewaans));

        scanner.close(); // Closing Scanner after use
    }

    public void tampilkanDaftarSewaan(ArrayList<DetailPenyewaan> rn) {
        for (DetailPenyewaan detailPenyewaan : rn) {
            System.out.println("Nama Kendaraan \t :" + detailPenyewaan.getKendaraan().getNamaKendaraan());
            System.out.println("Tarif \t :" + detailPenyewaan.getTarifSewa());
            System.out.println("Jumlah \t :" + detailPenyewaan.getJumlahBeli());
            System.out.println("");
        }
    }

    public double hitungWaktu(double waktuMasuk, double waktuKeluar) {
        double waktuSewa = waktuKeluar - waktuMasuk;
        return waktuSewa;
    }

    public int waktuSewa1(double waktuSewa) {
        int waktuSewa1 = (int) waktuSewa; // Casting waktuSewa ke int
        return waktuSewa1;
    }
    
    public double waktuSewa2(double waktuSewa, int waktuSewa1) {
        double waktuSewa2 = waktuSewa - waktuSewa1;
        return waktuSewa2;
    }
    
    public int hitungSewaJamR2(double waktuSewa1) {
        int jamR2 = 3000 * waktuSewa1;
        return jamR2;
    }
    
    public int hitungSewaMenitR2(double waktuSewa2) {
        int menitR2 = (int) (3000 * waktuSewa2); // Casting hasil perhitungan ke int
        return menitR2;
    }
    
    public int hitungSewaJamR4(double waktuSewa1) {
        int jamR4 = 5000 * waktuSewa1;
        return jamR4;
    }
    
    public int hitungSewaMenitR4(double waktuSewa2) {
        int menitR4 = (int) (5000 * waktuSewa2); // Casting hasil perhitungan ke int
        return menitR4;
    }
    
    public int hitungTotalSewa(ArrayList<DetailPenyewaan> rn) {
        int total = 0; // Inisialisasi total
        for (DetailPenyewaan detailPenyewaan : rn) {
            total += detailPenyewaan.getSubTotal();
        }
        return total;
    }
    

    public void tampilkanLaporanPenyewaan() {
        for (Penyewaan penyewaan : penyewaans) {
            System.err.println();
            System.out.println("Kode Penyewaan \t :" + penyewaan.getIdPenyewaan());
            System.out.println("Tanggal transaksi \t :" + penyewaan.getTanggal());
            System.out.println("Penjaga \t \t : " + penyewaan.getPenjaga().getName());
            System.out.println("Pengunjung \t \t : " + penyewaan.getPengunjung().getName());
            System.out.println("=========================");
            ArrayList<DetailPenyewaan> detailPenyewaans = penyewaan.getDetailPenyewaans();
            for (DetailPenyewaan rn : detailPenyewaans) {
                System.out.println("Nama kendaraan \t \t : " + rn.getKendaraan().getNamaKendaraan());
                System.out.println("Jumlah beli \t \t : " + rn.getJumlahBeli());
                System.out.println("Subtotal \t \t : " + rn.getSubTotal());
            }
            System.out.println("=========================");
            System.out.println("Total \t \t : " + penyewaan.getTotal());
        }
    }

}
