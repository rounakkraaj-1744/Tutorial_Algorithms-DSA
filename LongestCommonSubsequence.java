import java.util.Scanner;
public class LongestCommonSubsequence {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter two strings : ");
        String str1 = sc.next(), str2 = sc.next();
        int ar[][] = new int[str1.length ()+1][str2.length ()+1];
        for(int i=1;i<=str1.length ();i++){
            for(int j=1;j<=str2.length ();j++){
                int s = 0, ns=0; //s->select, ns->not select
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    s = 1 + ar[i-1][j-1];
                ns = Math.max(ar[i-1][j],ar[i][j-1]);
                ar[i][j] = Math.max(s,ns);
            }
        }
        System.out.println("The LCS is of "+ar[str1.length ()][str2.length ()]+" letters");
    }
}