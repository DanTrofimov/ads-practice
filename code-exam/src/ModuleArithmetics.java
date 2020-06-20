public class ModuleArithmetics {
    public static void main(String[] args) {

    }

    // возведение в степень в модульной арифметике
    // по времени T = O(logb)
    public static int pow2(int a, int b, int p) {
        int result;
        if (b == 1) {
            result = a % p;
        } else if (b % 2 == 1) {
            result = (a % p * pow2(a, b-1, p)) % p;
        } else {
            int x = pow2(a, b/2, p);
            result = (x*x) % p;
        }
        return result;
    }

    // GCD - greatest common divisor
    // по времени T = O(log(max*(a,b))
    public static int greatestDiv(int a, int b) {
        while (b != 0) {
            int x = a % b;
            a = b;
            b = x;
        }
        return a;
    }

    // LCM - least common multiple
    // по времени T = O(log(max(a,b)))
    public static int leastMult(int a, int b) {
        return a*b / greatestDiv(a,b);
    }
}
