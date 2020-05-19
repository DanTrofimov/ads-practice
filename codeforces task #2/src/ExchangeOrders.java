import java.util.*;

public class ExchangeOrders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int s = sc.nextInt();
        Map <Integer, Integer> S = new TreeMap<>();
        Map <Integer, Integer> B = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            String str = sc.next();
            int price = sc.nextInt();
            int amount = sc.nextInt();
            if (str.equals("S")) {
                if (S.containsKey(price)) {
                    S.put(price, S.get(price) + amount);
                } else S.put(price, amount);
            } else if (B.containsKey(price)) {
                B.put(price, B.get(price) + amount);
            } else B.put(price, amount);
        }
        NavigableSet<Integer> keysS = (NavigableSet<Integer>) S.keySet();
        NavigableSet<Integer> keysB = (NavigableSet<Integer>) B.keySet();
        while(keysS.size() > s) {
            keysS.pollLast();
        }
        for (int i = 0; i < s; i++) {
            if (!keysS.isEmpty()) {
                int key = keysS.last();
                System.out.println("S" + " " + key + " " + S.get(key));
                keysS.pollLast();
            }
        }
        for (int i = 0; i < s; i++) {
            if (!keysB.isEmpty()) {
                int key = keysB.last();
                System.out.println("B" + " " + key + " " + B.get(key));
                keysB.pollLast();
            }
        }
    }
}