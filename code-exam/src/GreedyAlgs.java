public class GreedyAlgs {
    public static void main(String[] args) {

    }

    // TODO: разобрать код
    // задача о выборе заявок
    // по времени T = O(nlogn), по памяти  = O(1)
    public static int requestOptimal(int[] f, int[] s) {
        int len = s.length;
        sort(f,s);
        int j = 0;
        int count = 1;
        for (int i = 1; i < len; i++)
            if (s[i]>=f[j]){
                count++;
                j = i;
            }
        return count;
    }

    // метод сортировки заявок по времени начала
    public static void sort(int[] s, int f[]) {
        int len = s.length;
        for (int i = 0; i < len - 1; i++) {
        for (int j = i; j < len; j++) {
                if (s[i] > s[j]) {
                    int temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                }
            }
        }
    }

    // TODO: разобрать код
    // задача о покрытии отрезков
    // по времени T = O(nlogn), по памяти M = O(1)
    public static int coverSection(int[] s, int f[]) {
        int len = s.length;
        int j = f[0];
        int count = 1;
        for (int i = 1; i < len; i++)
            if (s[i]>j) {
                count++;
                j = f[i];
            }
        return count;
    }
}
