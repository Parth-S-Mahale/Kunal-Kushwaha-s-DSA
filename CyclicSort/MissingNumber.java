import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }  
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index){
                return index;
            } 
        }

        // case 2

        return arr.length;
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        missingNumber(arr);
        System.out.println(Arrays.toString(arr));
    }
}
