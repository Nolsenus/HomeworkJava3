import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {

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

    static void removeEven(List<Integer> list) {
        list.removeIf(element -> element % 2 == 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = getListSize(in);
        in.close();
        List<Integer> list = getRandomList(size);
        System.out.println(list);
        removeEven(list);
        System.out.println(list);
    }
}
