public class Dijkstra {
    static final int INF = 999999;
    static void calcDist(int weights[][], int source) {
        boolean visited[] = new boolean[weights.length];
        int dist[] = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            visited[i] = false;
            dist[i] = INF;
        }
        dist[source] = 0;
        for (int i = 0; i < weights.length; i++) {
            int a = minDist(dist, visited);
            visited[a] = true;

            for (int j = 0; j < weights.length; j++)
                if (!visited[j] && weights[a][j]!=0 && dist[a]!=INF && (dist[a]+weights[a][j]<dist[j]))
                    dist[j] = dist[a] + weights[a][j];
        }
        System.out.println("Vertex \t Distance");
        for (int i = 0; i < dist.length; i++)
            System.out.println("  "+(char)(65+i) + "\t\t  " + dist[i]);
    }

    static int minDist(int dist[], boolean visited[]) {
        int min = INF, vertex = -1;
        for (int i = 0; i < dist.length; i++)
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                vertex = i;
            }
        return vertex;
    }
  
    public static void main(String[] args) {
        int weights[][] = new int[][] {
                { 0, 1, 5, INF, INF, INF, INF },
                { 1, 0, INF, 3, 5, INF, INF },
                { 5, INF, 0, 6, INF, 2, INF },
                { INF, 3, 6, 0, 4, 9, INF },
                { INF, INF, INF, INF, 0, 2, 3 },
                { INF, INF, 2, 9, 2, 0, 7 },
                { INF, INF, INF, INF, 3, 7, 0 }
        };
        calcDist(weights, 0);
    }
}  