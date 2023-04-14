import java.util.Arrays;
import java.util.HashMap;

public class P0001_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) {
        int x, y;
        HashMap<Integer, Integer> pairs = new HashMap<Integer,Integer>();
        pairs.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            if (!pairs.containsKey(nums[i])){
                pairs.put(nums[i], i);
            }
            if(pairs.containsKey(target - nums[i]) && (i != (pairs.get(target - nums[i])))) {
                System.gc();
                return new int[]{i, pairs.get(target - nums[i])};
            }
        }
        return new int[2];
    }
}