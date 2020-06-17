public class SearchAlgs {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 4, 6, 9};
        System.out.println(binarySearch(nums, 5));
        System.out.println(binarySearch(nums, 6));
    }

    // линейный поиск (для любых подойдет)
    // по памяти M = O(1), по времени T = O(n)
    public static int linearSearch(int[] nums, int num) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                result = i;
            }
        }
        return result;
    }

    // бинарный поиск (робит только с отсортированными структурами)
    // по памяти M = O(1), по времени T = O(logn)
    public static int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;
        int result = -1;
        while (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] == num) {
                result = middle;
                break;
            }
            if (nums[middle] > num) {
                right = middle - 1;
            } else left = middle + 1;
        }
        return result;
    }
}
