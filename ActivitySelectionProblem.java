import java.util.Scanner;
public class ActivitySelectionProblem {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the no: of activities : ");
        int n = sc.nextInt ();
        char a[] = new char[n];
        int s[] = new int [n], e[] = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = (char)(65+i);
            System.out.print("Starting Time for "+a[i]+" : ");
            s[i] = sc.nextInt ();
            System.out.print("Ending Time for "+a[i]+" : ");
            e[i] = sc.nextInt ();
        }
        int iet = e[0];
        System.out.print(a[0]+"-> "+s[0]+" to "+e[0]+"\n");
        for(int i = 1;i<n;i++)
            if (s[i]>iet){
                iet = e[i];
                System.out.print(a[i]+"-> "+s[i]+" to "+e[i]+"\n");
            }
    }
}