/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author katerina
 */
public class DominatingSet {
    private final HashSet<Node> domSet;

    public DominatingSet() {
        domSet =  new HashSet<>();
    }
    
    
    public void addNode(Node curr){
        domSet.add(curr);
    }
    
    public HashSet<Node> getDomSet(){
        return(domSet);
    }
    
    public String[] getDomSetNames(){
         String[] names;
        names = new String[domSet.size()];
        int i = 0;
        
        for (Iterator<Node> it = domSet.iterator(); it.hasNext();) {
            Node n = it.next();
            names[i] = n.getName();
            i++;
        }
        
        return names;
        
    }
    
    
    
    
    
}
