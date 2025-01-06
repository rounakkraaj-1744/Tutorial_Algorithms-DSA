public class Prim {
    static int INF = 999999;
    static void minCost(int weights [][]) {
        int S[][] = new int[weights.length][weights.length];
        int C[][] = new int[weights.length][weights.length];
        int d[] = new int[weights.length];
        int f[] = new int[weights.length];
        int visited[] = new int[weights.length];
        int u, v = 0, min_d, ne = weights.length-1,min_cost=0;
        for(int i=0; i<weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (weights[i][j] == 0)
                    C[i][j] = INF;
                else
                    C[i][j] = weights[i][j];
                S[i][j] = 0;
            }
        }
        d[0]=0;
        visited[0]=1;
        for(int i=1; i<weights.length; i++) {
            d[i] = C[0][i];
            f[i] = 0;
            visited[i] = 0;
        }
        while(ne > 0) {
            min_d = INF;
            for(int i=1; i<weights.length; i++)
                if(visited[i] == 0 && d[i] < min_d) {
                    v = i;
                    min_d = d[i];
                }
            u = f[v];
            S[u][v] = d[v];
            S[v][u] = d[v];
            ne--;
            visited[v]=1;
            for(int i=1; i<weights.length; i++)
                if(visited[i] == 0 && C[i][v] < d[i]) {
                    d[i] = C[i][v];
                    f[i] = v;
                }
            min_cost = min_cost + C[u][v];
        }
        display (S, weights);
        System.out.println ("The minimum cost is : "+min_cost);
    }
    static void display (int S[][], int weights[][]){
        System.out.println("Minimum Cost Spanning Tree: ");
        for(int i=0; i<weights.length; i++) {
            for(int j=0; j<weights.length; j++)
                System.out.print(S[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int weights[][] = {
             //  A  B   C   D   E    F    G
                {0, 7, INF, 5, INF, INF, INF},//A
                {7, 0, 8, 9, 7, INF, INF},//B
                {INF, 8, 0, INF, 5, INF, INF},//C
                {5, 9, INF, 0, 15, 6, INF},//D
                {INF, 7, 5, 15, 0, 8, 9},//E
                {INF, INF, INF, 6, 8, 0, 1},//F
                {INF, INF, INF, INF, 9, 11, 0}//G
        };
        minCost(weights);
    }
}