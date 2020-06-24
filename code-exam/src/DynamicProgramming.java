import java.util.HashSet;

public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(calcFact(5));
        for (int i = 0; i < 5; i++) {
            System.out.println(calcFib(i));
        }
    }
    // к вопросу о комбинаторике, fib и fact - типичные примеры
    public static int calcFact(int num) {
        if (num < 0) return -1;
        if (num == 0) return 0;
        if (num == 1) return 1;
        return num * calcFact(num-1);
    }

    public static int calcFib(int num) {
        if (num == 1 || num == 0) return 1;
        return calcFib(num - 1) + calcFib(num - 2);
    }
    // (перебор)
    // задача суммы подмножества (без побитовых операций)
    // представляем всевозможное количество комбинаций как 2^n
    // w = subset определенное число от 0 до 2^n (какой-то один набор из множества двоичных чисел от 0 до 2^n длинной n)
    // 1 в этом наборе означает, что мы добавлям в сумму число, 0 - не добаляем
    // потом сумма сравнивается с требуемым числом
    // по времени T = O(n2^n), по памяти M = O(1)
    public static boolean findSum(int[] nums, int num) {
        int subsetAmount = 1, sum, len = nums.length;
        for (int i = 0; i < len; i++) {
            subsetAmount*=2;
        }
        for (int subset = 0; subset < subsetAmount; subset++) {
            int w = subset;
            sum = 0;
            for (int i = 0; i < len; i++) {
                if (w % 2 != 0) sum+=nums[i];
                w = w/2;
            }
            if (sum == num) {
                return true;
            }
        }
        return false;
    }
    // (перебор)
    // задача суммы подмножества с побитовыми сдвигами
    public static boolean findSumBit(int[] nums, int num) {
        int subsetAmount = 1;
        int sum;
        int len = nums.length;
        subsetAmount = 1<<len;
        for (int subset = 0; subset < subsetAmount; subset++) {
            sum = 0;
            for (int i = 0; i < len; i++) {
                int result = subset & 1<<i;
                if (result != 0) sum+=nums[i];
            }
            if (sum == num) {
                return true;
            }
        }
        return false;
    }
    // (перебор)
    // задача о расстановке ферзей (метод ветвей и границ, "отрезание" многих недостижимых случаев)
    // здесь у каждого ферзя x - его столбец, y[x] - строка
    // по времени T < O(n!), по памяти M = O(1)
    public static void putQueen(int x, int[] y) {
        Counter.counter = 0;
        if (x == 8) {
            Counter.counter++;
        } else {
            for (y[x] = 0; y[x] < 8; y[x]++) {
                if (correct(x, y)) putQueen(x+1, y);
            }
        }
    }

    public static boolean correct(int x, int[] y) {
        for (int x1 = 0; x1 < x; x1++) {
            if (y[x1] == y[x] || Math.abs(x-x1) == Math.abs(y[x]-y[x1])) return false;
        }
        return true;
    }

    private static class Counter {
        private static int counter;

        public Counter() {
            counter = 0;
        }
    }

    // задача о кузнечике
    // для входного n, количество путей будет равно calcAmountOfWays(n+3)
    // по времени T = O(n)
    public static int calcAmountOfWays(int num) {
        // дефолтные значения
        switch (num) {
            case 0: // -3 ячейка
            case 1: // -2 ячейка
            case 2: // -1 ячейка
                return 0;
            case 3: //  0 ячейка
                return 1;
            default:
                return calcAmountOfWays(num-1)
                        + calcAmountOfWays(num-2)
                        + calcAmountOfWays(num-3)
                        + calcAmountOfWays(num-4);
        }
    }

    // задача о черепашке
    // по времени T = O(nm)
    public static int turtleResult(int n, int m, int[][] amount) {
        int[][] field = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                field[i][j] = Math.max(field[i-1][j], field[i][j-1]) + amount[i][j];
            }
        }
        return field[n-1][m-1];
    }

    // TODO: разобрать в целом работу (10 лекция)
    // сумма подмножества с булевой матрицей
    // по времени T = o (nums.length * num), по памяти M = O(num)
    public static boolean subsetBoolFibd(int[] nums, int num) {
        boolean[][] fieldBool = new boolean[2][num];
        fieldBool[0][0] = true;
        int p = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int s = 0; s <= num; s++) {
                fieldBool[p][s] = fieldBool[1-p][s];
                if (s - nums[i] >= 0) {
                    fieldBool[p][s]= fieldBool[p][s] || fieldBool[1-p][s-nums[i]];
                }
            }
            p = 1 -p;
        }
        return fieldBool[0][num] || fieldBool[1][num];
    }

    // сумма подмножеств через set'ы
    // заглушка :), код есть в презентации

    // сумма подмножества с балансом дп и перебора
    // meet-in-the-middle решаем задачу "попалам", после чего сравниваем
    // результаты обеих половин T = o (2^(n/2)*n)
    public static boolean subsetBalance(int[] nums, int num) {
        int n21 = 1<<(nums.length - 1);
        HashSet<Integer> ts = new HashSet<>();
        for (int q = 0; q < n21; q++) {
            int t = 0;
            for (int i = 0; i < nums.length/2; i++) {
                int result = q & 1<<i;
                if (result  != 0) t += nums[i];
                ts.add(t);
            }
        }
        for (int q = 0; q < n21; q++) {
            int r = 0;
            for (int i = nums.length/2 + 1; i < nums.length; i++) {
                int result = q & 1<<i;
                if (result != 0) r = nums[i];
            }
            if (ts.contains(num - r)) return true;
        }
        return false;
    }

    // задача о черепашке
    // юзаем кеширование (мемоизация), запоминание результатов
    // предыдущих вычислений T = O(nm)
    public static int calcTurtle(int n, int m, int[][] amounts) {
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j]=Math.max(field[i-1][j],field[i][j-1])+amounts[i][j];
            }
        }
        return field[n-1][m-1];
    }
}
