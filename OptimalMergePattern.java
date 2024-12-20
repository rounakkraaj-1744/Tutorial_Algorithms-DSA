import java.util.Comparator;
import java.util.PriorityQueue;

public class OptimalMergePattern {
    static int[] optimalMerge(int arr[][]) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < arr.length; i++)
            if (arr[i].length > 0)
                minHeap.add(new int[]{
                        arr[i][0], i, 0
                });

        int c = 0;
        for (int[] a : arr)
            c = c + a.length;

        int mergeArr[] = new int[c];
        int j = 0;

        while (!minHeap.isEmpty()) {
            int curr[] = minHeap.poll();
            int val = curr[0], arr_index = curr[1], elem_index = curr[2];

            mergeArr[j++] = val;

            if (elem_index + 1 < arr[arr_index].length)
                minHeap.add(new int[]{
                        arr[arr_index][elem_index + 1], arr_index, elem_index + 1
                });
        }
        return mergeArr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 5, 8, 12},
                {1, 6, 9},
                {3, 4, 7, 10, 11, 16},
                {14, 15, 17, 18, 19}
        };

        int sortedarr []= optimalMerge(arr);

        System.out.print("Sorted Array: ");
        for (int i : sortedarr)
            System.out.print(i + " ");
    }
}