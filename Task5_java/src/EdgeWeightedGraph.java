import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private final int V;
    private final String[] names;
    private List<int[]>[] adj; // each entry is {neighbor, weight}

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V, String[] names) {
        this.V = V;
        this.names = names;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
    }

    public void addEdge(int v, int w, int weight) {
        adj[v].add(new int[]{ w, weight });
        adj[w].add(new int[]{ v, weight });
    }

    public int V() { return V; }
    public String name(int v) { return names[v]; }
    public Iterable<int[]> adj(int v) { return adj[v]; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Graph:\n");
        for (int v = 0; v < V; v++) {
            sb.append("  ").append(names[v]).append(": ");
            for (int[] e : adj[v])
                sb.append(names[e[0]]).append("(").append(e[1]).append("mi) ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
