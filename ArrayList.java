//Nicole Chaney

public class ArrayList<T> implements  IList<T> {
    T[] list = (T[]) new Object[0];
    int current = 0;


    public void insert(int idx, T v) {
        T[] t = (T[]) new Object[list.length+1];
        for(int i=0; i<list.length; i++) {
            if(i==idx) {
                t[i+1] = list[i];
                t[i] = v;

            } else if(i<idx) {
                t[i] = list[i];
            }else {
                t[i+1] = list[i];
            }
        }
        list = t;
    }

    public void append(T v) {
        T[] t = (T[]) new Object[list.length+1];
        for(int i=0; i<list.length; i++) {
            t[i] = list[i];
        }
        t[list.length] = v;
        list = t;

    }

    public void remove() {
        T[] t = (T[]) new Object[list.length-1];
        for(int i=list.length-1; i>-1; i--) {
            if(i==current) {
            } else if(i<current) {
                t[i] = list[i];
            }else {
                t[i-1] = list[i];
            }
        }
        list = t;
        prev();
    }


    public void remove(int idx) {
        T[] t = (T[]) new Object[list.length-1];
        for(int i=list.length-1; i>-1; i--) {
            if(i==idx) {
            } else if(i<idx) {
                t[i] = list[i];
            }else {
                t[i-1] = list[i];
            }
        }
        list = t;

    }

    public void move(int sidx, int didx) {
        T temp = list[sidx];
        remove(sidx);
        insert(didx, temp);
    }

    public T fetch() {
        return list[current];
    }

    public T fetch(int idx) {
        return list[idx];
    }

    public void next() {
        if (current == list.length-1){
        }
        else{
            current++;
        }
    }

    public void prev() {
        if (current == 0){

        }
        else{
            current--;
        }

    }

    public void jumpToTail() {
        current = list.length-1;

    }

    public void jumpToHead() {
        current = 0;

    }

    public int size() {
        return list.length;
    }
}
