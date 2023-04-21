import java.util.Arrays;

public class P0414_ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(thirdMax(arr));
    }

/*    Approach 1: Sorting*/
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int elemCounted = 1;
        int prevElem = nums[nums.length - 1];

        for (int index =  nums.length - 2; index >= 0; index--) {
            if (nums[index] != prevElem) {
                elemCounted += 1;
                prevElem = nums[index];
            }

            if (elemCounted == 3) {
                return nums[index];
            }
        }

        return nums[nums.length - 1];
    }

/*    Approach 2: Min Heap Data Structure*/
/*    Approach 3: Ordered Set*/
}
