import java.util.ArrayList;
import java.util.Collections;
public class JobSequencingwithDeadline {
    char id;
    int deadline, profit;
    public JobSequencingwithDeadline(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
    static void sequence(ArrayList<JobSequencingwithDeadline> ar, int t) {
        int n = ar.size();
        Collections.sort(ar,(a, b) -> b.profit - a.profit);
        boolean accept[] = new boolean[t];
        char job[] = new char[t];
        for (int i = 0; i < n; i++) {
            int y = Math.min(t - 1, ar.get(i).deadline - 1);
            for (int j = y; j >= 0; j--) {
                if (accept[j] == false) {
                    accept[j] = true;
                    job[j] = ar.get(i).id;
                    break;
                }
            }
        }
        for (char ch : job)
            System.out.print(ch + " ");
        System.out.println();
    }
    public static void main(String[]args) {
        ArrayList<JobSequencingwithDeadline> a = new ArrayList<>();
        a.add(new JobSequencingwithDeadline('A', 1, 20));
        a.add(new JobSequencingwithDeadline('B', 2, 5));
        a.add(new JobSequencingwithDeadline('C', 4, 25));
        a.add(new JobSequencingwithDeadline('D', 1, 35));
        a.add(new JobSequencingwithDeadline('E', 2, 15));
        a.add(new JobSequencingwithDeadline('F', 3, 12));
        a.add(new JobSequencingwithDeadline('G', 2, 30));
        System.out.println("Sequence of Jobs is : ");
        sequence(a, 4);
    }
}