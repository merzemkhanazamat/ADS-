public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstSearch(Graph G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) edgeTo[i] = -1;

        System.out.print("DFS visit order: ");
        dfs(G, source);
        System.out.println();
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        System.out.print(G.name(v) + " ");

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w); // go deeper, backtrack when no unvisited neighbors
            }
        }
    }

    public boolean marked(int v) { return marked[v]; }
    public int edgeTo(int v) { return edgeTo[v]; }
}
