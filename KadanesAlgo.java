// Kadane's Algorithm is the optimized way to find the maximum subarray of a given array
public class KadanesAlgo{
    public static void main (String[]args){
        // Taking a default array ... U can also take user input
        int a[] = {3, -4, 5, 4, -1, 7, -8};

        //brute force approach - Time Complexity = O(n^2)
        int max = 0;
        for (int s = 0;s<a.length;s++){
            int sum = 0;
            for (int e = s;e<a.length;e++){
                sum += a[e];
                max = Math.max(sum, max);
            }
        }
        System.out.println ("Maximum subarray sum using brute force : "+max);

        max = 0;//reinitialising max = 0 since i will use in the kadane's algo below

        //Kadane's Algorithm
        int sum = 0;
        for (int i = 0;i<a.length;i++){
            sum += a[i];
            max = Math.max (max, sum);
            sum = sum < 0 ? 0 : sum;
        }
        System.out.println ("Maximum subarray sum using Kadane's Algo : "+max);
    }
}