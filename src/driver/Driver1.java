package driver;

import model.Model1;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String inputKota = sc.next();
            if (inputKota.equalsIgnoreCase("END")) break;

            double inputBerat = sc.nextDouble();

            // Membuat objek dari Model1
            Model1 transaksi = new Model1(inputKota, inputBerat);

            // Menampilkan Output sesuai Struk yang diminta
            System.out.println("=== STRUK PEMBAYARAN DEL-EXPRESS ===");
            System.out.println("Kota tujuan       : " + transaksi.getNamaKota());
            System.out.printf("Berat paket Butet : %.2f kg\n", transaksi.getBeratButet());
            System.out.printf("Berat paket Ucok  : %.2f kg\n", transaksi.getBeratUcok());
            System.out.printf("Total berat       : %.2f kg\n", transaksi.getTotalBerat());
            System.out.printf("Total ongkos kirim: Rp %.0f\n", transaksi.hitungTotalOngkos());
            System.out.println("Promo yang didapat: " + transaksi.getInformasiPromo());
            System.out.println("------------------------------------\n");
        }
        sc.close();
    }
}