import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Playlist4 {
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
        Scanner sc = new Scanner(System.in);
        // количество песен
        int n = nextInt();
        int[] playlist = new int[n];
        // количество моментов
        int m = nextInt();
        // сколько длится песня
        int resultTime;
        for (int i = 0; i < n; i++) {
            resultTime = nextInt();
            resultTime *= nextInt();
            playlist[i] = resultTime;
            if (i > 0) {
                playlist[i] += playlist[i-1];
            }
        }
        // моменты песен
        int moment;
        for (int i = 0; i < m; i++) {
            moment = nextInt();
            if (moment <= playlist[0]) {
                pw.println(1);
                continue;
            } else if (moment > playlist[n-2]) {
                pw.println(n);
                continue;
            }
            pw.println(lowerBound(playlist, playlist.length, moment)+1);
        }
    }
    // нижняя граница бинарным поиском (первый встречный элемент)
    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
