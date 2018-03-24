//Nicole Chaney

public class GNode<N> implements INode<N> {
    N value;
    public GNode(N v){
        value = v;
    }
    public void setValue(N v) {
        value = v;
    }

    public N getValue() {
        return value;
    }
}
