public class FirstMissingPositive {

        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while(i < nums.length){
                int correct = nums[i] - 1;
                if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]){
                    swap(nums, i, correct);
                } else{
                    i++;
                }
            }
    
            for (int index = 0; index < nums.length; index++) {
                if(nums[index] != index + 1){
                    return index + 1;
                }
            }

            // case 2
            return nums.length + 1;
        }
    
        static void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
}
