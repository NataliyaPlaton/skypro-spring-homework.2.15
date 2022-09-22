package pro.sky.skyprospringhomework25;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
    int[] arr1 = generateRandomArray();
    int[] arr2 = Arrays.copyOf(arr1, 2000);
    int[] arr3 = Arrays.copyOf(arr1, 2000);

    long start1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr1));
    sortBubble(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(System.currentTimeMillis() - start1);

    long start2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr2));
    sortSelection(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(System.currentTimeMillis() - start2);


    long start3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr3));
    sortInsertion(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println(System.currentTimeMillis() - start3);


}

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[2000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }

            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}




