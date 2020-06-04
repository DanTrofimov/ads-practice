import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Words6 {
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

    static String nextLine() throws IOException { return br.readLine(); }

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out, true);
        br = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        // число слов Польшара
        int n = nextInt();
        // число слов Врагошара
        int m = nextInt();
        // слова Польшара и Врагошара
        ArrayList<String> currentWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            currentWords.add(nextLine());
        }
        String test;
        for (int i = 0; i < m; i++) {
            test = nextLine();
            if (currentWords.contains(test)) {
                counter++;
            }
            currentWords.add(test);
        }
        if (counter % 2 != 0) {
            n += 1;
        }
        if (n > m) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
