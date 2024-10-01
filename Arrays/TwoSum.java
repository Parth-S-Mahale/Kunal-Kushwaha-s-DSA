import java.util.Scanner;

public class TwoSum{
    public static int[] twoSum(int[] nums, int target){
        int len = nums.length;

        int num1 = 0;
        int sum = 0;
        int[] result = new int[2];

        for (int i = 0; i < len; i++) {

            num1 = nums[i];
            for (int j = 0; j < len; j++) {
                sum = num1 + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[0] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int[] nums = {2,7,11,9};
        int target = sc.nextInt();
        twoSum(nums, target);
    }

}