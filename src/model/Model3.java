package model;

// Abstraction: Kerangka dasar produk
public abstract class Model3 {
    private String nama;
    private double harga;
    private int stok;

    public Model3(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Encapsulation: Getter & Setter
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    public void kurangiStok() {
        if (this.stok > 0) this.stok--;
    }

    // Method abstrak yang harus diimplementasikan subclass
    public abstract String getKategori();
}

// Implementasi konkrit untuk item di kafetaria
class ItemKafetaria extends Model3 {
    private String kategori;

    public ItemKafetaria(String nama, double harga, int stok, String kategori) {
        super(nama, harga, stok);
        this.kategori = kategori;
    }

    @Override
    public String getKategori() {
        return this.kategori;
    }
}