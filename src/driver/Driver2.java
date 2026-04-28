package driver;

import model.Model2;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 1: Jumlah total data (N)
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Model2[] daftarBarang = new Model2[n];

        // Input 2: Deret stok (Format: Nama_Barang Jumlah_Stok)
        for (int i = 0; i < n; i++) {
            String nama = sc.next();
            int stok = sc.nextInt();
            daftarBarang[i] = new Model2(nama, stok);
        }

        // Input 3: Kode kategori yang dicari (Misal: A atau B)
        String kategoriDicari = sc.next();

        int totalStok = 0;
        System.out.println("\n--- LAPORAN STOK GUDANG ---");
        System.out.println("Kategori Dicari: " + kategoriDicari);
        
        for (Model2 barang : daftarBarang) {
            if (barang.getKategori().equalsIgnoreCase(kategoriDicari)) {
                totalStok += barang.getStok();
                System.out.println("- " + barang.getNamaBarang() + ": " + barang.getStok() + " pcs");
            }
        }

        System.out.println("---------------------------");
        System.out.println("TOTAL STOK KATEGORI " + kategoriDicari + ": " + totalStok + " pcs");
        
        sc.close();
    }
}