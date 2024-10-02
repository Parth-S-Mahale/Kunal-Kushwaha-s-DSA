import java.util.ArrayList;
import java.util.List;

/**
 * FindAllNumbersDisappearedInAnArray
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                ans.add(index + 1);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray finder = new FindAllNumbersDisappearedInAnArray();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(finder.findDisappearedNumbers(arr));
    }
    
}
