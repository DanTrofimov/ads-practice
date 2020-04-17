import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Chat7 {
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

    static String nextLine() throws IOException {
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out, true);
        br = new BufferedReader(new InputStreamReader(System.in));
        // количество чатов
        int n = nextInt();
        String singleChat;
        LinkedHashSet<String> resultChats = new LinkedHashSet<String>();
        String[] inputChats = new String[n];
        for(int i=n-1; i>=0; i--){
            singleChat = nextLine();
            inputChats[i] = singleChat;
        }
        for(int i=0; i<n; i++){
            resultChats.add(inputChats[i]);
        }

        for (String chat : resultChats) {
            pw.println(chat);
        }
    }
}