import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] perm = new int[len];
        for (int i = 0; i < len; i++) {
            perm[i] = i+1;
        }
        for (int i = 0; i < calculateFactorial(len); i++){
            for (int j = 0; j < len; j++) {
                System.out.print(perm[j] + " ");
            }
            System.out.println();
            perm = nextPerm(perm);
        }
    }

    public static int[] nextPerm(int[] perm) {
        for (int i = perm.length-1; i > 0; i--) {
            if (perm[i-1] < perm[i]) {
                int pivot = i;
                for (int j = pivot; j < perm.length; j++) {
                    if (perm[j] <= perm[pivot] && perm[i-1] < perm[j]) {
                        pivot = j;
                    }
                }
                int t = perm[i-1];
                perm[i-1] = perm[pivot];
                perm[pivot] = t;
                for (int j = perm.length - 1; i < j; i++, j--) {
                    int k = perm[i];
                    perm[i] = perm[j];
                    perm[j] = k;
                }
                return perm;
            }
        }
        return perm;
    }

    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
