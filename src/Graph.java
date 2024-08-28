import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/***
 * Represents an undirected graph using an adjacency list.
 */

public class Graph {
	// Map to store the adjacency list of the graph
    private final ArrayList<ArrayList<String>> graph = new ArrayList<>();
    
    // Adjacency list where each key is a node and the value is a map of neighboring nodes and edge weights
    // ex. {A: {B=1, C=4}, B: {A=1, C=2, D=5}, C: {A=4, B=2, D=1}, D: {B=5, C=1}}

    /**
     * Adds a node to the graph. If the node already exists, it is not added again.
     * 
     * @param node The name of the node to be added.
     */
    
    
	
    public void addNode(String node) {
        // Implementation here
    }

    /**
     * Adds an edge between two nodes with a specified weight. This method assumes the graph is undirected.
     * 
     * @param from The starting node of the edge.
     * @param to The ending node of the edge.
     * @param weight The weight of the edge.
     */
    public void addEdge(String from, String to, int weight) {
        // Implementation here
    	ArrayList<String> edge = new ArrayList<>();

    	edge.add(from);
    	edge.add(to);
    	edge.add(Integer.toString(weight));
    	
    	// 중복 추가 case
    	for(int i = 0; i<graph.size(); i++) {
    		if(graph.get(i).equals(edge)) {
    			System.out.println("중복");
    			continue;
    		// 같은 node 구성에 cost가 다른 case	
    		}else if(graph.get(i).get(0).equals(edge.get(0)) && graph.get(i).get(1).equals(edge.get(1)) && !graph.get(i).get(2).equals(edge.get(2))) {
    			System.out.println("cost error");
	    		continue;
    		}else {
    			graph.add(edge);
    		}
    	}
    }

    /**
     * Returns the adjacency list of the graph.
     * 
     * @return A map where each key is a node, and the value is another map representing neighboring nodes and edge weights.
     */
//    public Map<String, Map<String, Integer>> getAdjList() {
//        return
//    }
    
	// Method to print the graph (for debugging purposes)
	public void printGraph() {
		
		System.out.println("Graph :");
		for(int i = 0; i<graph.size(); i++) {
			System.out.println(graph.get(i));
		
		}
	}
}