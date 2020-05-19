import java.util.Scanner;

public class Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] fence = new int[n];
        for (int i = 0; i < n; i++) {
            fence[i] = sc.nextInt();
        }
        long min = 0;
        long index = 1;
        for (int i = 0; i < k; i++) {
            min +=  fence[i];
        }
        long sum = min;
        for (int i = k; i < n; i++) {
            long tmp = min;
            min = Math.min(min, sum - (long) fence[i-k] + (long) fence[i]);
            sum = sum - (long) fence[i-k] + (long) fence[i];
            if (min < tmp) index = i - k + 2;
        }
        System.out.println(index);
    }
}
