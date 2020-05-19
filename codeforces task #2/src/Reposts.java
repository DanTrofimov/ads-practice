import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Reposts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        // map хранит значения [имя - длина цепочки, которая кончается на это имя]
        Map<String, Integer> names = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String name1 =  sc.next().toLowerCase();
            sc.next();
            String name2 = sc.next().toLowerCase();
            if (name2.equals("polycarp")) {
                names.put(name1, 2);
            }
            if (names.containsKey(name2)) {
                int len = names.get(name2);
                names.put(name1, len + 1);
            }

        }
        int max = 0;
        Iterator<Integer> iter = names.values().iterator();
        while (iter.hasNext()) {
            int next = iter.next();
            if (next > max) {
                max = next;
            }
        }
        System.out.println(max);
    }
}
