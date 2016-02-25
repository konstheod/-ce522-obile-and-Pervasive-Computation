package algorithms;

import graph.Node;
import graph.Graph;
import java.util.Random;

public class CreateGraph {
    
    
    public Graph create(){
        
        Node first;
        Node second;
        
         //1st graph
        
        Graph graph = new Graph(8);
        
        first = graph.getNode("1");
        second = graph.getNode("2");
        graph.createEdge(first, second);
        
        first = graph.getNode("1");
        second = graph.getNode("7");
        graph.createEdge(first, second);
        
        first = graph.getNode("1");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("2");
        second = graph.getNode("3");
        graph.createEdge(first, second);
        
        first = graph.getNode("2");
        second = graph.getNode("7");
        graph.createEdge(first, second);
        
        first = graph.getNode("2");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("3");
        second = graph.getNode("4");
        graph.createEdge(first, second);
        
        first = graph.getNode("3");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("4");
        second = graph.getNode("5");
        graph.createEdge(first, second);
        
        first = graph.getNode("4");
        second = graph.getNode("6");
        graph.createEdge(first, second);
        
        first = graph.getNode("5");
        second = graph.getNode("7");
        graph.createEdge(first, second);
        
        first = graph.getNode("5");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("6");
        second = graph.getNode("7");
        graph.createEdge(first, second);

        /* 2nd graph
        Graph graph = new Graph(9);
        
        first = graph.getNode("1");
        second = graph.getNode("2");
        graph.createEdge(first, second);
        
        first = graph.getNode("1");
        second = graph.getNode("4");
        graph.createEdge(first, second);
        
        first = graph.getNode("1");
        second = graph.getNode("6");
        graph.createEdge(first, second);
        
        first = graph.getNode("2");
        second = graph.getNode("5");
        graph.createEdge(first, second);
        
        first = graph.getNode("3");
        second = graph.getNode("5");
        graph.createEdge(first, second);
        
        first = graph.getNode("4");
        second = graph.getNode("7");
        graph.createEdge(first, second);
        
        first = graph.getNode("5");
        second = graph.getNode("6");
        graph.createEdge(first, second);
        
        first = graph.getNode("5");
        second = graph.getNode("9");
        graph.createEdge(first, second);
        
        first = graph.getNode("6");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("6");
        second = graph.getNode("9");
        graph.createEdge(first, second);
        
        first = graph.getNode("7");
        second = graph.getNode("8");
        graph.createEdge(first, second);
        
        first = graph.getNode("8");
        second = graph.getNode("9");
        graph.createEdge(first, second);
        
        first = graph.getNode("9");
        second = graph.getNode("9");
        graph.createEdge(first, second);
*/
       /*  Graph graph = new Graph(5000);
         Random rand = new Random();
         int i = 1;
         int k = 5000;
         while(i <= k) {
             first = graph.getNode(Integer.toString(i));
             int  n = rand.nextInt(k) + 1;
             second = graph.getNode(Integer.toString(n));
             graph.createEdge(first, second);
             i++; 
         }
       */
        return(graph);
    }
    
}
