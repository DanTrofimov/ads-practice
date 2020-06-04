import java.math.BigInteger;
import java.util.Scanner;

public class Coridor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // длина коридора
        int a = sc.nextInt(); // количество 1х1 плиток
        int b = sc.nextInt(); // количество 1х3 плиток
        int maxAmountThree = b;
        while (maxAmountThree * 3 > n) {
            maxAmountThree--;
        }
        BigInteger count = new BigInteger("0");
        int currentAmountOne = 0;
        while (b >= 0) {
            if ((a + b*3) < n) break;
            currentAmountOne = n - maxAmountThree * 3;
            if (a >= currentAmountOne) {
                count = count.add(factorial(maxAmountThree + currentAmountOne).divide(factorial(maxAmountThree).multiply(factorial(currentAmountOne))));
                maxAmountThree--;
            } else break;
        }
        System.out.println(count.mod(BigInteger.valueOf(1000000009)).toString());
    }

    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);
        for (long factor = 2; factor <= (long) number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }
}
