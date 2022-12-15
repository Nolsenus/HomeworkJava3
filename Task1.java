import java.util.Arrays;

public class Task1 {

    static void mergeSort(int[] array) {
        int[][] elements = splitArray(array);
        while (elements.length > 1) {
            elements = mergeArrays(elements);
        }
        System.arraycopy(elements[0], 0, array, 0, array.length);
    }

    static int[][] splitArray(int[] array) {
        int[][] result = new int[array.length][1];
        for (int i = 0; i < array.length; i++) {
            result[i] = new int[] {array[i]};
        }
        return result;
    }

    static int[][] mergeArrays(int[][] arrays) {
        int[][] result = new int[arrays.length / 2 + arrays.length % 2][];
        for (int i = 0; i < arrays.length / 2; i++) {
            result[i] = sortedMerge(arrays[2 * i], arrays[2 * i + 1]);
        }
        if (arrays.length % 2 == 1) {
            result[result.length - 1] = arrays[arrays.length - 1];
        }
        return result;
    }

    static int[] sortedMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int resultIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) {
                result[resultIndex] = a[aIndex++];
            } else {
                result[resultIndex] = b[bIndex++];
            }
            resultIndex++;
        }
        while (aIndex < a.length) {
            result[resultIndex++] = a[aIndex++];
        }
        while (bIndex < b.length) {
            result[resultIndex++] = b[bIndex++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {3, 2, 4, 5, 1, 8, 9, 7, 6};
        mergeSort(test);
        System.out.println(Arrays.toString(test));
    }
}
