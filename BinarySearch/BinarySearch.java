/**Binary Search */

class BinarySearch {
    public static int search(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = (l + r) / 2;

            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                return search(arr, l, mid - 1, x);
            }
            return search(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String... args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.print("arr = [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.println(" ]");
            } else {
                System.out.print(", ");
            }
        }

        System.out.println("Search for 0: " + search(arr, 0, 9, 0));
        System.out.println("Search for 9: " + search(arr, 0, 9, 9));
        System.out.println("Search for 5: " + search(arr, 0, 9, 5));
        System.out.println("Search for 3: " + search(arr, 0, 9, 3));
        System.out.println("Search for 6: " + search(arr, 0, 9, 6));
    }
}
