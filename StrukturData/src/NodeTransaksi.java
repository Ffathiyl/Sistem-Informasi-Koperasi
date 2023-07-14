public class NodeTransaksi {
    private Transaksi transaksi;
    private NodeTransaksi NextReference;

    public NodeTransaksi(){

    }
    public NodeTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public NodeTransaksi getNextReference() {
        return NextReference;
    }

    public void setNextReference(NodeTransaksi nextReference) {
        NextReference = nextReference;
    }
}
