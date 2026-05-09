import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] names = {
                "Edinburgh", "Stirling", "Kinross",
                "Perth", "Glasgow", "Forfar", "Dundee"
        };

        final int EDINBURGH = 0, STIRLING = 1, KINROSS = 2,
                PERTH = 3, GLASGOW = 4, FORFAR = 5, DUNDEE = 6;

        EdgeWeightedGraph G = new EdgeWeightedGraph(7, names);

        G.addEdge(EDINBURGH, STIRLING, 37);
        G.addEdge(EDINBURGH, KINROSS,  25);
        G.addEdge(EDINBURGH, GLASGOW,  46);
        G.addEdge(STIRLING,  PERTH,    33);
        G.addEdge(STIRLING,  GLASGOW,  26);
        G.addEdge(STIRLING,  KINROSS,  21);
        G.addEdge(KINROSS,   PERTH,    18);
        G.addEdge(PERTH,     DUNDEE,   22);
        G.addEdge(PERTH,     FORFAR,   20);
        G.addEdge(FORFAR,    DUNDEE,   14);

        System.out.println(G);

        DijkstraSP sp = new DijkstraSP(G, EDINBURGH);

        if (sp.hasPathTo(DUNDEE)) {
            List<Integer> path = sp.pathTo(DUNDEE);

            StringBuilder sb = new StringBuilder("Shortest path: ");
            for (int i = 0; i < path.size(); i++) {
                sb.append(names[path.get(i)]);
                if (i < path.size() - 1) sb.append(" -> ");
            }
            System.out.println(sb);
            System.out.println("Total distance: " + sp.distTo(DUNDEE) + " miles");
        }
    }
}
