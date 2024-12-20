import java.util.Scanner;
public class OptimalMerging {
    public static int[] sort (int ar[]){
        for (int i = 0;i<ar.length-1;i++){
            for (int j = 0;j<ar.length-i-1;j++){
                if (ar[j]>ar[j+1]){
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
        return ar;
    }

    public static void sortByMerging(int a[], int b[]){
        int sa[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j])
                sa[k++] = a[j++];
            else
                sa[k++] = b[i++];
        }
        while (i < a.length)
            sa[k++] = a[i++];

        while (j < b.length)
            sa[k++] = b[j++];

        System.out.println("Merged array:");
        for (int x : sa)
            System.out.print(x + " ");
    }

    public static void compare(int size[], int a1[], int a2[], int a3[], int a4[]){
        for (int i = 0;i<size.length;i++){
            for (int j = 0;j<=i;j++){

            }
        }
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int a1[] = new int[7];
        System.out.println("Enter the elements of first array : ");
        for (int i = 0;i<a1.length;i++)
            a1[i] = sc.nextInt ();

        int a2[] = new int[4];
        System.out.println("Enter the elements of second array : ");
        for (int i = 0;i<a2.length;i++)
            a2[i] = sc.nextInt ();

        int a3[]= new int[9];
        System.out.println("Enter the elements of third array : ");
        for (int i = 0;i<a3.length;i++)
            a3[i] = sc.nextInt ();

        int a4[] = new int[5];
        System.out.println("Enter the elements of fourth array : ");
        for (int i = 0;i<a4.length;i++)
            a4[i] = sc.nextInt ();

        int size[] = {a1.length, a2.length, a3.length, a4.length};
        sort (size);

        compare(size,a1,a2,a3,a4);
    }
}
