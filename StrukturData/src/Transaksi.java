public class Transaksi {
    private String pelanggan;
    private Obat obat;
    private int jumlah;
    private double hargaTotal;

    public Transaksi(String pelanggan, Obat obat, int jumlah, double hargaTotal) {
        this.pelanggan = pelanggan;
        this.obat = obat;
        this.jumlah = jumlah;
        this.hargaTotal = hargaTotal;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(double hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
}
