//Nicole Chaney

public class DLink<T> implements IList<T>{
    IDLink<T> head = null;
    IDLink<T> tail = null;
    IDLink<T> current = null;
    int size = 0;
    boolean firsttime = true;


    public void insert(int idx, T v) {
        boolean appendcheck = false;
        if (size ==0) {
            IDLink<T> first = new Node(v, null, null);
            first.setPrev(first);
            first.setNext(first);
            head = first;
            tail = first;
            current = first;
            firsttime = false;
        }
        else{
            if (idx == size) {
                append(v);
                appendcheck = true;
            }
            else {
                IDLink<T> head = this.head;
                if (idx == 0) {
                    head.setNext(head);
                    IDLink<T> tc = new Node(v, null, head);
                    tc.setPrev(tc);
                    head.setPrev(tc);
                    this.head = tc;
                }
                else if (idx == 1){
                    IDLink<T> tc = new Node(v, this.head, this.head.getNext());
                    this.head.setNext(tc);
                }
                else {
                    for (int i = 0; i < size; i++) {
                        if (i == idx) {
                            IDLink<T> tc = new Node(v, head.getPrev(), head);
                            tc.getPrev().setNext(tc);
                            tc.getNext().setPrev(tc);
                        } else {
                            head = head.getNext();
                        }
                    }

                }
            }
        }
        if (!appendcheck){
        size++;}


    }


    public void append(T v) {
        IDLink<T> first = new Node(v, null, null);
        if (size == 0) {

            first.setPrev(first);
            first.setNext(first);
            head = first;
            tail = head;
            current = head;
            firsttime = false;
        }
        else{

            first.setValue(v);
            first.setPrev(tail);
            tail = first;
            first.setNext(first);
            first.getPrev().setNext(first);
        }
        size++;

    }

    public void remove() {
        if (current == head){
            head = current.getNext();
            head.setPrev(head);
            current = head;
        }
        else if (current == tail){
            current.getPrev().setNext(current.getPrev());
            current = current.getPrev();
            tail = current;
        }
        else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current = current.getPrev();
        }
        size--;
    }

    public void remove(int idx) {
        IDLink<T> tc = head;
        if(idx == 0) {
            head.getNext().setPrev(head.getNext());
            head = head.getNext();
        }
        else{
            for (int i = 0; i< idx; i++){
                tc = tc.getNext();
            }
            tc.getPrev().setNext(tc.getNext());
            tc.getNext().setPrev(tc.getPrev());
        }
        size--;

    }

    public void move(int sidx, int didx) {
        T temp = fetch(sidx);
        remove(sidx);
        insert(didx, temp);

    }

    public T fetch() {
        return current.getValue();
    }

    public T fetch(int idx) {
        IDLink<T> tc = head;
        for (int i = 0; i< idx; i++){
            tc = tc.getNext();
            }
        return tc.getValue();
    }



    public void next() {
        current = current.getNext();
    }

    public void prev() {
        current = current.getPrev();
    }

    public void jumpToTail() {
        current = tail;
    }

    public void jumpToHead() {
        current = head;
    }

    public int size() {
        return size;
    }
}
