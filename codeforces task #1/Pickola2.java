import java.util.Arrays;
import java.util.Scanner;

public class Pickola2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // количество магазинов в городе
        int n = sc.nextInt();
        int[] arrPrice = new int[n];
        // цена на напиток в каждом магазине
        for (int i = 0; i < n; i++) {
            arrPrice[i] = sc.nextInt();
        }
        Arrays.sort(arrPrice);
        // количество дней
        int q = sc.nextInt();
        int[] arrMoney = new int[q];
        // количество денег в каждый день
        for (int i = 0; i < q; i++) {
            arrMoney[i] = sc.nextInt();
        }
        // подсчет количества магазинов
        for (int i = 0; i < q; i++) {
            if (arrMoney[i] >= arrPrice[n-1]) {
                System.out.println(n);
                continue;
            }
            if (arrMoney[i] < arrPrice[0]) {
                System.out.println(0);
                continue;
            }
            int result = Arrays.binarySearch(arrPrice, arrMoney[i]);
            if (result < 0) {
                System.out.println(Math.abs(result) - 1);
            } else {
//                while (result < n-1 && arrPrice[result] == arrPrice[result+1]) {
//                    result++;
//                }
                System.out.println(upperBound(arrPrice, arrPrice.length, arrMoney[i]));
            }
        }
    }
    // найти позицию на которую при вставке элеиента не нарушиться порядок
    public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
