//Nicole Chaney

public class RingQueue<T> implements IQueue<T>{
    T[] queue = (T[]) new Object[0];
    int pointer=0;
    int size = 0;
    public T dequeue(){
        size--;
        if(pointer == queue.length){
            return null;
        }
        else{
            T temp = queue[pointer];
            pointer++;
            return temp;

        }
    }

    public boolean isEmpty(){
        if (size ==0){
            return true;
        }
        else{
            return false;
        }
    }

    public void enqueue(T v){
        size++;
        T[] temp = (T[]) new Object[queue.length+1];
        for (int i =0; i <queue.length;i++){
            temp[i] = queue[i];
        }
        temp[queue.length] = v;
        queue = temp;

    }
}
