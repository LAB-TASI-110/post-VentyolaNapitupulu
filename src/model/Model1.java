package model;

public class Model1 {
    private String kodeKota;
    private String namaKota;
    private double beratButet;
    private int hargaPerKg;
    private boolean isLuarPulau;

    public Model1(String kodeKota, double beratButet) {
        this.kodeKota = kodeKota.toUpperCase();
        this.beratButet = beratButet;
        setDataKota();
    }

    private void setDataKota() {
        switch (this.kodeKota) {
            case "MDN":
                this.namaKota = "Medan";
                this.hargaPerKg = 8000;
                this.isLuarPulau = false;
                break;
            case "BLG":
                this.namaKota = "Balige";
                this.hargaPerKg = 5000;
                this.isLuarPulau = false;
                break;
            case "JKT":
                this.namaKota = "Jakarta";
                this.hargaPerKg = 12000;
                this.isLuarPulau = true;
                break;
            case "SBY":
                this.namaKota = "Surabaya";
                this.hargaPerKg = 13000;
                this.isLuarPulau = true;
                break;
        }
    }

    public double getBeratUcok() {
        return 1.5 * beratButet;
    }

    public double getTotalBerat() {
        return beratButet + getBeratUcok();
    }

    public double hitungTotalOngkos() {
        double totalBerat = getTotalBerat();
        double ongkos = totalBerat * hargaPerKg;
        
        // Diskon 10% jika total berat > 10kg
        if (totalBerat > 10) {
            ongkos *= 0.9;
        }
        return ongkos;
    }

    public String getInformasiPromo() {
        String promo = "";
        if (getTotalBerat() > 10) promo += "Diskon 10%";
        if (isLuarPulau) promo += (promo.isEmpty() ? "" : " & ") + "Asuransi Gratis";
        
        return promo.isEmpty() ? "Tidak ada promo" : promo;
    }

    public String getNamaKota() { return namaKota; }
    public double getBeratButet() { return beratButet; }
}