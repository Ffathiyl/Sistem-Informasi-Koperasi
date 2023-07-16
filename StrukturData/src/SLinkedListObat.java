import org.w3c.dom.Node;

public class SLinkedListObat {
    Obat obat = new Obat();
    private NodeObat head;
    private NodeObat tail;
    private int size;
    private int Id = 0;
    public SLinkedListObat(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void addFirst(NodeObat nodeObat){
        if(!isEmpty()){
            nodeObat.setNextReference(head);
            head = nodeObat;
        } else {
            nodeObat.setNextReference(null);
            tail = nodeObat;
            head = nodeObat;
        }
        ++this.size;
    }

    public int getSize(){
        return size;
    }

    public void addLast(NodeObat nodeObat){
        if(!isEmpty()){
            nodeObat.setNextReference(null);
            this.tail.setNextReference(nodeObat);
            tail = nodeObat;
        } else {
            nodeObat.setNextReference(null);
            tail = nodeObat;
            head = nodeObat;
        }
        ++this.size;
    }

    public void display(){
        NodeObat pointer;
        if (isEmpty()){
            System.out.println("List masih kosong");
            return;
        }

        pointer = head;

        System.out.println("Size : "+this.size);

        while(pointer != null){
            System.out.println(pointer.getObat());
            pointer = pointer.getNextReference();
        }
    }

    public int idObat(){
        int id = 0;
        if(size == 0){
            obat.setIdObat(Id);
            id = 1;
        } else {
            obat.setIdObat(Id);
            id = size + 1;
        }
        return id;
    }

    public void deleteHead() {
        NodeObat pointer;

        pointer = head;
        head = pointer.getNextReference();
        pointer = null;
        size--;
    }

    public void deletetail(){
        NodeObat pointer = head;

        while(pointer.getNextReference() != tail){
            pointer = pointer.getNextReference();
        }
        tail = pointer;
        tail.setNextReference(null);
        size--;
    }

    public void insertTengah(NodeObat nodebaru, NodeObat insertAfter){
        NodeObat pointer = head;
        while(pointer.getNextReference() != null){
            if(pointer == insertAfter){
                nodebaru.setNextReference(pointer.getNextReference());
                pointer.setNextReference(nodebaru);
                break;
            } else {
                pointer = pointer.getNextReference();
            }
        }
    }

    public NodeObat getNode(int index) {
        NodeObat pointer;
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

    public NodeObat searchID(int id) {
        NodeObat pointer = head;

        while (pointer != null) {
            if (pointer.getObat().getIdObat() == id) {
                return pointer;
            }
            pointer = pointer.getNextReference();
        }

        System.out.println("Obat dengan ID " + id + " tidak ditemukan");
        return null;
    }

    public void update(Obat oldData, Obat newData) {
        if (head == null) {
            System.out.println("LinkedList kosong.");
        } else {
            NodeObat pointer = head;
            boolean found = false;
            while (pointer != null) {
                if (pointer.getObat()==oldData){
                    pointer.setObat(newData);
                    found = true;
                    System.out.println("Data " + oldData + " berhasil diubah menjadi " + newData + ".");
                    break;
                }
                pointer = pointer.getNextReference();
            }
            if (!found) {
                System.out.println("Data " + oldData + " tidak ditemukan dalam LinkedList.");
            }
        }
    }
}
