public class Main {

    public static void main(String[] args) {

        String[] names = { "A", "B", "C", "D", "E", "F", "G" };
        final int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6;

        Graph graph = new Graph(7, names);

        // build adjacency lists exactly as given in the task
        // A: C B D
        graph.addDirected(A, C); graph.addDirected(A, B); graph.addDirected(A, D);
        // B: A C E G
        graph.addDirected(B, A); graph.addDirected(B, C); graph.addDirected(B, E); graph.addDirected(B, G);
        // C: A B D
        graph.addDirected(C, A); graph.addDirected(C, B); graph.addDirected(C, D);
        // D: C A
        graph.addDirected(D, C); graph.addDirected(D, A);
        // E: G F B
        graph.addDirected(E, G); graph.addDirected(E, F); graph.addDirected(E, B);
        // F: G E
        graph.addDirected(F, G); graph.addDirected(F, E);
        // G: F B
        graph.addDirected(G, F); graph.addDirected(G, B);

        System.out.println(graph);

        new DepthFirstSearch(graph, A);
        System.out.println("Expected: A C B E G F D");
        System.out.println();

        new BreadthFirstSearch(graph, A);
        System.out.println("Expected: A C B D E G F");
    }
}
