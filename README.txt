You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms. DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
INode.java         - An interface for nodes used by IGraph instances
IEdge.java         - An interface for edges used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
graphfile.cs2      - A simple graph file for a basic test
IQueue.java        - Interface for queues
IStack.java        - Interface for Stacks
BFS.java           - Works the Breadth first part of getPath in searcher.java
DFS.java           - Works the Depth first search part of getPath and pathExists methods in searcher.java
Arraylist.java     - Simple arraylist data type handler.

https://cdn-images-1.medium.com/max/1200/1*snTXFElFuQLSFDnvZKJ6IA.png
