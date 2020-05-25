import java.math.BigInteger;
import java.util.Arrays;

public class Karatsuba {
    public static void main(String[] args) {
        System.out.println(getBinLength(2));
        System.out.println(getBinLength(4));
        BigInteger num1 = BigInteger.valueOf(1234);
        BigInteger num2 = BigInteger.valueOf(1000);
        System.out.println(karatsuba(num1, num2));
    }

    // реализация с булевыми массивами
    private static BigInteger karatsuba(BigInteger i, BigInteger j) {
        boolean[] x = convertToBoolArray(i);
        boolean[] y = convertToBoolArray(j);

        // max длина слова
        double n = Math.max(x.length,y.length);

        if (n < 32) return i.multiply(j);

        boolean[] a = boolDiv(x, (int) Math.pow(2, Math.round(n/2)));
        boolean[] b =  boolMod(x, (int) Math.pow(2, Math.round(n/2)));
        boolean[] c = boolDiv(y, (int) Math.pow(2, Math.round(n/2)));
        boolean[] d =  boolMod(y, (int) Math.pow(2, Math.round(n/2)));

        BigInteger first = karatsuba(convertToNum(a), convertToNum(c));
        BigInteger second = karatsuba(convertToNum(b), convertToNum(d));
        BigInteger third = karatsuba(convertToNum(boolSum(a,b)),convertToNum(boolSum(c,d)));

        return  first.multiply(BigInteger.valueOf((int)Math.pow(2, Math.round(n))))
                .add((third.subtract(second).subtract(first))
                .multiply(BigInteger.valueOf((int)Math.pow(2, Math.round(n/2))))).add(second);
    }

    private static double getLength(long i) {
        String totalN = Long.toString(i);
        return totalN.length();
    }

    // длина двоичной записи
    public static int getBinLength(int num) {
        return Integer.toBinaryString(num).length();
    }

    // перевод в булевый массив
    public static boolean[] convertToBoolArray(BigInteger num) {
        char[] binChars = num.toString(2).toCharArray();
        boolean[] result = new boolean[binChars.length];
        for (int i = 0; i < binChars.length; i++) {
            switch (binChars[i]) {
                case '1':
                    result[i] = true;
                    break;
                case '0':
                    result[i] = false;
                    break;
            }
        }
        return result;
    }

    // целочисленное деление булевого массива (на число кратное 2)
    public static boolean[] boolDiv(boolean[] bool, int num) {
        return Arrays.copyOfRange(bool, 0, bool.length - getBinLength(num) + 1); // 123 / 10 = 12; 1101 / 10 = 110
    }

    // остаток от деления булевого массива (на число кратное 2)
    public static boolean[] boolMod(boolean[] bool, int num) {
        return Arrays.copyOfRange(bool, bool.length - getBinLength(num) + 1, bool.length);
    }

    // умножение булевого массива на число (кратное 2)
    public static boolean[] boolMult(boolean[] bool, int num) {
        boolean[] result = new boolean[bool.length + getBinLength(num) - 1];
        for (int i = 0; i < bool.length; i++) {
            result[i] = bool[i];
        }
        for (int i = bool.length; i < result.length; i++) {
            result[i] = false;
        }
        return result;
    }

    // сложение двух булевых массивов todo: немного переделать
    public static boolean[] boolSum(boolean[] bool1, boolean[] bool2) {
        BigInteger num1 = convertToNum(bool1);
        BigInteger num2 = convertToNum(bool2);
        BigInteger result = num1.add(num2);
        return convertToBoolArray(result);
    }

    // перевод в число (в 10сс)
    public static BigInteger convertToNum(boolean[] bool) {
        StringBuffer binStr = new StringBuffer();
        for (int i = 0; i < bool.length; i++) {
            if (bool[i]) {
                binStr.append('1');
            } else binStr.append('0');
        }
        return new BigInteger(binStr.toString(), 2);
    }
}
