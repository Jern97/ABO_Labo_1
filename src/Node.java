import java.util.List;

public class Node {
    private Interval interval;
    private Node parent;
    private Node left;
    private Node right;
    private int max = 0;

    public Node(Interval interval, Node parent, Node left, Node right, List<Interval> intervals) {
        this.interval = interval;
        this.parent = parent;
        this.left = left;
        this.right = right;

        for(Interval i: intervals){
            if(max < i.getHigh()) max = i.getHigh();
        }
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
