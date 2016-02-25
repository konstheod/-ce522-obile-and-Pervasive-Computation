package algorithms;

import graph.DominatingSet;
import graph.Graph;
import graph.Node;
import java.util.HashSet;
import java.util.Iterator;

public class SecondAlgorithm {
    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();


        CreateGraph graph = new CreateGraph();
        Graph myGraph = graph.create();
        DominatingSet domSet = new DominatingSet();
        Node curr;
        Node doubleCurr;
        Node tripleCurr;
        String[] names;
        
         HashSet<Node> sum =  new HashSet<>();


         for (Iterator<Node> it = myGraph.getGraph().iterator(); it.hasNext();) {
              curr = it.next();
              curr.setInsta(1.0);
              curr.setPotential((curr.getDegree() + 1)*(1 - curr.getStrength()));
         }
         for(int a = 1; a <= myGraph.getGraph().size(); a++){
             curr = myGraph.getMaxPotNode();
             domSet.addNode(curr);
             sum.clear();
             curr.setInsta(curr.getInsta()*(1-curr.getStrength()));
             for (Iterator<Node> it = curr.getEdges().iterator();it.hasNext();) {
                 doubleCurr = it.next();
                 doubleCurr.setInsta(doubleCurr.getInsta()*(1 - curr.getStrength()));
                 sum.add(doubleCurr);
                 for (Iterator<Node> iter = doubleCurr.getEdges().iterator();iter.hasNext();) {
                    tripleCurr = iter.next();
                    sum.add(tripleCurr);
                 }
             }
             
             for (Iterator<Node> it = sum.iterator(); it.hasNext();) {
                 doubleCurr = it.next();
                 doubleCurr.setPotential(0);
                 if(!domSet.getDomSet().contains(doubleCurr)){
                     for (Iterator<Node> iter = doubleCurr.getEdges().iterator();iter.hasNext();) {
                         tripleCurr = iter.next();
                         doubleCurr.setPotential(doubleCurr.getPotential() + doubleCurr.getStrength()*tripleCurr.getInsta());
                     }
                     doubleCurr.setPotential(doubleCurr.getPotential() + doubleCurr.getInsta()*doubleCurr.getStrength());
                 }
             }
         
         }
        
        names = new String[sum.size()];
        int i = 0;
        names = domSet.getDomSetNames();
        /*for(int i = 0; i<domSet.getDomSet().size(); i++) {
            System.out.println(i + " : " + names[i]);
        }*/
        
        for (Iterator<Node> it = sum.iterator(); it.hasNext();) {
            Node n = it.next();
            names[i] = n.getName();
            System.out.println(i + " : " + names[i]);
            i++;
        }
        double endTime = System.currentTimeMillis();

        double duration = (endTime - startTime)/1000;
        System.out.println("xronos = " + duration);
    }
}
