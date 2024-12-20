public class BellmanFord {
    static final int INF = 99999;
    static void calcDist(int weights[][], int n, int source) {
        int dist []= new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = INF;
        dist[source] = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (weights[j][k]!=0 && dist[j]!=INF && dist[j]+weights[j][k] < dist[k])
                        dist[k] = dist[j] + weights[j][k];
                }
            }
        }

        // Checking negative cycles
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (weights[i][j]!=0 && dist[i]!=INF && dist[j]+weights[i][j] < dist[j]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }
        display(dist, n);
    }

    static void display(int dist[], int n) {
        System.out.println("Vertex \t Distance");
        for (int i = 0; i < n; i++)
            System.out.println("  "+(char)(65+i) + "\t\t  " + dist[i]);
    }

    public static void main(String[] args) {
        int weights1[][] = new int[][] {
                { 0, -1, 2, INF, INF },
                { INF, 0, 1, INF, INF },
                { INF, INF, 0, 4, 3 },
                { INF, -3, INF, 0, INF },
                { INF, INF, INF, 3, 0 }
        };

        int weights2[][] = new int[][] {
                { 0, 1, 2, INF, INF },
                { INF, 0, 1, INF, INF },
                { INF, INF, 0, 4, 3 },
                { INF, 3, INF, 0, INF },
                { INF, INF, INF, 3, 0 }
        };

        int n1 = weights1.length;//number of vertices of the first graph
        calcDist(weights1, n1, 0);
        int n2 = weights2.length;//number of vertices of the second graph
        calcDist(weights2, n2, 0);
    }
}