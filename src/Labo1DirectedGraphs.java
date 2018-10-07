import com.google.common.collect.Lists;
import com.google.common.graph.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Labo1DirectedGraphs {

    public static void main(String[] args) throws IOException {

        // gerichte graaf inlezen (je mag er van uit gaan dat dit een gerichte graaf is, ie. graph.isDirected() == true
        // bestanden: tinyDG.txt, tinyDAG.txt, mediumDG.txt, mediumDAG.txt onder de folder data
        Graph<String> graph = Util.loadDiGraphFromFile(new File("data-lab1/mediumDAG.txt"));

        long starTime = System.currentTimeMillis();

        boolean hasCycle = hasCycle(graph);

        if(!hasCycle) {
            System.out.println("Graaf heeft geen gerichte lus.");
            System.out.printf("Ordening van nodes volgens edges: %s\n",determinePrecedenceFeasibleOrdering(graph));
        } else {
            System.out.println("Graaf heeft een gerichte lus!");
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime-starTime + "ms");

    }

    // Implementeer hier opgave 1
    public static boolean hasCycle(Graph<String> graph) {
        Stack DFSStack = new Stack();
        Set<String> unvisited = new HashSet<>(graph.nodes());
        boolean hasCycle = false;
        while(!unvisited.isEmpty() && !hasCycle){
            String firstnode = unvisited.iterator().next();
            hasCycle = DFS(graph, firstnode, DFSStack, unvisited);
            DFSStack.clear();
        }
        return hasCycle;

    }

    public static boolean DFS(Graph<String> graph, String parent, Stack DFSStack, Set<String> unvisited){
        DFSStack.add(parent);
        unvisited.remove(parent);

        for(String node : graph.successors(parent)){
            if(DFSStack.contains(node)){
                return true;
            }
            else{
                if(DFS(graph, node, DFSStack, unvisited)) return true;
            }
        }
        DFSStack.pop();
        return false;
    }

    // Implementeer hier opgave 2
    public static List<String> determinePrecedenceFeasibleOrdering(Graph<String> graph) {
        Set<String> unvisited = new HashSet<>(graph.nodes());
        List<String> sorted = new ArrayList<>();
        while(!unvisited.isEmpty()) {
            String firstnode = unvisited.iterator().next();
            sorted.addAll(new ArrayList<>(TopologicSorting(graph, firstnode, unvisited, new Stack<String>())));
        }
        return Lists.reverse(sorted);
    }

    public static Stack<String> TopologicSorting(Graph<String> graph, String firstnode, Set<String> unvisited, Stack<String> sorted){
        unvisited.remove(firstnode);
        for(String node: graph.successors(firstnode)){
            if(unvisited.contains(node)){
                sorted = TopologicSorting(graph, node, unvisited, sorted);
            }
        }
        sorted.add(firstnode);
        return sorted;
    }

}
