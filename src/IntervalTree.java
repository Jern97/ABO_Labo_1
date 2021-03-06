import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalTree {
    private Node root;

    /**
     * Constructor
     *
     * Opgave 3.1
     * Bouw in de constructor de gebalanceerde boom op adhv de ongesorteerde lijst van intervals
     * @param intervals
     */
    public IntervalTree(List<Interval> intervals) {
        Collections.sort(intervals);

        root = recursiveIntervalTree(intervals, null);
    }
    private Node recursiveIntervalTree(List<Interval> intervals, Node parent){
        if(intervals.size() == 0){
            return null;
        }
        if(intervals.size() == 1){
            return new Node(intervals.get(0), parent, null, null, intervals);
        }
        //midden bepalen
        int middle = intervals.size()/2;

        //Lijsten opsplisten in linker en rechter helft
        List<Interval> leftInterval = intervals.subList(0, middle);
        List<Interval> rightInterval = intervals.subList(middle+1, intervals.size());

        //Current node aanmaken en zijn linker en rechter node instellen via recursie
        Node current = new Node(intervals.get(middle), parent, null, null, intervals);
        Node leftNode = recursiveIntervalTree(leftInterval, current);
        Node rightNode = recursiveIntervalTree(rightInterval, current);
        current.setLeft(leftNode);
        current.setRight(rightNode);

        return current;

    }

    /**
     * Opgave 3.2
     */
    public void printIntervals() {
        recursivePrintIntervals(root);
    }

    private void recursivePrintIntervals(Node parent){
        if(parent.getLeft() == null){
            System.out.println(parent.getInterval());
            return;
        }
        recursivePrintIntervals(parent.getLeft());
        System.out.println(parent.getInterval());
        if(parent.getRight() != null){
            recursivePrintIntervals(parent.getRight());
        }
    }


    /**
     * Opgave 3.3
     */
    public List<Interval> findOverlapping(int x) {
        List<Interval> toReturn = recursiveFindOverlapping(new Interval(x,x+1), root, new ArrayList<Interval>());
        Collections.sort(toReturn);

        return toReturn;
    }

    public List<Interval> recursiveFindOverlapping(Interval ab, Node parent, List<Interval> intervals){
        //Terug naar boven als de parent null is of als het maximum van de subtree minder is dan de low;
        if(parent == null) return intervals;
        if(parent.getMax() < ab.getLow()) return intervals;

        //Verder zoeken in de subtree: altijd langs links, enkel langs rechts als de low van de parent kleiner of gelijk aan de high is
        recursiveFindOverlapping(ab, parent.getLeft(), intervals);
        if(parent.getInterval().getLow() <= ab.getHigh()){
            recursiveFindOverlapping(ab, parent.getRight(), intervals);
        }

        //toevoegen aan interval lijst indien er wel degelijk overlap is;
        Interval overlap = parent.getInterval().calculateOverlap(ab);
        if(overlap != null){
            intervals.add(parent.getInterval());
        }
        return intervals;

    }

    /**
     * Opgave 3.4
     */

    public List<Interval> findOverlapping(Interval ab) {
        List<Interval> toReturn = recursiveFindOverlapping(ab, root, new ArrayList<Interval>());
        Collections.sort(toReturn);

        return toReturn;
    }
}
