public class NodeObat {
    private Obat obat;
    private NodeObat NextReference;

    public NodeObat(){

    }
    public NodeObat(Obat obat) {
        this.obat = obat;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public NodeObat getNextReference() {
        return NextReference;
    }

    public void setNextReference(NodeObat nextReference) {
        NextReference = nextReference;
    }
}
