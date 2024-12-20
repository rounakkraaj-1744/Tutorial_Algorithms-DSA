//Maximum sum of the subarray
import java.util.Scanner;
public class SlidingWindow {

    public static int slideSum (int a[], int size){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum = sum + a[i];

        for (int i = size; i < a.length; i++) {
            sum = sum + a[i] - a[i-size];
            max = Math.max (max, sum);
        }
        return max;
    }

    public static void main (String...args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.print("Enter the size of the window : ");
        int size = sc.nextInt ();

        int sum = slideSum (a, size);
        System.out.println("Maximum sum of the sub array = "+sum);
    }
}
