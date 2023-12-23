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
    HashMap<String, Kendaraan> kendaraans = new HashMap<>();
    ArrayList<Penyewaan> penyewaans = new ArrayList<>();
    HashMap<String, Pengunjung> pengunjungs = new HashMap<>();
    HashMap<String, Penjaga> penjagas = new HashMap<>();

    public void setUp() {
        Kendaraan kendaraan1 = new Kendaraan();
        Kendaraan kendaraan2 = new Kendaraan();
        kendaraan1
                .setIdKendaraan("A1")
                .setNamaKendaraan("Roda Dua")
                .setTarifKendaraan(3000);

        kendaraan2
                .setIdKendaraan("B1")
                .setNamaKendaraan("Roda Empat")
                .setTarifKendaraan(5000);

        kendaraans.put(kendaraan1.getIdKendaraan(), kendaraan1);
        kendaraans.put(kendaraan2.getIdKendaraan(), kendaraan2);

        Pengunjung pengunjung1 = new Pengunjung();
        Pengunjung pengunjung2 = new Pengunjung();
        pengunjung1
                .setIdPengunjung("01")
                .setNama("Doraemon");

        pengunjung2.setIdPengunjung("02")
                .setNama("Nobita");

        pengunjungs.put(pengunjung1.getIdPengunjung(), pengunjung1);
        pengunjungs.put(pengunjung2.getIdPengunjung(), pengunjung2);

        Penjaga penjaga1 = new Penjaga();
        Penjaga penjaga2 = new Penjaga();
        penjaga1
                .setIdPenjaga("01")
                .setNama("Giant");

        penjaga2
                .setIdPenjaga("02")
                .setNama("Suneo");

        penjagas.put(penjaga1.getIdPenjaga(), penjaga1);
        penjagas.put(penjaga2.getIdPenjaga(), penjaga2);
    }

    public void lihatDaftarKendaraan() {
        System.out.println();
        System.out.println("====== Tarif Parkir Kendaraan ======");
        System.out.println("========== ICOONIC MALL ==========");
        for (Map.Entry<String, Kendaraan> kendaraan : kendaraans.entrySet()) {
            String key = kendaraan.getKey();
            Kendaraan tKendaraan = kendaraan.getValue();
            if (tKendaraan != null) {
                System.out.println("Kode Kendaraan \t :" + key);
                System.out.println("Jenis Kendaraan  :" + tKendaraan.getNamaKendaraan());
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
        return pengunjungs.get(idPengunjung);
    }

    public void transaksi(double durasiJam) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DetailPenyewaan> detailPenyewaans = new ArrayList<>();
        try {
            String lanjut;
            do {
                System.out.println();
                System.out.println();
                System.out.print("Silahkan masukkan kode kendaraan\t: ");
                String kodeKendaraan = scanner.nextLine();
                System.out.print("Waktu Masuk\t: ");
                double waktuMasuk = Double.parseDouble(scanner.nextLine());
                System.out.print("Waktu Keluar\t: ");
                double waktuKeluar = Double.parseDouble(scanner.nextLine());

                DetailPenyewaan detailPenyewaan = new DetailPenyewaan();
                Kendaraan kendaraan = getKendaraan(kodeKendaraan);

                if (kendaraan != null) {
                    int jumlah = 1;
                    detailPenyewaan.setIdDetailPenyewaan("rn" + jumlah);
                    detailPenyewaan.setKendaraan(kendaraan);
                    detailPenyewaan.setTarifSewa(kendaraan.getTarifKendaraan());
                    detailPenyewaan.setJumlahBeli(jumlah);
                }

                double durasi = waktuKeluar - waktuMasuk;
                int biayaSewa = hitungBiaya(durasi, kodeKendaraan);
                double tarifSewa = detailPenyewaan.getTarifSewa();
                int durasiJam1 = (int) durasi;
                int subTotal = durasiJam1 * (int) tarifSewa;
                int totalBiaya = subTotal + biayaSewa;
                detailPenyewaan.setTotalBiaya(totalBiaya);

                double durasiMenit = durasi - (double) durasiJam1;
                int durasiMenitFix = (int) (durasiMenit * 100);

                detailPenyewaans.add(detailPenyewaan);

                System.out.println();
                System.out.print("Silahkan masukkan kode pengunjung\t: ");
                String kodePengunjung = scanner.nextLine();
                Pengunjung pengunjung = getPengunjung(kodePengunjung);

                System.out.println();
                System.out.print("Silahkan masukkan kode penjaga\t: ");
                String kodePenjaga = scanner.nextLine();
                Penjaga penjaga = getPenjaga(kodePenjaga);

                Penyewaan penyewaan = new Penyewaan();
                penyewaan.setIdPenyewaan("P" + kodeKendaraan + kodePengunjung + kodePenjaga);
                penyewaan.setPengunjung(pengunjung);
                penyewaan.setPenjual(penjaga);
                penyewaan.setDetailPenyewaans(detailPenyewaans);
                penyewaan.setTanggal(LocalDate.now());
                penyewaans.add(penyewaan);

                System.out.println();
                System.out.println("==== Transaksi Berhasil ====");
                System.out.println("Kode Penyewaan \t\t : " + penyewaan.getIdPenyewaan());
                System.out.println("Nama Pengunjung \t : " + penyewaan.getPengunjung().getNama());
                System.out.println("Nama Penjaga \t\t : " + penyewaan.getPenjaga().getNama());
                System.out.println("Tanggal Penyewaan \t : " + penyewaan.getTanggal());
                System.out.println(" ");
                System.out.println("Detail Penyewaan \t :");

                StringBuilder output = new StringBuilder();
                for (DetailPenyewaan detail : detailPenyewaans) {

                    if (kendaraan != null) {
                        output.append("Kode Kendaraan \t\t : ").append(kendaraan.getIdKendaraan()).append("\n");
                        output.append("Jenis Kendaraan \t : ").append(kendaraan.getNamaKendaraan()).append("\n");
                        output.append("Tarif Sewa \t\t : Rp").append(detail.getTarifSewa()).append(",00\n");
                        output.append("Waktu Masuk \t\t : ").append(waktuMasuk).append("\n");
                        output.append("Waktu Keluar \t\t : ").append(waktuKeluar).append("\n");
                        output.append("Durasi \t\t\t :  ").append(durasiJam1).append(" jam ").append(durasiMenitFix)
                                .append(" menit\n");
                        output.append("Total Biaya \t\t : Rp").append(totalBiaya).append(",00\n");
                        output.append("\n");

                    } else {
                        output.append("Detail kendaraan tidak ditemukan.\n");
                    }

                }
                System.out.println(output);

                System.out.print("Apakah ingin melanjutkan transaksi (Y/N)? ");
                lanjut = scanner.nextLine().toUpperCase();
                switch (lanjut) {
                    case "Y":
                        break;

                    case "N":
                        break;

                    default:
                        break;
                }
            } while (lanjut.equals("Y"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public int hitungBiaya(double durasi, String kodeKendaraan) {
        int durasiJam = (int) durasi;
        double durasiMenit = durasi - (double) durasiJam;
        int biayaSewa = 0;

        if (kodeKendaraan.equals("A1")) {
            double durasiSewa = durasiMenit / 0.10;
            int durasiSewa1 = (int) durasiSewa;
            biayaSewa = durasiSewa1 * 500;

        } else if (kodeKendaraan.equals("B1")) {
            double durasiSewa = durasiMenit / 0.06;
            int durasiSewa1 = (int) durasiSewa;
            biayaSewa = durasiSewa1 * 500;
        }
        return biayaSewa;
    }
}