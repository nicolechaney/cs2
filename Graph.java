//Nicole Chaney

public class Graph<N,W> implements IGraph<N,W>{
  DoubleLinkList<Node> nodes;
  DoubleLinkList<Edge> edges;
  N value;
  /**
   * Gets an array of all the nodes in the graph
   * @return the node set
   */
   public Graph(){
     value = null;
     nodes = new DoubleLinkList<Node>();
     edges = new DoubleLinkList<Edge>();
   }
  public INode<N>[] getNodeSet(){
    INode<N>[] temp = (INode<N>[]) new Node[nodes.size()];
    for(int i = 0; i < temp.length; i++){
      temp[i] = nodes.fetch(i);
    }
    return temp;
  }

  /**
   * An array of the neighbors of a node
   * @param n the node
   * @return neighbors of n
   */
  public INode<N>[] getNeighbors(INode<N> n){
    DoubleLinkList<INode> neighbors = new DoubleLinkList();
    for(int i = 0; i< edges.size(); i++){
      Edge current = edges.fetch(i);
      if(current.getSource().equals(n)){
        neighbors.append(current.getDestination());
      }
      else if(current.getDestination().equals(n)){
        neighbors.append(current.getSource());
      }
    }
      INode<N>[] temp = (INode<N>[]) new Node[neighbors.size()];
      return temp;
  }

  /**
   * Adds a node to the graph
   * @param v value at the node
   * @return the newly added node
   */
  public INode<N> addNode(N v){
    N value = (N) v;
    Node<N> new_node = new Node(value);
    boolean duplicate = false;
    if (nodes.size() > 0){
    for (int i =0; i < nodes.size(); i++){
      if (nodes.fetch(i).getValue().equals(v)){
        duplicate = true;
        break;
      }
    }
    if (duplicate == false){
      nodes.append(new_node);
    }
  }
  else{
    nodes.append(new_node);
  }
  return new_node;
  }

  /**
   * Gets an array of all the edges in the graph
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgeSet(){
    IEdge<N,W>[] temp = (IEdge<N,W>[]) new IEdge[edges.size()];
    for(int i = 0; i < temp.length; i++){
      temp[i] = edges.fetch(i);
    }
    return temp;
  }

  /**
   * Gets an array of all the edges sourced at a particular node
   * @param n the source node
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgesFrom(INode<N> n){
    DoubleLinkList<IEdge> neighbors = new DoubleLinkList();
    for(int i = 0; i< edges.size(); i++){
      Edge current = edges.fetch(i);
      if(current.getSource().equals(n)){
        neighbors.append(current);
      }
    }
      IEdge<N,W>[] temp = (IEdge<N,W>[]) new Object[neighbors.size()];
      for(int j = 0; j < neighbors.size(); j++){
        temp[j] = neighbors.fetch(j);
      }
      return temp;


}

  /**
   * Gets an array of all the edges destined for a particular node
   * @param n the destination node
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgesTo(INode<N> n){
    DoubleLinkList<IEdge> neighbors = new DoubleLinkList();
    for(int i = 0; i< edges.size(); i++){
      Edge current = edges.fetch(i);
      if(current.getDestination().equals(n)){
        neighbors.append(current);
      }
    }
      IEdge<N,W>[] temp = (IEdge<N,W>[]) new Object[neighbors.size()];
      for(int j = 0; j < neighbors.size(); j++){
        temp[j] = neighbors.fetch(j);
      }
      return temp;

}


  /**
   * Adds an edge to the graph.
   * Duplicate edges are not allowed in the graph. The equals method of the edge can
   * be used to determine if two edges duplicate one another.
   * @param w weight of the edge
   * @param s source node
   * @param d destination node
   */
  public void addEdge(INode<N> s, INode<N> d, W w){
    Node<N> source = (Node<N>) s;
    Node<N> destination = (Node<N>) d;
    boolean duplicate = false;
    Edge<N,W> new_edge = new Edge(source, destination, w);

    for(int i = 0; i< edges.size(); i++){
      Edge<N,W> current = edges.fetch(i);
      if(current.getSource().equals(source) && current.getDestination().equals(destination) && current.getWeight().equals(w)){
        duplicate = true;
        break;
      }
      else{
        duplicate = false;
      }
    }
if (duplicate == false){
  edges.append(new_edge);
}
  }

}
