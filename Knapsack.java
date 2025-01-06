//0/1 Knapsack Algorithm
import java.util.Scanner;
public class Knapsack {
    public static void main (String[]args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the no: of objects : ");
        int o = sc.nextInt ();
        System.out.print ("Enter the constraint : ");
        int constraint = sc.nextInt ();
        int w[] = new int [o];
        int p[] = new int[o];
        for (int i = 0;i<o;i++){
            System.out.print ("Enter weight of "+(i+1)+" object : ");
            w[i] = sc.nextInt ();;
            System.out.print ("Enter profit of "+(i+1)+" object : ");
            p[i] = sc.nextInt ();
        }
        int ar[][] = new int [o+1][constraint+1];
        for (int i = 0; i < o; i++) {
            for (int j = 0; j < constraint; j++) {
                if (i == 0 || j == 0)
                     ar[i][j] = 0;
                 else if (w[i - 1] <= j)
                     ar[i][j] = Math.max(p[i - 1] + ar[i - 1][j - w[i - 1]], ar[i - 1][j]);
                 else
                     ar[i][j] = ar[i - 1][j];
            }
        }
         System.out.println ("Maximum Profit = "+ar[o][constraint]);
    }
}