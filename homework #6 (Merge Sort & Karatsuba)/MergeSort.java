import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 1, 3, 4, 2, 5, 7, 6, 8};
        int[] array1 = {3, 1, 9, 4, 2, 7, 5, 6, 8};
        mergeSortRecursion(array);
        System.out.println(Arrays.toString(array));
        mergeSortIterative(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.equals(array, array1));
    }

    public static void mergeSortRecursion(int[] array) {
        int arrayLength = array.length;
        if (array.length < 2) return;
        int middle = arrayLength / 2;
        int[] l = new int[middle];
        int[] r = new int[arrayLength - middle];
        l = Arrays.copyOfRange(array, 0, middle);
        r = Arrays.copyOfRange(array, middle, arrayLength);
        mergeSortRecursion(l);
        mergeSortRecursion(r);
        merge(array, l, r);
    }

    public static void merge(int[] array, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            }
            else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }

    public static void mergeSortIterative(int[] arr) {
        int len = arr.length;
        int n = 1; // длина массива, для merge
        int moveTo; // сдвиг в перебираемом массиве
        int arr2Size; // количество элементов для 2-го массива
        int[] arr2 = new int[arr.length];
        while (n < len) {
            moveTo = 0;
            while (moveTo < len) {
                if (moveTo + n >= len) break;
                arr2Size = (moveTo + n * 2 > len) ? (len - (moveTo + n)) : n;
                merge(arr2, Arrays.copyOfRange(arr, moveTo, moveTo + n),
                        Arrays.copyOfRange(arr, moveTo + n, moveTo + n + arr2Size));
                for (int i = 0; i < n + arr2Size; i++) arr[moveTo + i] = arr2[i]; // замена на отсортированное
                moveTo += n * 2;
            }
            n *= 2;
        }
    }
}
