public class Obat {
    private int IdObat;
    private String namaObat;
    private String merkObat;
    private double harga;
    private int stock;

    public Obat(int idObat, String namaObat, String merkObat, double harga, int stock) {
        IdObat = idObat;
        this.namaObat = namaObat;
        this.merkObat = merkObat;
        this.harga = harga;
        this.stock = stock;
    }
    public Obat(){

    }

    public int getIdObat() {
        return IdObat;
    }

    public void setIdObat(int idObat) {
        IdObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getMerkObat() {
        return merkObat;
    }

    public void setMerkObat(String merkObat) {
        this.merkObat = merkObat;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return IdObat + "\t\t" + namaObat + "\t\t\t" +
                merkObat + "\t\t\t" + harga + "\t\t\t" +
                stock;
    }
}
