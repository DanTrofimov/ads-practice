import java.util.Arrays;
import java.util.Scanner;

public class Lights3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // количество фонарей
        int n = sc.nextInt();
        // длина улицы
        int l = sc.nextInt();
        int[] lights = new int[n];
        // координаты фонарей
        for (int i = 0; i < n; i++) {
            lights[i] = sc.nextInt();
        }
        // все координаты по возрастанию
        Arrays.sort(lights);
        int result = 2 * Math.max(lights[0], l - lights[n-1]);
        for (int i = 0; i < n-1; i++) {
            result = Math.max(result, lights[i + 1] - lights[i]);
        }
        System.out.print((double)result/2.0);
    }
}
