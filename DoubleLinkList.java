//Nicole Chaney

/**
 * List interface based on the 11/29 discussion of what a program using lists might
 * need to do. This will be our definition for the list ADT this block.
 */
public class DoubleLinkList<T> implements IList<T> {
    int listsize;
    int current;
    IDLink<T> head;
    IDLink<T> tail;


    public DoubleLinkList(){
        head = null;
        tail = null;
        }
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
        IDLink<T> Dcell = new DCell();
        IDLink<T> after = null;
        Dcell.setValue(v);
        if (listsize == idx){
            append(v);
        }
        else{
            for(int i = 0; i <= idx; i++){
                if  (i == 0){
                    after = head;
                }
                else{
                    after = after.getNext();
                }
            }
            IDLink<T> before = after.getPrev();
            before.setNext(Dcell);
            after.setPrev(Dcell);
            Dcell.setNext(after);
            Dcell.setPrev(before);
        }
        listsize++;
    }

    /**
     * Adds an item to the end of list. Called 'Add' in class, but more usually called
     * append in other libraries. Moves <i>current</i> to the end of the list.
     * @param v Item to add
     */
    public void append(T v){
        IDLink<T> node = new DCell();
        node.setValue(v);
        if (listsize == 0){
            node.setPrev(node);
            node.setNext(node);
            tail = node;
            head = node;
        }
        else{
            node.setPrev(tail); //sets old node(stored in tail) as tail for new node
            node.setNext(node); // next is equal to itself cause its the newest node (points to itself)
            tail.setNext(node); //tail is old node, node references to new node
            tail = node;
        }
        listsize++;
        current = listsize -1;
    }

    /**
     * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
     * the previous item in the list, if such element exists.
     */
    public void remove(){
        remove(current);
        prev();
        }

    /**
     * Removes the item at a specific index
     * @param idx index of item to remove
     */
    public void remove(int idx){
        IDLink<T> after = null;
        IDLink<T> delete = null;
        IDLink<T> before = null;
        for (int i = 0; i <= idx; i++){
            if(i == 0){
                delete = head; // sets the deleted equal to head to initialize it
            }
            else{
                delete = delete.getNext(); // bounces through list until it reaches idx, sets delete to idx, then stops
            }

        }
        if(idx == 0){
            after = delete.getNext(); //sets after to the node after the deleted
            after.setPrev(after); //then sets after's previous equal to itself since its now the first node
            head = after; // after is the head now because the head was deleted
        }
        else{
            after = delete.getNext(); // after equals node after the one to be deleted
            before = delete.getPrev(); // before equals node before  one to be deleted
            before.setNext(after); // sets node after before to after, completely skipping over deleted
            after.setPrev(before); // sets node before after to before, completely skipping over deleted
        }
        if(current > idx){ // shifts everything down because a node was removed
            current--;
        }
        listsize--; // makes the list size smaller since a node was removed
        }

    /**
     * Changes the location of an existing element in the list
     * @param sidx - The initial index for the element to move
     * @param didx - The final index for the element to move
     */
    public void move(int sidx, int didx){
        IDLink<T> cell = null;
        for (int i = 0;i <= sidx;i++){
            if (i == 0){
                cell = head;
            }
            else{
                cell = cell.getNext();
            }
        }
        remove(sidx);
        insert(didx, cell.getValue());

        }

    /**
     * Fetches the value at the <i>current</i> index in the list.
     * @return the requested item
     */
    public T fetch() {
        IDLink<T> fetch_cell = null;
        for(int i = 0; i <= current; i++){
            if (i == 0){
                fetch_cell = head;
            }
            else{
                fetch_cell = fetch_cell.getNext();
            }
        }
        return fetch_cell.getValue();
        }

    /**
     * Fetches the value at a specific index in the list.
     * @param idx index of the item to return
     * @return the requested item
     */
    public T fetch(int idx){
        IDLink<T> fetch = null;
        for(int i = 0; i <= idx; i++){
            if (i == 0){
                fetch = head;
            }
            else{
                fetch = fetch.getNext();
            }
        }
        return fetch.getValue();
        }

    /**
     * Advances the <i>current</i> index to the next index, if possible.
     */
    public void next(){
        if (current < listsize-1){
            current++;
        }
        }

    /**
     * Advances the <i>current</i> index to the previous index, if possible.
     */
    public void prev(){
        if (current > 0){
            current--;
        }
        }

    /**
     * Advances the <i>current</i> to the tail element
     */
    public void jumpToTail(){
        current = listsize -1;
        }

    /**
     * Advances the <i>current</i> to the head element
     */
    public void jumpToHead(){
        current = 0;
        }

    /**
     * Returns the number of elements in the list
     */
    public int size(){
        return listsize;
        }
}
