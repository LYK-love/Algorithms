package Structures;


import Utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T label;

    Color color;

    private boolean beingVisited; //If u is already in the beingVisited state, it clearly means there exists a backward edge and so a cycle has been detected
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(T label) {
        this.label = label;
        this.adjacencyList = new ArrayList<>();
        this.color = Color.WHITE;
    }

    public T getLabel()
    {
        return label;
    }

    public void addNeighbor(Vertex adjacent) {
        this.adjacencyList.add(adjacent);
    }

    //getters and setters
    public void setColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }




    public List<Vertex> getAdjacencyList()
    {
        return adjacencyList;
    }

}
