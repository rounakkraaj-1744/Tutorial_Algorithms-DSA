//Fractional Knapsack
import java.util.Scanner;
public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no: of objects : ");
        int o = sc.nextInt();
        System.out.println("Enter the constraint : ");
        int constraint = sc.nextInt();

        int p[] = new int[o], w[] = new int[o];
        double s[] = new double[o], sarr[] = new double[o], ratio[] = new double[o];

        for (int i = 0; i < o; i++) {
            System.out.println("Enter the quantity of object : " + (i + 1));
            p[i] = sc.nextInt();
            System.out.println("Enter the weight of object : " + (i + 1));
            w[i] = sc.nextInt();
        }

        // storing the ratio of each element of p[i] and w[i]
        for (int i = 0; i < o; i++) {
            ratio[i] = (double) p[i] / w[i];
            sarr[i] = ratio[i];
        }

        // sorting the array in descending order
        double temp = 0;
        for (int i = 0; i < o - 1; i++) {
            for (int j = 0; j < o - i - 1; j++) {
                if (sarr[j] < sarr[j + 1]) {
                    temp = sarr[j];
                    sarr[j] = sarr[j+1];
                    sarr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i<o; i++)
            s[i] = 0;

        while (constraint != 0) {
            for (int i = 0; i < o; i++) {
                for (int j = 0; j < o; j++) {
                    if (sarr[i] == ratio[j]) {
                        if (constraint >= w[j]) {
                            constraint = constraint - w[j];
                            s[j] = 1;
                        }
                        else {
                            s[j] = (double) constraint / w[j];
                            constraint = 0;
                        }
                        break;
                    }
                }
            }
        }

        System.out.println("Printing all the arrays:");
        System.out.println("o array: ");
        for (int i = 0; i < o; i++)
            System.out.print("\t" + (i+1));

        System.out.println("\np array: ");
        for (int i = 0; i < o; i++)
            System.out.print("\t" + p[i]);

        System.out.println("\nw array: ");
        for (int i = 0; i < o; i++)
            System.out.print("\t" + w[i]);

        System.out.println("\ns array: ");
        for (int i = 0; i < o; i++)
            System.out.print("\t" + s[i]);
        System.out.println("");
    }
}