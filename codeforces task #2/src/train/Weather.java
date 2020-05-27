package train;

import java.util.Scanner;

public class Weather {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int max = 0;
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            int temp = sc.nextInt();
            if (temp < 0 && (temp % 2 == 0)) {
                counter++;
            } else counter = 0;
            if (counter > max) {
                max = counter;
            }
        }
        System.out.println(max);
    }
}
