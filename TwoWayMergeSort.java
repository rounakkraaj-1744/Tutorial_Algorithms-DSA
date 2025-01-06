public class TwoWayMergeSort {
    static void merge (int a[], int s, int mid, int e){
        //s-> starting index (0), e->ending index (a.length-1)
        int b []= new int [a.length];
        int i = s, j = mid+1, k;

        for (k =0;i<=mid && j<=e;k++) {
            if (a[i] < a[j])
                b[k] = a[i++];
            else
                b[k] = a[j++];
        }

        while (i<=mid)
            b[k++] = a[i++];
        while (j<=e)
            b[k++] = a[j++];

        for (i=e; i>=s;i--)
            a[i] = b[--k];
    }

    static void twowaymergeSort (int a[], int s, int e){
        int mid;
        if (s<e){
            mid = s+(e-s)/2;
            twowaymergeSort(a,s,mid);
            twowaymergeSort(a,mid+1,e);
            merge(a,s,mid,e);
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 9, 6, 2, 1, 12, 7, 8, 16, 13, 11, 10};
        twowaymergeSort (a, 0, a.length-1);

        for (int i : a)
            System.out.print(i+" ");
        System.out.println();
    }
}