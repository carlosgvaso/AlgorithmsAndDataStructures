/**Quick Sort */

#include <iostream> // cout
#include <stdlib.h> // srand, rand
#include <time.h>   // time

using namespace std;

/** Exchange the ith and jth entries in array arr. */
void exchange(int *arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

int partition(int *arr, int p, int r) {
    int x = arr[r];
    int i = p-1;

    for (int j=p; j<r; j++) {
        if (arr[j] <= x) {
            i++;
            exchange(arr, i, j);
        }
    }
    exchange(arr, i+1, r);

    return i+1;
}

int randomizedPartition(int *arr, int p, int r) {
    // Select pivot at random
    int i = p + (rand() % static_cast<int>(r - p + 1));
    cout << "Pivot (" << p << ", " << r << "): " << i << "\n";

    exchange(arr, i, r);
    return partition(arr, p, r);
}

void quickSort(int *arr, int p, int r) {
    if (p < r) {
        int q = randomizedPartition(arr, p, r);

        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);
    }
}

int *sort(int *arr, int p, int r) {
    quickSort(arr, p, r);
    return arr;
}

int main(int argc, char **argv) {
    srand (time(NULL)); // Initialize the random number generator with a seed
    int array[] = { 6, 3, 1, 5, 0, 7, 9, 2, 4, 8 };
    int *arr = array;
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

    arr = sort(arr, 0, 9);
    bool sorted = true;
    cout << "Sorted arr = [ ";
    for (int i = 0; i < n_arr; i++) {
        if (i > 0) {
            if (arr[i-1] > arr[i]) {
                sorted = false;
            }
        }
        cout << arr[i];
        if (i == n_arr - 1) {
            cout << " ]\n";
        } else {
            cout << ", ";
        }
    }
    if (sorted) {
        cout << "Sorted: true\n";
    } else {
        cout << "Sorted: false\n";
    }
    
}
