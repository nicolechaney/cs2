//Nicole Chaney

public class Searcher<N,W> implements ISearcher<N,W> {

    public boolean pathExists(IGraph<N, W> g, INode<N> s, INode<N> e) {
        DFS pather = new DFS(g,s,e);
        if (!pather.nodesexists()){
            return false;
        }
        return pather.Path(pather.start);

    }


    public IList<INode<N>> getPath(IGraph<N, W> g, INode<N> s, INode<N> e) {
        DFS pather = new DFS(g,s,e);
        BFS pathe = new BFS(g,s,e);
        IList<INode> test = pather.getPath(s);
        if(pathExists(g,s,e)) {
            System.out.println("DFS");
            for (int i = 0; i < test.size(); i++) {
                System.out.print(test.fetch(i).getValue() + " ");
            }
            System.out.print("\n");
            DoubleLinkList<INode> list = new DoubleLinkList<>();
            System.out.println("BFS");
            return pathe.getPath(s, list);
        }
        else{
            System.out.println("Error: Path does not exist");
            return null;
        }
    }
}
