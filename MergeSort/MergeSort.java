/**Merge Sort */

class MergeSort {
    private static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // middle of array

            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        // Set up subarrays to merge
        int inf = 1000000;
        int i, j;
        int n_L = q - p + 1;
        int n_R = r - q;
        int[] L = new int[n_L+1];
        int[] R = new int[n_R+1];

        for (i=0; i<n_L; i++) {
            L[i] = arr[p+i];
        }
        for (j=0; j<n_R; j++ ) {
            R[j] = arr[q+j+1];
        }

        L[n_L] = inf;
        R[n_R] = inf;
        i = 0;
        j = 0;

        for (int k=p; k<=r; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
        }
    }

    public static int[] sort(int[] arr, int p, int r) {
        mergeSort(arr, p, r);
        return arr;
    }

    public static void main(String... args) {
        int[] arr = { 6, 3, 1, 5, 0, 7, 9, 2, 4, 8 };

        System.out.print("arr = [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.println(" ]");
            } else {
                System.out.print(", ");
            }
        }

        arr = sort(arr, 0, 9);
        System.out.print("Sorted arr = [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.println(" ]");
            } else {
                System.out.print(", ");
            }
        }
    }
}
