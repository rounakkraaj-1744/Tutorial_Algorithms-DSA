public class FloydWarshall {
    public static void main(String[] args) {
        //99999 represents infinity
        int graph[][] = {
            { 0, 8, 99999, 1 },
            { 99999, 0, 1, 99999 },
            { 4, 99999, 0, 99999 },
            { 99999, 2, 4, 0 }
        };
        int ar[][] = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                ar[i][j] = graph[i][j];
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (ar[i][k]+ar[k][j] < ar[i][j])
                        ar[i][j] = ar[i][k]+ar[k][j];
                }
            }
        }
        for (int i = 0; i < graph.length; ++i) {
            for (int j = 0; j < graph.length; ++j) {
                if (ar[i][j] == 99999)
                    System.out.print("∞ ");
                else
                    System.out.print(ar[i][j] + "  ");
            }
            System.out.println();
        }
    }
}