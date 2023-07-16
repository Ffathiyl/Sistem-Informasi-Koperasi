public class QueueTransaksi {
    SLinkedListTransaksi transaksi;
    private int size;

    public QueueTransaksi() {
        this.size = size;
        transaksi = new SLinkedListTransaksi();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void enqueue (NodeTransaksi newElements){
        System.out.println("enqueu : " + newElements.getTransaksi().getObat());
        transaksi.addLast(newElements);
        size++;
    }

    public Transaksi dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        Transaksi dequeuedNode = transaksi.getNode(0).getTransaksi();
        System.out.println("Dequeue : " + dequeuedNode);
        transaksi.deleteHead();
        size--;
        return dequeuedNode;
    }

    public Transaksi peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return transaksi.getNode(0).getTransaksi();
    }

    public void display(){
        transaksi.display();
    }
}
