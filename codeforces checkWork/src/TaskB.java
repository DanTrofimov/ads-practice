import java.util.Scanner;

public class TaskB {
    static int counter = 0;
    static int n;
    static int d;
    static String str;;

    static int checkNum(int num) {
        if (num + d >= n - 1) {
            if (num != n - 1)
                counter++;
            if (str.charAt(n - 1) == '1')
                return 0;
            return -1;
        } else {
            for (int i = num + d; i > num; i--) {
                if (str.charAt(i) == '1') {
                    counter++;
                    return checkNum(i);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        str = sc.next();
        if (checkNum(0) != -1)
            System.out.println(counter);
        else
            System.out.println(-1);
    }
}