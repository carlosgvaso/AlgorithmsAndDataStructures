/**Quick Sort */

import java.util.Random;

class QuickSort {

    static Random randInt;

    /** Exchange the ith and jth entries in array arr. */
    private static void exchange(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                exchange(arr, i, j);
            }
        }
        exchange(arr, i + 1, r);

        return i + 1;
    }

    private static int randomizedPartition(int[] arr, int p, int r) {
        // Select pivot at random
        int i = randInt.nextInt((r + 1) - p) + p;
        System.out.println("Pivot (" + p + ", " + r + "): " + i);

        exchange(arr, i, r);
        return partition(arr, p, r);
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(arr, p, r);

            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int[] sort(int[] arr, int p, int r) {
        quickSort(arr, p, r);
        return arr;
    }

    public static void main(String[] args) {
        randInt = new Random();
        int arr[] = { 6, 3, 1, 5, 0, 7, 9, 2, 4, 8 };
        int n_arr = 10;

        System.out.print("arr = [ ");
        for (int i = 0; i < n_arr; i++) {
            System.out.print(arr[i]);
            if (i == n_arr - 1) {
                System.out.print(" ]\n");
            } else {
                System.out.print(", ");
            }
        }

        arr = sort(arr, 0, 9);
        boolean sorted = true;
        System.out.print("Sorted arr = [ ");
        for (int i = 0; i < n_arr; i++) {
            if (i > 0) {
                if (arr[i-1] > arr[i]) {
                    sorted = false;
                }
            }
            System.out.print(arr[i]);
            if (i == n_arr - 1) {
                System.out.print(" ]\n");
            } else {
                System.out.print(", ");
            }
        }
        if (sorted) {
            System.out.print("Sorted: true\n");
        } else {
            System.out.print("Sorted: false\n");
        }

    }

}
