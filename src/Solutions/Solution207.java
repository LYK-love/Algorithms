package Solutions;

import Structures.Graph;
import Structures.Vertex;

import java.util.HashSet;

import static Utils.ArrayUtils.flattenArray;
import static Utils.ArrayUtils.removeDuplicatesFromArray;


public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph<Integer> graph = buildGraph(numCourses, prerequisites);
        return !graph.hasCycle();
    }



    private Graph<Integer> buildGraph(int numCourses, int[][] prerequisites)
    {
        Graph<Integer> graph = new Graph<>();


        int[]  oneDUniqueArray = removeDuplicatesFromArray(flattenArray(prerequisites));

        for(int label: oneDUniqueArray)
        {
            Vertex<Integer> uniqueVertex = new Vertex<>(Integer.valueOf(label));
            graph.addVertex(uniqueVertex);
        }

        for(int[] edge: prerequisites)
        {
            Vertex<Integer> from = graph.getVertexFromLabel(edge[1]);
            Vertex<Integer> to = graph.getVertexFromLabel(edge[0]);

            graph.addEdge(from, to);
        }
        return graph;
    }
}
