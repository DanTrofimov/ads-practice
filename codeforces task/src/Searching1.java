import java.util.Arrays;
import java.util.Scanner;

public class Searching1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        // считали первую последовательность
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        // считали вторую последовательность
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int result = Arrays.binarySearch(arr, arr2[i]);
            if (result < 0) {
                arr2[i] = Math.abs(result) - 1;
            } else {
                while (result > 0 && arr[result-1] == arr[result]) {
                    result--;
                }
                arr2[i] = result + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
