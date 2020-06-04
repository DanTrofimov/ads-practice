import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class FastScanner {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() { return Integer.parseInt(nextToken()); }

    static long nextLong() { return Long.parseLong(nextToken()); }

    static double nextDouble() { return Double.parseDouble(nextToken()); }

    static String nextLine() throws IOException { return br.readLine(); }

    static char nextChar() throws IOException { return (char) br.read(); }

    static String next() { return nextToken(); }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }

    static void run() throws IOException {
        int n = nextInt();
        pw.println(n);
        double d = nextDouble();
        pw.println(d);
        long l = nextLong();
        pw.print(l);
        String word = next();
        pw.println(word);
        String line = nextLine();
        pw.print(line);
        char c = nextChar();
        pw.print(c);
    }

}
