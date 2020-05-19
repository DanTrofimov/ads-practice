import java.util.Scanner;

public class QueueShower {
    public static void main(String[] args) {
        int[][] g = new int[5][5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int n = 0; n < 5; n++) {
                        for (int m = 0; m < 5; m++) {
                            if (QueueShower.checkEquals(i, j, k, n, m)) {
                                int sum = g[i][j] + g[j][i] + g[k][n]*2 + g[n][k]*2 + g[j][k] + g[n][m]*2 + g[k][j] + g[m][n]*2;
                                if (sum > max) max = sum;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static boolean checkEquals(int i, int j, int k, int n, int m) {
        if (i == j || i == k || i ==n || i == m) {
            return false;
        } else if (j == k || j == n || j == m) {
            return false;
        } else if (k == n || k == m) {
            return false;
        } else if (n == m) {
            return false;
        }
        return true;
    }
}
