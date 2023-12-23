import java.util.Scanner;
import controller.ParkirController;

public class App {

    public static void main(String[] args) {
        ParkirController parkirController = new ParkirController();
        parkirController.setUp();
        boolean lanjut = true;
        Scanner scanner = new Scanner(System.in);

        while (lanjut) {
            tampilkanMenu();
            System.out.print("Pilih Menu: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    parkirController.lihatDaftarKendaraan();
                    break;
                case "2":
                    parkirController.transaksi(0);
                    break;
                default:
                    lanjut = false;
                    break;
            }
        }

        System.out.println("Sampai Jumpa");
        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("=== Parkir Icoonic Mall ===");
        System.out.println("1. Lihat tarif Parkir");
        System.out.println("2. Transaksi");

    }
}
