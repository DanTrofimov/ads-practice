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
        ArrayList<String> chats = new ArrayList<>();
//        Stack<String> chats = new Stack<>();
        String chat;
        for (int i = 0; i < n; i++) {
            chat = nextLine();
            if (chats.contains(chat)) {
                chats.remove(chat);
                chats.add(chats.size(), chat);
            } else chats.add(chat);
        }
        for (int i = chats.size() - 1; i >=0; i--) {
            pw.println(chats.get(i));
        }
    }
}
