import java.util.Stack;

public class DataStructures {
    public static void main(String[] args) {
    }

    // FIXME: тут инфа про set и map
    // с set все очевидно
    // характеристический весктор ~ булевый массив
    // можно поделить на группы отностельно результата хэш-функции

    // с map все тоже очевидно
    // хэшируются ключи

    // экономия места - хэш таблицы

    // высоста бинарных дереьев поиска от n элементов h = logn

    // FIXME: тут инфа и линейных структурах данных
    // массивы
    // связные списки (проигрывают массивам только по доступу к элементу)
    // очередь FIFO - можно моделировать с помощью двух стеков
    // ( а) - для очереди минимумов, б) - для обычной имитации очереди)
    // дека (deque) - очередь с возможностью добавления и удаления с двух концов

    // стек FILO
    // задача о вложенности скобок (3 типа скобок)
    // в стек кидаются открывающие скобки, если встречается закрывающие
    // то они сравниваются с крайним элементом стека
    public static boolean checkSequence(String hooks) {
        Stack<Character> stack = new Stack<>();
        boolean error = false;
        for (int i = 0; i < hooks.length(); i++) {
            char c = hooks.charAt(i);
            if (c == '{' ||
                c == '[' ||
                c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    error = true;
                    break;
                }
                char top = stack.pop();
                if (c == '}' && top != '}' ||
                    c == ']' && top != ']' ||
                    c == ')' && top != ')') {
                    error = true;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            error = true;
        }
        return !error;
    }

    // скобочный баланс (1 тип скобок)
    public static boolean checkSequenceOneType(String hooks) {
        int balance = 0;
        for (int i = 0; i < hooks.length(); i++) {
            if (hooks.charAt(i) == '(') balance++;
            if (hooks.charAt(i) == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    // задача о выпуклой оболочке
    // много (очень) кода, который есть в доке и презентации
    // по времени T = O(nlogn)

    
}
