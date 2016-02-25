
package graph;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Node {
    private final HashSet<Node> edges;
    String name;
    double domRed;
    double instability;
    int score;
    double potential;
    int goal;
    int degree;
    double strength;

    public Node(String name, double domRed) {
        edges = new HashSet<>();
        this.name = name;
        this.domRed = domRed;
        score = 0;
        potential = 0;
        instability = 0;
        degree = 0;
        strength = 0.5;
    }
    
    
    
    public Node(HashSet<Node> edges, String name, double domRed) {
        this.edges = edges;
        this.name = name;
        this.domRed = domRed;
        score = 0;
        potential = 0;
        instability = 0;
        degree = 0;
        strength = 0.5;
    }
    
    
    //prosthetei geitones
    public void addEdge(Node edgeNode){
        Random rand = new Random();
        edges.add(edgeNode);
        //goal = rand.nextInt(edges.size());
        degree = edges.size();
        goal = degree;
    }
    
    
    //epistrefei olous tous geitones
    public HashSet<Node> getEdges(){
        
        return edges;
    }
    
    public String[] getEdgesNames(){
        String[] names;
        names = new String[edges.size()];
        int i = 0;
        
        for (Iterator<Node> it = edges.iterator(); it.hasNext();) {
            Node n = it.next();
            names[i] = n.getName();
            i++;
        }
        
        return names;
        
    }
    
    //an einai geitones
    public boolean edgeExist(Node curr){
        return(edges.contains(curr));
    }
    
    
    //epistrefei to onoma tou komvou
    public String getName(){
        return(name);
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getDomRed() {
        return(domRed);
    }
    
    public void setDomRed(double domRed) {
        this.domRed = domRed;
    }
    
    public int getScore() {
        return(score);
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
     public double getPotential() {
        return(potential);
    }
    
    public void setPotential(double potential){
        this.potential = potential;
    }
    
    public int getGoal(){
        return(goal);
    }
    
    public void setInsta(double instability){
        this.instability = instability;
    }
    
    public double getInsta(){
        return(instability);
    }
    
    public int getDegree(){
        return(degree);
    }
    
    public double getStrength(){
        return(strength);
    }
        
}
