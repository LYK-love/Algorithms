package Structures;


import Utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private List<Vertex<T>> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex<T> vertex) {
        this.vertices.add(vertex);
    }

    public void addEdge(Vertex<T> from, Vertex<T> to) {
        from.addNeighbor(to);
    }

    /**
     * Judge if the label of the vertex is duplicated in the graph.
     */
    public boolean hasDuplicatedVertex(Vertex<T> vertex)
    {
        for(Vertex<T> v: vertices)
            if(v.getLabel().equals(vertex.getLabel()))
                return true;
        return false;
    }

    public boolean hasCycle() {

        for(Vertex<T> vertex: vertices) vertex.setColor(Color.WHITE);//Every vertex hasn't been visited.

        for(Vertex<T> sourceVertex: vertices) {
            if(hasCycle(sourceVertex))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> sourceVertex)
    {
        if(sourceVertex.getColor() == Color.GREY)//This vertex is being visited, we encounter a cycle!
            return true;
        if(sourceVertex.getColor() == Color.BLACK)//This vertex has been visited. So we don't need to traver it again.
            return false;

        sourceVertex.setColor(Color.GREY);//This vertex is being visited

        for (Vertex<T> neighbor : sourceVertex.getAdjacencyList()) {
            if( hasCycle(neighbor) )
                return true;
        }

        sourceVertex.setColor(Color.BLACK);//The visiting of this vertex is over. Color it black.
        return false;
    }

    /**
     * Get the vertex with the given label. This method will return the first corresponding vertex if there are multiple matches
     */
    public Vertex<T> getVertexFromLabel(T label)
    {
        for(Vertex<T> v: vertices)
            if(v.getLabel().equals(label))
                return v;
        return null;
    }

}
