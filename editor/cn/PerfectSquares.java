//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1571 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 完全平方数
 * @author Yuanzhi
 * @date 2023-01-10 15:42:59
 */
public class PerfectSquares{
	 public static void main(String[] args) {
         Solution solution = new PerfectSquares().new Solution();
         solution.numSquares(12);
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
    /*
        完全背包问题：
            背包容量为n
            物品为完全平方数: 1,4,9,16,25,36
            一个物品有无数个
            需要 恰好填满背包， 并且物品的数量最少
        状态转移方程：
            dp[i][j]：从0-i取物品，凑出数字总和 j 所需要用到的最少数字数量？

            不放入第i：dp[i][j] = dp[i-1][j]
            放入一个i: dp[i][j] = dp[i-1][j-weight[i]] + 1
            放入两个i: dp[i][j] = dp[i-1][j-2*weight[i]] + 2
            放入k个i (不超过背包容量):  dp[i][j] = dp[i-1][j-k*weight[i]] + k
     */
    class Solution {
        int INF = 0x3f3f3f3f;
        public int numSquares(int n) {
            // 获得完全平方数
            List<Integer> square = new ArrayList<>();
            int num = 1;
            while(true) {
                if (num * num > n) break;
                square.add(num * num);
                num ++;
            }
            int rowNum = square.size(), colNum = n;
            int[][] dp = new int[rowNum + 1][colNum + 1];

            Arrays.fill(dp[0], INF);
            dp[0][0] = 0;

//            for(int i=0; i<rowNum; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }
            // 遍历dp
            for(int i=1; i<=rowNum; i++) {
                int item = square.get(i - 1);
                // 在0-i中选择，恰好能凑出j的最少个数
                for(int j=0; j<=colNum; j++) {
                    // 不选择第i个物品
                    dp[i][j] = dp[i - 1][j];
                    // 选择k次第i个数字，前提有
                    // 1. 可以放的下，也就是j-k*item >= 0
                    // 2. 可以被凑出?
                    for(int k=1; j-k*item >=0; k++){
                        if (dp[i - 1][j - k*item] != -1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k*item] + k);
                        }
                    }
                }
            }
//            for(int i=0; i<rowNum; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }


            return dp[rowNum][colNum];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
