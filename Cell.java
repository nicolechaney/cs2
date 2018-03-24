//Nicole Chaney

public class Cell<T> {
    T value;
    Cell<T> ptr;

    public Cell(T v, Cell<T> p){
        value = v;
        ptr = p;
    }
    public T getValue(){
        return value;
    }
    public Cell<T> getPointer(){
        return ptr;
    }
    public void setPtr(Cell<T> p){
        ptr = p;
    }

}
