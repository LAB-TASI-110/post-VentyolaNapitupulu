package driver;

import model.Model3; // Mengimpor abstract class dari package model
import java.util.*;

// Class konkrit untuk merepresentasikan item kafetaria
class ItemKafetaria extends Model3 {
    public ItemKafetaria(String nama, double harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public String getKategori() {
        return "Menu Utama";
    }
}

public class Driver3 {
    public static void main(String[] args) {
        // Menggunakan Try-with-Resources agar Scanner otomatis tertutup dengan aman
        try (Scanner sc = new Scanner(System.in)) {
            
            // 1. Inisialisasi Database Mahasiswa (HashMap)
            Map<String, String> dataMahasiswa = new HashMap<>();
            dataMahasiswa.put("11S21001", "Ventyola");
            dataMahasiswa.put("11S21002", "Anak IT Del");

            // 2. Inisialisasi Menu Digital (ArrayList)
            List<Model3> menu = new ArrayList<>();
            menu.add(new ItemKafetaria("Nasi Goreng", 15000, 5));
            menu.add(new ItemKafetaria("Ayam Geprek", 18000, 3));
            menu.add(new ItemKafetaria("Teh Manis", 5000, 10));

            // 3. Validasi Login Mahasiswa
            System.out.println("=== SISTEM KAFETARIA IT DEL ===");
            while (true) {
                System.out.print("Masukkan NIM: ");
                String nim = sc.nextLine();
                
                if (dataMahasiswa.containsKey(nim)) {
                    System.out.println("Login Berhasil! Halo, " + dataMahasiswa.get(nim));
                    break;
                } else {
                    System.out.println("masukkan id yang benar");
                }
            }

            // 4. Proses Pemesanan
            double totalBelanja = 0;
            boolean isOrdering = true;

            while (isOrdering) {
                System.out.println("\n--- DAFTAR MENU DIGITAL ---");
                for (int i = 0; i < menu.size(); i++) {
                    Model3 m = menu.get(i);
                    System.out.printf("%d. %s | Rp%.0f | Stok: %d\n", 
                                      (i + 1), m.getNama(), m.getHarga(), m.getStok());
                }
                System.out.println("0. Selesai & Bayar");
                System.out.print("Pilih nomor menu: ");

                if (sc.hasNextInt()) {
                    int pilihan = sc.nextInt();
                    
                    if (pilihan == 0) {
                        isOrdering = false;
                    } else if (pilihan > 0 && pilihan <= menu.size()) {
                        Model3 itemDipilih = menu.get(pilihan - 1);
                        
                        // Validasi stok real-time
                        if (itemDipilih.getStok() > 0) {
                            itemDipilih.kurangiStok();
                            totalBelanja += itemDipilih.getHarga();
                            System.out.println("Berhasil menambahkan " + itemDipilih.getNama());
                        } else {
                            System.out.println("MAAF, STOK HABIS! Silakan pilih menu lain.");
                        }
                    } else {
                        System.out.println("Pilihan tidak tersedia.");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    sc.next(); // Clear input yang salah
                }
            }

            // 5. Output Final Transparan
            System.out.println("\n---");
            System.out.println("TOTAL BELANJA: Rp" + totalBelanja);
            System.out.println("Terima kasih sudah memesan!");
            System.out.println("---");

        } // Scanner otomatis ditutup di sini oleh Java (Safe & Clean)
    }
}