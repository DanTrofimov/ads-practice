import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Billion5 {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextPiece() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextPiece());
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out, true);
        br = new BufferedReader(new InputStreamReader(System.in));
        // количество неаселенных пунктов
        int n = nextInt();
        // население
        int s = nextInt();
        double radius;
        int x,y;
        SortedMap<Double, Integer> sortedRadius = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            x = nextInt();
            y = nextInt();
            radius = Math.sqrt(x*x + y*y);
            // население пункта
            x = nextInt();
            // население предыдущего пункта
            if (sortedRadius.keySet().contains(radius)) {
                sortedRadius.put(radius, x + sortedRadius.get(radius));
            } else sortedRadius.put(radius, x);
        }
        boolean flag = true;
        int currentSum = 0;
        for (double key : sortedRadius.keySet()) {
            currentSum += sortedRadius.get(key);
            sortedRadius.put(key, currentSum);
        }
        for (double key : sortedRadius.keySet()) {
            if (s + sortedRadius.get(key) >= 1000000) {
                pw.println((double) key);
                flag = false;
                break;
            }
        }
        if (flag) pw.println(-1);
    }
}
