import java.util.Arrays;

public class SortingAlgs {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 3, 2, 1, 4, 5, 1};
        mergeSortRecursion(nums);
        System.out.println(Arrays.toString(nums));
    }

    // сортировка подсчетом
    // по времени O(nums.length + amounts.length) ~ общее кол-во элементов + кол-во уникальных
    public static void countSort(int[] nums) {
        int[] amounts = new int[100]; // числа от 0 до 99
        for (int i = 0; i < nums.length; i++) {
            amounts[nums[i]]++;
        }
        int current = 0;
        for (int i = 0; i < amounts.length; i++) {
            for (int j = 0; j < amounts[i]; j++) {
                nums[current] = i;
                current++;
            }
        }
    }

    // сортировка пузырьком
    // по памяти M = O(1), по времени T = O(n^2)
    public static void bubbleSort(int[] nums) {
        for (int i = nums.length-1; i > -1; i--) {
            boolean isSwaped = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    swapItems(j, j+1, nums);
                    isSwaped = true;
                }
            }
            if (!isSwaped) break;
        }
    }

    // сортировка выбором
    // по памяти M = O(1), по времени  = O(n^2)
    public static void selectionSort (int[] nums){
        int min, temp;
        for (int index = 0; index < nums.length-1; index++) {
            min = index;
            for (int scan = index+1; scan < nums.length; scan++){
                if (nums[scan] < nums[min])
                    min = scan;
            }
            swapItems(min, index, nums);
        }
    }

    public static void swapItems(int i, int j, int[] nums) {
        int buffer = nums[j];
        nums[j] = nums[i];
        nums[i] = buffer;
    }

    // быстрая сортировка
    // по памяти M = O(1), по времени T = O(nlogn)
    private static void quickRecursion(int left, int right, int[] nums) {
        if (left >= right) return;
        int middle = nums[(left + right)/2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (nums[i] < middle) i++;
            while (nums[j] > middle) j--;
            if (i <= j) {
                swapItems(i, j, nums);
                i++; j--;
            }
        }
        if (left < j) quickRecursion(left, j , nums);
        if (i < right) quickRecursion(i, right, nums);
    }

    public static void quickSort(int[] nums) {
        quickRecursion(1, nums.length - 1, nums);
    }

    // сортировка слиянием
    // по памяти M = O(1) (в приведенном случае, но в презентации O(n), т.к.
    // там юзается доп. массив для объединенния отсортированных частей),
    // по времени T = O(nlogn)
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
            } else {
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
    // сортировка выбором с использованием двоичной кучи, более понятная мне
    // T = O(nlogn), M = O(n)
    public static void heapSort(int[] nums) {
        BinaryHeap heap = new BinaryHeap();
        // закидываем элементы
        for (int i = 0; i < nums.length; i++) {
            heap.addElement(nums[i]);
        }
        // поочередно присваиваем минимумы итоговому массиву
        for (int i = 0; i < nums.length; i--) {
            nums[i] = heap.removeMinElement();
        }
    }

    // сортировка выбором с использованием двоичной кучи
    // модифицировали ее по памяти и по итогу имеем
    // T = O(nlogn), M = O(1)
    public static void heapSortModified(int[] nums) {
        // не храним кучу
        // https://www.youtube.com/watch?v=UuDjR4upgg8&list=PL5cBwNxdeNv3-7PSnzS8fv0BWdC3Gbdca&index=5
    }

    /*
    по итогу юзаем:
    heapSort - когда много эл-ов и O(1) не критична
    иначе mergeSort или qSort
    countSort - ограниченная уникальность элементов в массиве, будет самой эффективной
    усредненные по эффективности - bubbleSort и selectSort
     */
}
