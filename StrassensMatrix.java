//Strassen's Matrix Multiplication
public class StrassensMatrix {
    public static void main (String[]args){
        int a[][]={
                {1, 2},
                {3, 4}
        };
        System.out.println("Matrix A : ");
        for (int i[] : a) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int b [][]={
                {2, 4},
                {6, 8}
        };
        System.out.println("Matrix B : ");
        for (int i[] : b) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int c [][]= new int[2][2];
        int p1 = (a[0][0]+a[1][1])*(b[0][0]+b[1][1]);
        int p2 = (a[1][0]+a[1][1])*b[0][0];
        int p3 = a[0][0]*(b[0][1]-b[1][1]);
        int p4 = a[1][1]*(b[1][0]-b[0][0]);
        int p5 = (a[0][0]+a[0][1])*b[1][1];
        int p6 = (a[1][0]-a[0][0])*(b[0][0]+b[0][1]);
        int p7 = (a[0][1]-a[1][1])*(b[1][0]+b[1][1]);

        c[0][0] = p1 + p4 - p5 + p7;
        c[0][1] = p3 + p5;
        c[1][0] = p2 + p4;
        c[1][1] = p1 + p3 - p2 + p6;

        System.out.println("Matrix C (A * B) : ");
        for (int i[] : c) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
