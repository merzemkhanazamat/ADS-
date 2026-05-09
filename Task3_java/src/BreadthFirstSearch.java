import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstSearch(Graph G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            edgeTo[i] = -1;
            distTo[i] = Integer.MAX_VALUE;
        }

        System.out.print("BFS visit order: ");
        bfs(G, source);
        System.out.println();
    }

    private void bfs(Graph G, int source) {
        Queue<Integer> queue = new LinkedList<>();

        marked[source] = true;
        distTo[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(G.name(v) + " ");

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.add(w);
                }
            }
        }
    }

    public boolean marked(int v) { return marked[v]; }
    public int distTo(int v) { return distTo[v]; }
    public int edgeTo(int v) { return edgeTo[v]; }
}
