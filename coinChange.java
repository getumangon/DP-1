// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: No (TLE)
// Any problem you faced while coding this: Refered lecture video for coding

public class coinChange {

    public static int coinChange(int[] coins, int amount) {
        // null
        return helper(coins, 0, amount, 0);
    }

    public static int helper(int[] coins, int i, int amount, int minCoins) {
        // base
        if (amount == 0)
            return minCoins;
        if (amount < 0 || i == coins.length)
            return -1;

        // logic
        // min no of coins if I choose a ith coint at this point of time
        int case1 = helper(coins, i, amount - coins[i], minCoins + 1);
        // no choice
        int case2 = helper(coins, i + 1, amount, minCoins);
        if (case1 == -1)
            return case2;
        if (case2 == -1)
            return case1;
        return Math.min(case1, case2);
    }

    public static void main(String[] args) {
        int[] coins = { 1, 4, 6 };
        int amount = 9;
        System.out.println(coinChange(coins, amount));
    }
}