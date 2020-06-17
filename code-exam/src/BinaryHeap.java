import java.util.ArrayList;

public class BinaryHeap {
    // мне лень реализовывать эту структуру данных...)
    // основная идея, parent < child
    int amountOfElements = 0;
    int[] elements = new int[10000];

    // абстрактный метод добавления элемента
    // (закидывается в конец и после сравнивается с родительскими элементами)
    // по времени T = O(h), h - высота дерева, по памяти M = O(1)
    public void addElement(int item) {
        elements[amountOfElements] = item;
        amountOfElements++;
        int i = amountOfElements - 1;
        while (i != 0 && elements[i] < elements[(i-1)/2]) {
            SortingAlgs.swapItems(i, (i-1/2), elements);
            i = (i-1)/2;
        }
    }

    public void addElementNewVersion(int item) {
        elements[amountOfElements] = item;
        amountOfElements++;
        int i = amountOfElements - 1;
        while (i != 0 && elements[i] > elements[(i-1)/2]) {
            SortingAlgs.swapItems(i, (i-1/2), elements);
            i = (i-1)/2;
        }
    }

    // абстрактный метод удаления корневого (минимального) элемента
    /*
    меняем местами минимальный элемент и последний, удаляем минимальный
    переносим последний на правильное место
     */
    // по времени T = O(h) = O(logn), по памяти M = O(1)
    public int removeMinElement() {
        int result = elements[0];
        SortingAlgs.swapItems(0, elements.length - 1, elements);
        amountOfElements--;
        int i = 0, m = 2*i + 1;
        if (m + 1 < amountOfElements && elements[i] > elements[m]) {
            SortingAlgs.swapItems(i, m, elements);
            i = m;
            m = 2*i + 1;
            if (m + 1 < amountOfElements && elements[m] > elements[m+1]) m++;
        }
        return result;
    }

    public int removeMaxElement() {
        int result = elements[0];
        SortingAlgs.swapItems(0, elements.length - 1, elements);
        amountOfElements--;
        int i = 0, m = 2*i + 1;
        if (m + 1 < amountOfElements && elements[i] < elements[m]) {
            SortingAlgs.swapItems(i, m, elements);
            i = m;
            m = 2*i + 1;
            if (m + 1 < amountOfElements && elements[m] < elements[m+1]) m++;
        }
        return result;
    }
}
