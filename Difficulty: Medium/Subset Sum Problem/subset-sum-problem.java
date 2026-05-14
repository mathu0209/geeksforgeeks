class Solution {

    public boolean isSubsetSum(int[] arr, int k) {

        boolean[][] dp = new boolean[arr.length + 1][k + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {

            for (int target = 1; target <= k; target++) {

                // Not take
                dp[i][target] = dp[i - 1][target];

                // Take
                if (arr[i - 1] <= target) {
                    dp[i][target] =
                        dp[i][target] ||
                        dp[i - 1][target - arr[i - 1]];
                }
            }
        }

        return dp[arr.length][k];
    }
}