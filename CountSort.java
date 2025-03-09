/*
 * Non-comparison sorting algorithm
 * mostly for smaller numbers
 */
import java.util.Arrays;
public class CountSort{
    public static void main(String[] args) {
        int a[] = {3, 4, 1, 3, 2, 5, 2};
        System.out.println("Array before sorting : ");
        for (int i:a)
            System.out.print(i+" ");
        
        System.out.println();

        //1. find the largest number
        int max = Arrays.stream(a).max().orElseThrow();

        //2. create a frequency array of size=largest+1
        int arr[] = new int[max+1];
        Arrays.fill(arr, 0);

        //3. Take the index of freq array as elements of original array and store the frequency
        for (int i : a)
            arr[i]++;

        // Now implementing count sort
        int index=0;
        for (int i = 0;i<arr.length;i++){
            while(arr[i]>0){
                a[index++] = i;
                arr[i]--;
            }
        }
        System.out.println("Array after sorting: ");
        for (int i:a)
            System.out.print(i+" ");
    }
}