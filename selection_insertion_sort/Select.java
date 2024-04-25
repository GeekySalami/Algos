import java.util.Scanner;

/**
 * Select
 */
public class Select {

    int [] select_sort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
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

        Select ob = new Select();

        arr = ob.select_sort(arr);
        System.out.print("The sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

    
}