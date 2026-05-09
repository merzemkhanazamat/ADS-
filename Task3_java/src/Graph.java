import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int V;
    private final String[] names;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V, String[] names) {
        this.V = V;
        this.names = names;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // add neighbor w to vertex v's adjacency list
    public void addDirected(int v, int w) {
        adj[v].add(w);
    }

    public int V() { return V; }

    public Iterable<Integer> adj(int v) { return adj[v]; }

    public String name(int v) { return names[v]; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Adjacency Lists:\n");
        for (int v = 0; v < V; v++) {
            sb.append("  ").append(names[v]).append(": ");
            for (int w : adj[v]) sb.append(names[w]).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
