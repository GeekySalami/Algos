import java.util.*;;
public class BinarySearch {
    Optional<Integer> binsearch(int [] arr, int l, int h, int key){
        if (l <= h) {
            int mid = (l + h) / 2;
            
            if (arr[mid] == key)
                return Optional.of(mid);
            else if (key < arr[mid])
            {
                return binsearch(arr, l, mid-1, key);
            }
            else{
                return binsearch(arr, mid+1, h, key);
            }
        }
        else{
            //System.out.println("Not present");
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        int arr [] = {0,1,6,3,4,5};
        BinarySearch ob = new BinarySearch();
        Optional<Integer> result = ob.binsearch(arr, 0, arr.length - 1, 6);
        if (result.isPresent()) {
            System.out.println("Element found at index: " + result.get());
        } else {
            System.out.println("Element not found");
        }
    }
}
