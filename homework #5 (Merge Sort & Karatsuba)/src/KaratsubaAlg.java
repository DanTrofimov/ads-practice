public class KaratsubaAlg {
    public static void main(String[] args) {
        System.out.println(karatsuba(12345,10000));
    }

    // обычная реализация
    private static long karatsuba(long i, long j) {
        // длина слова
        int n = getLength(Math.max(i,j));

        if (n < 32) return i*j;

        long a = (long) (i/Math.pow(2, Math.round(n/2)));
        long b = (long) (i%Math.pow(2, Math.round(n/2)));
        long c = (long) (j/Math.pow(2, Math.round(n/2)));
        long d = (long) (j%Math.pow(2, Math.round(n/2)));

        long first = karatsuba(a, c);
        long second = karatsuba(b, d);

        long third = karatsuba(a + b,c + d);

        return ((long) ((first*Math.pow(2, Math.round(n)))+((third-second-first)*Math.pow(2, Math.round(n/2)))+second));
    }

    private static int getLength(long i) {
        String totalN = Long.toString(i);
        return totalN.length();
    }
}
