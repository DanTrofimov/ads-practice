import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int[] arrPrice = new int[]{1, 3, 3, 3, 3, 3, 3, 6, 6, 8, 10, 11};
        int result = Arrays.binarySearch(arrPrice, 3);
        int result1 = lowerBound(arrPrice, arrPrice.length, 5);
        System.out.println(result);
//        while (result < 5 && arrPrice[result] == arrPrice[result + 1]) {
//            result++;
//        }
        System.out.println(result1);
    }

    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
