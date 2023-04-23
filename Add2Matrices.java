import java.util.*;

public class Add2Matrices {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of rows of matrix: ");
        int m = sc.nextInt();
        System.out.println("Enter number of columns of matrix: ");
        int n = sc.nextInt();

        int matrix1[][] = new int[m][n];
        int matrix2[][] = new int[m][n];
        int sum[][] = new int[m][n];

        System.out.println("Input for matrix_1: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Input for matrix_2: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        // calculate sum of 2 matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        System.out.println("Sum of the matrices: ");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
