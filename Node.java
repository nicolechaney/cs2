//Nicole Chaney

public class Node<N> implements INode<N>{

N value;
public Node(N nodevalue) {
    value = nodevalue;
}
/**
 * Updates the value at the node
 * @param v new value
 */
public void setValue(N v){
value = v;
}
/**
 * Fetches the value at the node
 * @return the current value
 */
public N getValue(){
  return value;
}

}
