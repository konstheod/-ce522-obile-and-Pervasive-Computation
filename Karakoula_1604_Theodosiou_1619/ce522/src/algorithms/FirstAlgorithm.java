package algorithms;

import graph.DominatingSet;
import graph.Node;
import graph.Graph;
import java.util.Iterator;
import java.util.Random;

public class FirstAlgorithm {
    
    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();
        CreateGraph graph = new CreateGraph();
        Graph myGraph = graph.create();
        Random rand = new Random();
        DominatingSet domSet = new DominatingSet();
        int n;
        //double red = 0,8;
        double red = rand.nextDouble() + 1;
                
        int finished = 0;
          
        Node curr;
        Node edges;
        Node doubleEdges;
        /*******KORYFES*********/
        for (Iterator<Node> it = myGraph.getGraph().iterator(); it.hasNext();) {
            curr = it.next();
            curr.setScore(0);
            curr.setPotential(0);
            
            n = rand.nextInt(2);
            if(n<(red-Math.floor(red))){
                curr.setDomRed(Math.ceil(red));
            }
            else {
                curr.setDomRed(Math.floor(red));
            }
            if(curr.getScore()>=curr.getDomRed()){
                finished = finished + 1;
            }
        }
        for (Iterator<Node> it = myGraph.getGraph().iterator(); it.hasNext();) {
            curr = it.next();
            for (Iterator<Node> iter = curr.getEdges().iterator(); iter.hasNext();) {
                edges = iter.next();
                if(edges.getScore()<edges.getDomRed()){
                    curr.setPotential(curr.getPotential()+1);
                }
            }
            
            if(curr.getScore()<curr.getGoal()){
                curr.setPotential(curr.getPotential()+1);
            }
        }
        
        while((finished < myGraph.getGraph().size()&& (myGraph.getMaxPot()>0))){
            curr = myGraph.getMaxPotNode();
            domSet.addNode(curr);
            curr.setScore(curr.getScore()+1);
            curr.setPotential(0);
            
            if(curr.getScore() == curr.getDomRed()){
                finished = finished + 1;
            }
            
            for (Iterator<Node> iter = curr.getEdges().iterator(); iter.hasNext();) {
                edges = iter.next();
                if(curr.getScore() == curr.getDomRed()){
                    edges.setPotential(Math.max(0 , edges.getPotential()-1));
                }
                edges.setScore(edges.getScore() + 1);
                
                if(edges.getScore() == edges.getDomRed()) {
                    finished = finished + 1;
                    edges.setPotential(Math.max(0 , edges.getPotential() - 1));
                    for (Iterator<Node> it = edges.getEdges().iterator(); it.hasNext();) {
                        doubleEdges = it.next();
                        if(doubleEdges != curr) {
                            doubleEdges.setPotential(Math.max(0, doubleEdges.getPotential() - 1));
                        }
                    }
                }
            }
            
        }
        
        
        //myGraph.sortPot();
        String[] names = domSet.getDomSetNames();
        for(int i = 0; i<domSet.getDomSet().size(); i++) {
            System.out.println(i + " : " + names[i]);
        }
        /*for (Iterator<Node> it = domSet.getDomSet().iterator(); it.hasNext();) {
            doubleEdges = it.next();
            System.out.println(" name = " + doubleEdges.getName() + " score = " + doubleEdges.getScore());
        }*/
        
        /*names = myGraph.getGraphName();
        for(int i = 0; i<myGraph.getGraph().size(); i++) {
            System.out.println(i + " : " + names[i]);
        }*/
       double endTime = System.currentTimeMillis();

        double duration = (endTime - startTime)/1000;
        System.out.println("xronos = " + duration);
    }
    
    
}
