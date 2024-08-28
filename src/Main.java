import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Provides the main entry point for the application. Handles user input and interaction with the graph.
 */

public class Main {

    /**
     * Main method that drives the application. It allows users to input nodes, edges, and query for shortest paths.
     * It prints the adjacency list and shortest path distances.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
    	
    	//Graph 
    	Graph graph = new Graph();
    	
    	//입력받은 Node의 개수만큼 size
    	String[] nodeNames = inputNodes();
    	
    	String[][] edgesCost = inputEdgeCost();
    		
    	//Shortest Path Distances from "startNodeName":
    	String startNodeName = "";
    	
    	//node
    	for(int i = 0; i<nodeNames.length; i++) {
    		graph.addNode(nodeNames[i]);
    		
    		
    	}
    	
    	//edge
    	for(int i = 0; i<edgesCost.length; i++) {
    		graph.addEdge(edgesCost[i][0], edgesCost[i][1], Integer.parseInt(edgesCost[i][2]));
    		
    	}
    	
    	
    	graph.printGraph();
    	
//    	Map<String, Integer> distances = Dijkstra.findShortestPaths(graph, startNodeName);
    	
    	
    }
    
    /**
     * 1. Node의 개수를 입력받는다.
     * 2. Node의 개수만큼 반복하면서 Node의 이름을 입력받는다.
     * 
     * @return Node의 이름
     */
    public static String[] inputNodes() {
    	
    	Scanner sc = new Scanner(System.in);
    	String nodeName = "";
    	int node = 0;
    	
    	while(true) {
    		try {
    			System.out.println("Node의 개수를 입력해주세요.");
    			node = sc.nextInt();
    			String[] nodeNames = new String[node];
    			
    			for (int i = 0; i <node; i++) {
    				System.out.println("Node의 이름을 읿력해주세요.");
    				nodeName = sc.next();
    				nodeNames[i] = nodeName;
    			}
				
    			return nodeNames;
			} catch (Exception e) {
				System.out.println("다시 입력해주세요.");
    			sc.nextLine();
			}
    	}
    	
    }
    
    /**
     * 1. Edge의 개수를 입력받는다.
     * 2. Edge의 개수만큼 반복하면서 연결할 Node와 Edge의 Cost를 설정한다. (ex. A B 1)
     * 
     * @return String[3] (nodeName1, nodeName2, cost) 
     */
    public static String[][] inputEdgeCost() {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int edge = 0;
    	String costOfEdge = "";
    	String[] arrCost = new String[3];
    	
    	System.out.println("edge의 개수를 입력해주세요.");
    	edge = sc.nextInt();    	
    	String[][] nodeAndCost = new String[edge][3];
    	
    	sc.nextLine();
    	
    	for(int i = 0; i<edge; i++) {
    		boolean flag = false;
    		
    		System.out.println("연결할 Node와 Edge의 Cost를 입력해주세요. (ex. A B 1)");
    		
    		costOfEdge = sc.nextLine();
			
			arrCost = costOfEdge.split(" ");
			for(int j = 0; j<nodeAndCost.length; j++) {
				if(Arrays.equals(nodeAndCost[j], arrCost)) {
					System.out.println("중복");
					i--;
					flag = true;
				}
				
				if(nodeAndCost[j][0] != null && nodeAndCost[j][0].equals(arrCost[0]) && nodeAndCost[j][1].equals(arrCost[1]) && !nodeAndCost[j][2].equals(arrCost[2])) {
	    			System.out.println("cost error");
	    			i--;
	    			flag = true;
				}
				
				
			}
			if(flag == false) {
				nodeAndCost[i] = arrCost;
			}
    	}
    	return nodeAndCost;
    		
    }
}    	
