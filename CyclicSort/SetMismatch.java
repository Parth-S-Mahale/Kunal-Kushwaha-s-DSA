public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else{
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index + 1){
                return new int[] {nums[index], index+1};
            }
        }
        return new int[] {-1, -1};
    }

    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();

        // Example input
        int[] nums = {1,2,2,4};

        // Calling the findErrorNums method
        int[] result = setMismatch.findErrorNums(nums);

        System.out.println("Duplicate Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
    }
}