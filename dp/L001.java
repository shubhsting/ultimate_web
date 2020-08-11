import java.util.*;

public class L001 {
    public static void main(String[] args) {

    }

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
}