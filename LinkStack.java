//Nicole Chaney

import sun.awt.image.ImageWatched;

public class LinkStack<T> implements IStack<T> {
    Cell<T> top= null;
    int size;

    public void push(T v){
        Cell<T> n = new Cell<>(v, top);
        top = n;
        size++;
    }

    public T pop(){
        if (size == 0){
            return null;
        }
        T temp = top.getValue();
        top = top.getPointer();
        size--;
        return temp;
    }

    public int getSize(){
        return  size;
    }

    public T checktop(){
        return top.getValue();
    }

    public ArrayList<T> getStack(){
        int s = size;
        LinkStack<T> reverse = new LinkStack<>();
        for (int j = 0; j < s; j++){
            reverse.push(pop());
        }
        ArrayList<T> arr =new ArrayList<>();
        for (int i = 0; i< s; i++){
            arr.append(reverse.pop());
        }
        return arr;
    }

    public ArrayList<T> getStackr(){
        int s = size;
        ArrayList<T> arr =new ArrayList<>();
        for (int i = 0; i< s; i++){
            arr.append(pop());
        }
        return arr;
    }
}
