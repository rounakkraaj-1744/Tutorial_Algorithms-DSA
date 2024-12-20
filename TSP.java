import java.util.Scanner;
import java.util.Arrays;
public class TSP {
    static int mincost;
    public static void travel(int c, int visited[]) {
        //creating weight of the graph
        int graph[][] = {
                {14, 28, 12, 43, 26},
                {28, 9, 12, 10, 15},
                {43, 22, 17, 8, 5},
                {10, 12, 14, 18, 20},
                {17, 19, 20, 15, 10}
        };
        int av = -999, min = graph[0][0];
        visited[c] = 1;
        System.out.print((c + 1) + " ");
        for (int i = 0; i < visited.length; i++)
            if (graph[c][i] != 0 && visited[i] == 0) {
                if (graph[c][i] < min)
                    min = graph[c][i];
                av = i;
            }

        if (min != graph[0][0])
            mincost = mincost + min;
        if (av == -999) {
            av = 0;
            System.out.println(av+1);
            mincost = mincost + graph[c][av];
            return;
        }
        travel(av, visited);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the no: of cities : ");
        int n = sc.nextInt ();
        int visited []= new int[n];
        Arrays.fill(visited, 0);
        System.out.print("Shortest Path: ");
        travel(0, visited);
        System.out.print("Minimum Cost: "+mincost);

        sc.close ();
    }
}