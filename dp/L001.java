import java.util.*;

public class L001 {

    // memoization
    public static int fibonacci(int num, int[] dp) {
        if (num <= 1)
            return dp[num] = num;

        if (dp[num] != 0)
            return dp[num];

        int res = fibonacci(num - 1, dp) + fibonacci(num - 2, dp);
        return dp[num] = res;
    }

    public static int fibonacci_DP(int num, int[] dp) {
        int NUM = num;
        for (num = 0; num <= NUM; num++) {
            if (num <= 1) {
                dp[num] = num;
                continue;
            }
            int res = dp[num - 1] + dp[num - 2];// fibonacci(num - 1, dp) + fibonacci(num - 2, dp);
            dp[num] = res;
        }
        return dp[NUM];
    }

    // memoized code
    public static int mazepathHV(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec)
            return dp[sr][sc] = 1;

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        if (sr + 1 < er)
            count += mazepathHV(sr + 1, sc, er, ec, dp);
        if (sc + 1 < ec)
            count += mazepathHV(sr, sc + 1, er, ec, dp);
        return dp[sr][sc] = count;
    }

    public static int mazepathHV_DP(int sr, int sc, int er, int ec, int[][] dp) {
        for (sr = er; sr >= 0; sr--) {
            for (sc = ec; sc >= 0; sc--) {

                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                if (sr + 1 < er)
                    count += dp[sr + 1][sc];// mazepathHV(sr + 1, sc, er, ec, dp);
                if (sc + 1 < ec)
                    count += dp[sr][sc + 1];// mazepathHV(sr, sc + 1, er, ec, dp);
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    // memoisation
    public static int boardpath(int sp, int ep, int[] dp) {
        if (sp == ep)
            return dp[sp] = 1;

        if (dp[sp] != 0)
            return dp[sp];
        int count = 0;
        for (int dice = 1; dice <= 6; dice++)
            if (dice + sp <= ep)
                count += boardpath(sp + dice, ep, dp);
        return dp[sp] = count;
    }

    public static int boardpath_Dp(int sp, int ep, int[] dp) {
        for (sp = ep; sp >= 0; sp--) {
            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6; dice++)
                if (dice + sp <= ep)
                    count += dp[sp + dice];// boardpath(sp + dice, ep, dp);
            dp[sp] = count;
        }
        return dp[0];
    }

    // memoization
    public static int friends_pairing_problem(int num, int[] dp) {
        if (num <= 1)
            return dp[num] = 1;
        if (dp[num] != 0)
            return dp[num];
        int single = friends_pairing_problem(num - 1, dp);
        int paiup = friends_pairing_problem(num - 2, dp) * (num - 1);
        return dp[num] = single + paiup;
    }

    public static int friends_pairing_problem_DP(int num, int[] dp) {
        int N = num;
        for (num = 0; num <= N; num++) {
            if (num <= 1) {
                dp[num] = 1;
                continue;
            }

            int single = dp[num - 1];
            int paiup = dp[num - 2] * (num - 1);
            dp[num] = single + paiup;
        }
        return dp[N];
    }

    public static int partition_into_k_subsets(int num, int k, int[][] dp) {
        if (num < k)
            return dp[num][k] = 0;
        if (num == k || k == 1)
            return dp[num][k] = 1;

        if (dp[num][k] != 0)
            return dp[num][k];
        int newSet = partition_into_k_subsets(num - 1, k - 1, dp);
        int existingSet = partition_into_k_subsets(num - 1, k, dp) * k;
        return dp[num][k] = newSet + existingSet;
    }
    // mobilekeypadproblem gfg dp 3d int[][][] dp

    // coinchange permutation
    public static int coinchangeper(int[] arr, int tar, int[] dp) {
        if (tar == 0)
            return dp[tar] = 1;
        if (dp[tar] != 0)
            return dp[tar];
        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0)
                count += coinchangeper(arr, tar - ele, dp);
        }
        return dp[tar] = count;
    }

    public static int coinchange_DP(int[] arr, int tar, int[] dp) {
        int N = tar;
        for (tar = 0; tar < N; tar++) {
            if (tar == 0) {
                dp[tar] = 1;
                continue;
            }
            int count = 0;
            for (int ele : arr) {
                if (tar - ele >= 0)
                    count += dp[tar - ele];// coinchangeper(arr, tar - ele, dp);
            }
            dp[tar] = count;
        }
        return dp[N];
    }
}