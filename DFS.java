public class DFS {
    static int visit[] = new int [9];
    static int q[] = new int [9];
    static int n=9,i,j,front=0,rear=-1;
    static char node[]={'A','B','C','D','E','F','G','H','I'};
    static int g[][]=
    {
        {0,1,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0},
        {0,0,0,1,1,1,0,0,1},
        {0,0,1,0,0,0,0,0,0},
        {0,0,1,0,0,0,0,1,0},
        {0,0,1,0,0,0,1,0,0},
        {0,0,0,0,0,1,0,1,1},
        {0,0,0,0,1,0,1,0,0},
        {1,0,1,0,0,0,1,0,0}
    };
    static void dfs(int v) {
        System.out.print(node[v]+" ");
        visit[v]=1;

        for(int i=0;i<n;i++)
            if(visit[i]==0 && g[v][i]==1)
                dfs(i);
    }

    public static void main(String[]args) {
        for(int i=0;i<n;i++) {
            q[i]=0;
            visit[i]=0;
        }
        System.out.print ("\tDFS : ");
        dfs(0);
        System.out.println ();
    }
}
