package leetcode;

public class P0268_MissingNumbers {
    public static void main(String[] args) {
//        int[] arr = {3,6,4,2,8,5,7,0,1};
//        int[] arr = {5,1,6,3,8,0,2,4,9};
//        int[] arr = {0,2,4,5,9,1,6,3,8};
//        int[] arr = {3,8,7,5,9,4,6,2,1};
        int[] arr = {3,0,2,1};
        System.out.println(missingNumbers(arr));
    }

    static int missingNumbers(int[] nums) {
        int size = nums.length;
        int miss = size;
        for (int i = 0; i < size; i++) {
            miss ^= i ^ nums[i];
        }
        return miss;
    }
}