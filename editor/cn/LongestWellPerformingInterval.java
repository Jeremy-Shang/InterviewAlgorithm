//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 245 👎 0

import java.util.*;
import java.util.stream.Collectors;

/**
 * 表现良好的最长时间段
 * @author Yuanzhi
 * @date 2023-01-16 11:14:57
 */
public class LongestWellPerformingInterval{
	 public static void main(String[] args) {
	 	 Solution solution = new LongestWellPerformingInterval().new Solution();
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         /*
            完全不会，参考官方题解
                - 前缀和 + 单调栈

            [9,9,6,0,6,6,9]， 大于8=1，小于8=-1
            - 1. 转化为编码后数组encode=[1,1,-1,-1,-1,-1,1]
            - 2. 生成前缀和数组preSum=[0, 1, 2, 1, 0, -1, -2, -1], 其中preSum[i] = encode[0~i-1]的和
                - 问题转化为，在encode数组中，找到一个子列，使得和 > 0， 且最长
                - *问题转化为，在preSum数组中，找到索引i，j，使 j - i 最大，且保证 presum[j] - presum[i] 大于 0*
            - 3. 为了解决转化后的问题，需要利用单调栈

            preSum=[0, 1, 2, 1, 0, -1, -2, -1]
            index =[0, 1, 2, 3, 4, 5, 6, 7]

            失败，看不懂
          */
    public int longestWPI(int[] hours) {
        // 编码为encode数组
        List<Integer> hoursArray = Arrays.stream(hours)
                .map(n -> {
                    return n > 8 ? 1 : -1;
                })
                .boxed()
                .collect(Collectors.toList());

        // 前缀和
        List<Integer> preSum = Arrays.asList(0);

        return 0;

//        class Solution:
//        def longestWPI(self, hours: List[int]) -> int:
//        n = len(hours)
//        # 大于8小时计1分 小于等于8小时计-1分
//        score = [0] * n
//        for i in range(n):
//        if hours[i] > 8:
//        score[i] = 1
//            else:
//        score[i] = -1
//        # 前缀和
//        presum = [0] * (n + 1)
//        for i in range(1, n + 1):
//        presum[i] = presum[i - 1] + score[i - 1]
//        ans = 0
//        stack = []
//        # 顺序生成单调栈，栈中元素从第一个元素开始严格单调递减，最后一个元素肯定是数组中的最小元素所在位置
//        for i in range(n + 1):
//        if not stack or presum[stack[-1]] > presum[i]:
//        stack.append(i)
//        # 倒序扫描数组，求最大长度坡
//                i = n
//        while i > ans:
//        while stack and presum[stack[-1]] < presum[i]:
//        ans = max(ans, i - stack[-1])
//        stack.pop()
//        i -= 1
//        return ans
//
//        作者：smoon1989
//        链接：https://leetcode.cn/problems/longest-well-performing-interval/solution/qian-zhui-he-dan-diao-zhan-python3-by-smoon1989/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
