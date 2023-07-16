import org.w3c.dom.Node;

public class SLinkedListTransaksi {
    private NodeTransaksi head;
    private NodeTransaksi tail;
    private int size;

    public SLinkedListTransaksi() {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void addFirst(NodeTransaksi nodeTransaksi){
        if(!isEmpty()){
            nodeTransaksi.setNextReference(head);
            head = nodeTransaksi;
        } else {
            nodeTransaksi.setNextReference(null);
            tail = nodeTransaksi;
            head = nodeTransaksi;
        }
        ++this.size;
    }

    public int getSize(){
        return size;
    }

    public void addLast(NodeTransaksi nodeTransaksi){
        if(!isEmpty()){
            nodeTransaksi.setNextReference(null);
            this.tail.setNextReference(nodeTransaksi);
            tail = nodeTransaksi;
        } else {
            nodeTransaksi.setNextReference(null);
            tail = nodeTransaksi;
            head = nodeTransaksi;
        }
        ++this.size;
    }

    public void display(){
        NodeTransaksi pointer;
        if (isEmpty()){
            System.out.println("Antrian Kosong!");
            return;
        }

        pointer = head;

        System.out.println("Size : "+this.size);

        while(pointer != null){
            System.out.println(pointer.getTransaksi());
            pointer = pointer.getNextReference();
        }
    }

    public void deleteHead() {
        NodeTransaksi pointer;

        pointer = head;
        head = pointer.getNextReference();
        pointer = null;
        size--;
    }

    public void deletetail(){
        NodeTransaksi pointer = head;

        while(pointer.getNextReference() != tail){
            pointer = pointer.getNextReference();
        }
        tail = pointer;
        tail.setNextReference(null);
        size--;
    }

    public void insertTengah(NodeTransaksi nodebaru, String insertAfter){
        NodeTransaksi pointer = head;
        while(pointer.getNextReference() != null){
            if(pointer.getTransaksi().equals(insertAfter)){
                nodebaru.setNextReference(pointer.getNextReference());
                pointer.setNextReference(nodebaru);
                break;
            } else {
                pointer = pointer.getNextReference();
            }
        }
    }

    public NodeTransaksi getNode(int index) {
        NodeTransaksi pointer;
        int i;

        if (isEmpty()) return null;

        pointer = head;
        i = 0;
        while (pointer != null) {
            if (i == index) return pointer;
            i++;
            pointer = pointer.getNextReference();
        }
        return null;
    }


}
