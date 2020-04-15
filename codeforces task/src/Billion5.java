import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
        // code of E
    }
}
