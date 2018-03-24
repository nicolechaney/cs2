//Nicole Chaney

public class BFS<N,W> implements ISearcher<N,W> {
    DoubleLinkList<IEdge> checked = new DoubleLinkList<>();
    IGraph<N, W> g;
    INode<N> start;
    INode<N> end;

    public boolean pathExists(IGraph g, INode s, INode e) {
        this.g = g;
        this.end = e;
        this.start = s;
        DoubleLinkList<INode> list = new DoubleLinkList<>();
        RingQueue<IEdge> queue = new RingQueue<>();
        IEdge[] sedges = g.getEdgesFrom(s);
        for (int i = 0; i < sedges.length; i++) {
            queue.enqueue(sedges[i]);
        }
        INode<N> cur = s;
        while (!queue.isEmpty()) {
            if (cur.equals(end)) {
                return true;
            }
            boolean exists = false;
            IEdge r = queue.dequeue();
            cur = r.getDestination();
            //System.out.println(cur.getValue());
            checked.append(r);
            for (int i = 0; i < list.size; i++) {
                if (cur.equals(list.fetch(i))) {
                    exists = true;
                }
            }
            if (!exists) {
                list.append(cur);
                IEdge[] nedges = g.getEdgesFrom(cur);
                for (int i = 0; i < nedges.length; i++) {
                    queue.enqueue(nedges[i]);
                }
            }

        }
        return false;
    }


    public IList<INode> getPath(IGraph g, INode s,INode e) {
        this.g = g;
        this.end = e;
        this.start = s;
        DoubleLinkList<INode> list = new DoubleLinkList<>();
        RingQueue<IEdge> queue = new RingQueue<>();
        IEdge[] sedges = g.getEdgesFrom(s);
        for(int i = 0; i < sedges.length; i++){
            queue.enqueue(sedges[i]);
        }
        INode<N> cur = s;
        LinkStack<INode> full = new LinkStack();
        if(cur.equals(end)){
            IList<INode> special = new DoubleLinkList<>();
            return special;
        }
        while (!cur.equals(end)) {
            boolean exists = false;
            IEdge r = queue.dequeue();
            cur = r.getDestination();
//            System.out.println(cur.getValue());
            checked.append(r);
            for (int i = 0; i < list.size; i++) {
                if (cur.equals(list.fetch(i))) {
                    exists = true;
                }
            }
            if (!exists) {
                list.append(cur);
                IEdge[] nedges = g.getEdgesFrom(cur);
                    for (int i = 0; i < nedges.length; i++) {
                        queue.enqueue(nedges[i]);
                    }
                }

        }
        full.push(cur);
        while (!cur.equals(s)) {
            int n = 0;
            while (!checked.fetch(n).getDestination().equals(cur)) {
                n++;
            }
            cur = checked.fetch(n).getSource();
            full.push(cur);
        }
        return full.getStackr();
    }
}
