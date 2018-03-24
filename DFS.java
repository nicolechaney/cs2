//Nicole Chaney

public class DFS<N,W> implements ISearcher<N,W>{
    DoubleLinkList<INode> check = new DoubleLinkList<>();
    LinkStack<INode> path = new LinkStack();
    IList<INode> linklist;
    IGraph<N, W> g;
    INode<N> start;
    INode<N> end;
    boolean found = false;
    boolean firsttime = false;
    boolean tf = false;


    public DFS(IGraph g, INode s, INode e) {
        start = s;
        end = e;
        this.g = g;
        check.append(s);
    }

    public boolean nodesexists() {
        INode[] arr = g.getNodeSet();
        int goof = 0;
        if(start == end){
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == start || arr[i] == end) {
                goof++;
            }
        }
        if (goof == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pathExists(IGraph g, INode s, INode e) {

        if(nodesexists()) {
//        System.out.println(s.getValue());
            path.push(s);
            ArrayList<INode> nb = new ArrayList<>();
            INode[] arr = g.getNeighbors(s);
            for (int i = 0; i < arr.length; i++) {
                nb.append(arr[i]);
            }
            //cleanup checked nodes;
            for (int j = 0; j < check.size; j++) {
                for (int h = 0; h < nb.size(); h++) {
                    if (nb.fetch(h).equals(check.fetch(j))) {
                        nb.remove(h);
                    }

                }
            }
            for (int j = 0; j < nb.size(); j++) {
                check.append(nb.fetch(j));
            }
            if (s.equals(end)) {
                if (tf) {
                    return true;
                } else {
                    linklist = path.getStack();
                    tf = true;
                    return true;
                }
            } else if (nb.size() > 0 && !tf) {
                for (int i = 0; i < nb.size(); i++) {
                    pathExists(g, nb.fetch(i), e);
                    if (tf) {
                        break;
                    }
                }
                if (!tf) {
                    path.pop();
                }
            } else {
                path.pop();
            }
            return tf;
        }
        else{
            return false;
        }



    }

    public IList getPath(IGraph g, INode s, INode e) {
        if(start == end){
            DoubleLinkList<INode> special = new DoubleLinkList<>();
            return special;
        }
        if (pathExists(g, s, e)) {
            return linklist;
        } else {
            return null;
        }
    }
}
