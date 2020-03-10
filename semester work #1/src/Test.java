import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] str = new String[] {"a", "A", "g", "c", "a", "A"};
        WordSet wset = new WordSet();
        wset.insert("a");
        wset.insert("a");
        wset.insert("b");
        wset.insert("b");
        wset.insert("c");
        wset.insert("d");
        wset.delete("b");
        wset.insert("A");
        wset.insert("D");
        wset.insert("A");
        wset.delete("D");
        System.out.println(wset.toString());

        System.out.println(wset.compareTo("aaa", "aab"));
        System.out.println(wset.compareTo("bbb","ccc"));
    }
}
