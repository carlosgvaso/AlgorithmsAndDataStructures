/**Binary Search */

#include <iostream>

using namespace std;

int search(int *arr, int l, int r, int x) {
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

int main(int argc, char **argv) {
    int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int * arr = array;
    int n_arr = 10;

    cout << "arr = [ ";
    for (int i = 0; i < n_arr; i++) {
        cout << arr[i];
        if (i == n_arr - 1) {
            cout << " ]\n";
        } else {
            cout << ", ";
        }
    }

    cout << "Search for 0: " << search(arr, 0, 9, 0) << "\n";
    cout << "Search for 9: " << search(arr, 0, 9, 9) << "\n";
    cout << "Search for 5: " << search(arr, 0, 9, 5) << "\n";
    cout << "Search for 3: " << search(arr, 0, 9, 3) << "\n";
    cout << "Search for 6: " << search(arr, 0, 9, 6) << "\n";
}
