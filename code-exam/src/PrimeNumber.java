public class PrimeNumber {
    // массив с метками прсототы чисел
    public static boolean[] primes;

    public static void main(String[] args) {
        primes = new boolean[10000000];
    }

    // O(n)
    public static boolean isPrime(int num) {
        if (num != 2) {
            for (int i = 2; i < Math.round(Math.sqrt(num)) + 1; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        } else return false;
        return true;
    }

    // решето Эратосфена
    // рассматриваем число, проверяем на простоту, но независимо от того,
    // простое или нет, все числа кратные данному - не простые
    // как сумма гармонисеского ряда O(blogb)
    public static int amountOfPrimes(int a, int b) {
        int amount = 0;
        for (int i = 2; i < b; i++) {
            primes[i] = true;
        }
        for (int i = 2; i < b; i++) {
            if (primes[i]) {
                amount++;
                for (int j = 2*i; j <= b; j+=i) {
                    primes[j] = false;
                }
            }
        }
        return amount;
    }
}
