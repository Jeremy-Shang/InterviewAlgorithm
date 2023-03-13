//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 230 👎 0

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 第 k 个数
 * @author Yuanzhi
 * @date 2023-01-08 23:05:00
 */
public class GetKthMagicNumberLcci{
	 public static void main(String[] args) {
         Solution solution = new GetKthMagicNumberLcci().new Solution();
         int ans = solution.getKthMagicNumber(10);
         System.out.println(ans);
	 }
	 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        // 最小堆，将1放入最小堆中初始化
        // 取出堆顶数字x，并且将3x，5x, 7x放入最小堆

        // 利用哈希表去重
        Queue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        int[] factors = new int[]{3, 5, 7};
        int ans = 0;
        
        minHeap.add(new Long(1));
        for(int i=0; i<k; i++) {
            long curr = minHeap.poll();
            ans = (int) curr;
            for(int factor: factors) {
                long next = factor * curr;
                // 即，如果加入哈希集成功，则加入队列
                if(seen.add(next)) {
                    minHeap.offer(next);
                }
            }
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
