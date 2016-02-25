
package graph;

import java.util.HashSet;
import java.util.Iterator;


public class Graph {
    private final HashSet<Node> graph;
       //methodo na gurnaei apo onoma node
    public Graph(int counter) {
        graph =  new HashSet<>();
        Node curr;
        double strength = 0;
        //curr = new Node(Integer.toString(1),2);
        for(int i = 1; i<=counter; i++) {
            //strength = curr.getStrength() + strength;
            curr = new Node(Integer.toString(i),2/*,strength*/);
            graph.add(curr);
        }
    }

    public Node getNode(String name){
        Node curr;
        
        for (Iterator<Node> it = graph.iterator(); it.hasNext();) {
            curr = it.next();
            if(name.equals(curr.getName())){
                return curr;
            }
        }
        
        return null;
    }
    
    
     public void createEdge(Node first, Node second) {
         if(second != first) {
            first.addEdge(second);
            second.addEdge(first);
         } else {
            first.addEdge(second);
         }
     }
     
     public  HashSet<Node> getGraph(){
         
         return graph;
     }

     public  String[] getGraphName(){
        String[] names;
        names = new String[graph.size()];
        int i = 0;
        for (Iterator<Node> it = graph.iterator(); it.hasNext();) {
            Node n = it.next();
            names[i] = n.getName();
            i++;
        }
        
        return names;
     }
     
     public double getMaxPot(){
         double max = 0;
         for (Iterator<Node> it = graph.iterator(); it.hasNext();) {
            Node n = it.next();
            if(max < n.getPotential()){
                max = n.getPotential();
            }
        }
        return (max);
     }
     
     public Node getMaxPotNode(){
        //S Node maxN = null;
         double max = 0;
         Node[] maxes = null;
         int i = 0;
         for (Iterator<Node> it = graph.iterator(); it.hasNext();) {
            Node n = it.next();
            if(max < n.getPotential()){
                max = n.getPotential();
                //maxN = n;
            }
        }
        for (Iterator<Node> it = graph.iterator(); it.hasNext();) {
             Node n = it.next();
             if(max == n.getPotential()){
                 maxes = new Node[i+1];
                 maxes[i] = n;
                 i++;
             }
        }
        
        int counter;
        counter = (int)(Math.random()+ maxes.length);
        if(counter == 0){
            return(maxes[counter]);
        }
        return (maxes[counter-1]);
     }
   
     
}
