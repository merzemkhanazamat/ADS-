import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraSP {

    private int[] distTo;
    private int[] edgeTo;
    private boolean[] visited;

    public DijkstraSP(EdgeWeightedGraph G, int source) {
        int V = G.V();
        distTo  = new int[V];
        edgeTo  = new int[V];
        visited = new boolean[V];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(edgeTo, -1);

        distTo[source] = 0;

        // min priority queue, pick vertex with smallest distance first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{ source, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0];

            if (visited[v]) continue;
            visited[v] = true;

            // relax edges from v
            for (int[] edge : G.adj(v)) {
                int w = edge[0];
                int weight = edge[1];

                if (!visited[w] && distTo[v] + weight < distTo[w]) {
                    distTo[w] = distTo[v] + weight;
                    edgeTo[w] = v;
                    pq.offer(new int[]{ w, distTo[w] });
                }
            }
        }
    }

    public int distTo(int v) { return distTo[v]; }

    public boolean hasPathTo(int v) { return distTo[v] < Integer.MAX_VALUE; }

    // follow edgeTo[] backwards to reconstruct the path
    public List<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<>();
        for (int x = v; x != -1; x = edgeTo[x]) path.add(x);
        Collections.reverse(path);
        return path;
    }
}
