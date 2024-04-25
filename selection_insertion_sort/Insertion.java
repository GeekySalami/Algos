import java.util.*;
public class Insertion {

    int [] insertion_sort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the number of elements: ");
        //int n = sc.nextInt();
        //int [] arr = new int[n];
        int [] arr = {1,5,4,2,3,6,9,0};

        //for (int i = 0; i < arr.length; i++) {
        //    System.out.println(String.format("Ente the element %d: ",(i+1)));
        //    arr[i] = sc.nextInt();
        //}

        Insertion ob = new Insertion();

        arr = ob.insertion_sort(arr);
        System.out.print("The sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        sc.close();
    }

}
