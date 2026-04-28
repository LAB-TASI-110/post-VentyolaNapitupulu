package model;

public class Model2 {
    private String namaBarang;
    private int stok;

    public Model2(String namaBarang, int stok) {
        this.namaBarang = namaBarang;
        this.stok = stok;
    }

    /**
     * Menentukan kategori berdasarkan pola gambar:
     * Kategori A: Pakaian (Dasi, Rok)
     * Kategori B: Sembako (Gula, Minyak)
     */
    public String getKategori() {
        String nama = namaBarang.toLowerCase();
        if (nama.contains("dasi") || nama.contains("rok")) {
            return "A"; // Pakaian
        } else if (nama.contains("gula") || nama.contains("minyak")) {
            return "B"; // Sembako
        }
        return "Lainnya";
    }

    public int getStok() {
        return stok;
    }

    public String getNamaBarang() {
        return namaBarang;
    }
}