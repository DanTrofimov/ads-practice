public class StringProcessing {
    public static void main(String[] args) {

    }

    // hash + fingerprinting
    // по времени T = O(n)
    public static boolean hashEquals(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        long[] s1L = new long[s1.length()];
        long[] s2L = new long[s2.length()];
        for (int i = 0;i<s1.length();i++){
            s1L[i] = s1.substring(0,i).hashCode();
            s2L[i] = s2.substring(0,i).hashCode();
        }
        long[] pow = new long[s1.length()];
        long[] hs1 = new long[s1.length()];
        long[] hs2 = new long[s2.length()];
        long p = (long) Math.pow(2,64)+ 1;
        pow[0] = 1;
        for (int i = 1; i < s1.length(); i++) {
            pow[i] = pow[i - 1] * p;
        }
        hs1[0] = s1L[0];
        for (int i = 1; i < s1.length(); i++) {
            hs1[i] = hs1[i - 1] + pow[i] * s1L[i];
        }
        hs2[0] = s2L[0];
        for (int i = 1; i < s2.length(); i++) {
            hs2[i] = hs2[i - 1] + pow[i] * s2L[i];
        }

        if ((hs1[s1.length()-1])==(hs2[s2.length()-1])){
            return true;
        } else {
            return false;
        }
    }

    // алгоритм рабина-карпа
    // по времени
}
