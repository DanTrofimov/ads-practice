import java.util.Scanner;

public class Marsohod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    f[i][j] = a[i][j];
                }
                else if (i == 0){
                    f[i][j] = f[i][j - 1] + a[i][j];
                }
                else if (j == 0){
                    f[i][j] = f[i - 1][j] + a[i][j];
                } else f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]) + a[i][j];
            }
        }
        System.out.println(f[n - 1][n - 1]);
    }
}
