package practice;

public class contiguousSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 4, 10};
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }
}
