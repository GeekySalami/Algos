/**
 * QuickSort
 */
public class QuickSort {

    int partition(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;
        int temp;
        
        do {
            while (i <= h && arr[i] <= pivot) {
                i++;
            }
            while (j >= l && arr[j] > pivot) {
                j--;
            }
            
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);
    
        temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
    
        return j;
    }
    

    void quicksrt(int arr[], int l, int h) {
        if (l < h) {
            int pi = partition(arr, l, h);
            quicksrt(arr, l, pi - 1);
            quicksrt(arr, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 6, 3, 4, 5 };
        QuickSort ob = new QuickSort();
        ob.quicksrt(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}