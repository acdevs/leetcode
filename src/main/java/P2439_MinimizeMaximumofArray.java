public class P2439_MinimizeMaximumofArray {
    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }

    static int minimizeArrayValue(int[] nums) {
        long answer = 0, prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int)answer;
    }
}
