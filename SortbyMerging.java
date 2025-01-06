public class SortbyMerging {
    public static void main(String[] args) {
        int a[] = {10, 20, 30, 40, 50}, b[] = {5, 15, 25, 35, 45, 55, 60, 70, 80, 90};
        int sa[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            if (a[i] > b[j])
                sa[k++] = a[j++];
            else
                sa[k++] = b[i++];

        while (i < a.length)
            sa[k++] = a[i++];

        while (j < b.length)
            sa[k++] = b[j++];

        System.out.println("Merged array:");
        for (int x : sa)
            System.out.print(x + " ");
    }
}