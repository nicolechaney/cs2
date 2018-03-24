//Nicole Chaney

public class Edge<N,W> implements IEdge<N,W>{
// Implementors should implement a construct that takes in the
// source, destination, and weight
Node<N> source;
Node<N> destination;
W weight;
/**
 * The source node of the edge
 * @return the source node
 */
 public Edge(Node<N> sourcey, Node<N> dest, W heavy) {
source = sourcey;
destination = dest;
weight = heavy;
 }

public INode<N> getSource(){
  return source;
}

/**
 * The destination node of the edge
 * @return the destination node
 */
public INode<N> getDestination(){
  return destination;
}

/**
 * The weight of the edge
 * @return the weight
 */
public W getWeight(){
  return weight;
}

/**
 * Test for equality of two edges.
 * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
 * and this.dst == o.dst
 * @param o the other edge
 * @return true if the edges are the same
 */
public boolean equals(Object o){
  Edge compared = (Edge) o;
  if (compared.getSource().equals(source) && compared.getDestination().equals(destination)){
    return true;
  }
  else{
    return false;
  }
}

}
