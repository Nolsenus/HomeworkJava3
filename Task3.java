import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {

    static int getListSize(Scanner in) {
        System.out.print("Введите размер списка: ");
        int size;
        while (true) {
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не целое число. Попробуйте снова: ");
                in.nextLine();
            }
            size = in.nextInt();
            if (size >= 0) {
                break;
            }
            System.out.print("Размер списка должен быть больше или равен нулю. Попробуйте снова: ");
            in.nextLine();
        }
        return size;
    }

    static List<Integer> getRandomList (int size) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(0, 10));
        }
        return list;
    }

    static int getMin(List<Integer> list, boolean useBuiltIns) {
        if (list.size() == 0) {
            return 0;
        }
        if (useBuiltIns) {
            return Collections.min(list);
        }
        int min = list.get(0);
        int elem;
        for (int i = 1; i < list.size(); i++) {
            elem = list.get(i);
            if (elem < min) {
                min = elem;
            }
        }
        return min;
    }

    static int getMax(List<Integer> list, boolean useBuiltIns) {
        if (list.size() == 0) {
            return 0;
        }
        if (useBuiltIns) {
            return Collections.max(list);
        }
        int max = list.get(0);
        int elem;
        for (int i = 1; i < list.size(); i++) {
            elem = list.get(i);
            if (elem > max) {
                max = elem;
            }
        }
        return max;
    }

    static double getAverage(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (int elem : list) {
            sum += elem;
        }
        return sum / list.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = getListSize(in);
        in.close();
        List<Integer> list = getRandomList(size);
        System.out.println(list);
        System.out.printf("Минимум (встроенная функция): %d\n", getMin(list, true));
        System.out.printf("Минимум (написанный код): %d\n", getMin(list, false));
        System.out.printf("Максимум (встроенная функция): %d\n", getMax(list, true));
        System.out.printf("Максимум (написанный код): %d\n", getMax(list, false));
        System.out.printf("Среднее арифметическое (написанный код): %f\n", getAverage(list));
    }
}
