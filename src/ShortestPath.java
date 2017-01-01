import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ShortestPath
{
    private boolean[] visited;
    private int[] edge;
    private int[] edgeDist;
    private int source;
    
    public ShortestPath(Graph undirectedG, int source)
    {
        edge     = new int[undirectedG.numOfVertices()];
        edgeDist = new int[undirectedG.numOfVertices()];
        visited  = new boolean[undirectedG.numOfVertices()];
        this.source = source;
        breadthFirstSearch(undirectedG, source);
    }
    
    public void breadthFirstSearch(Graph g, int s)
    {
       Queue<Integer> frontier = new Queue<Integer>();
       frontier.enqueue(s);
       visited[s]  = true;
       edge[s] = s;
       edgeDist[s] = 0;
       while (!frontier.isEmpty())
       {
           int v = frontier.dequeue();
           StdOut.println(v);
           Queue<Integer> neighbors = g.adjacentVertices(v);
           while (!neighbors.isEmpty())
           {
               int w = neighbors.dequeue();
               if (!visited[w])
               {
                   frontier.enqueue(w);
                   visited[w] = true;
                   edge[w] = v;
                   edgeDist[w] = edgeDist[v] + 1;
               }
           }
       }
    }
    
    // doesPathExist
    
    // path
    
    public static void main(String[] args)
    {
        Graph g = new Graph(new In("/Users/Hennessy/Graph Algorithms/Graph Data Types/Undirected/data/tinyG.txt"));
        ShortestPath spg = new ShortestPath(g, 0);
        StdOut.println("Edges");
        spg.printEdges();
        StdOut.println("Edge distances");
        spg.printEdgeDistances();
        //StdOut.println("Graph");
        //g.printGraph();
    }
    
    public void printEdgeDistances()
    {
        for (int i = 0; i < edgeDist.length; i++)
            StdOut.println(i + " : " + edgeDist[i]);
    }
    
        public void printEdges()
    {
        for (int i = 0; i < edge.length; i++)
            StdOut.println(i + " : " + edge[i]);
    }
}