import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
        public List<List<Integer>> threeSumPair(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0; i< nums.length - 2; i++){
                if(i > 0 && nums[i] == nums[i-1])
                    continue;
                searchPair(nums, result, i+1, -nums[i]);
            }
            return result;
        }

        private void searchPair(int[] nums, List<List<Integer>> result, int left, int targetSum){
            int right = nums.length -1;
            while(left < right){
                int currentSum = nums[left] + nums[right];
                if(currentSum == targetSum){
                    result.add(Arrays.asList(-targetSum, nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1])
                        left++;
                    while(left < right && nums[right] == nums[right + 1])
                        right--;
                }else if (targetSum < currentSum)
                    right --;
                else
                    left++;
            }
        }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSumPair(new int[]{-1,0,1,2,-1,-4}));
        }
}
