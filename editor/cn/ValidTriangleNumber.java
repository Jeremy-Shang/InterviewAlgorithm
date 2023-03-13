//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,3,4]
//输出: 4 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 459 👎 0

import java.util.Arrays;

/**
 * 有效三角形的个数
 * @author Yuanzhi
 * @date 2023-01-18 12:18:39
 */
public class ValidTriangleNumber{
	 public static void main(String[] args) {
	 	 Solution solution = new ValidTriangleNumber().new Solution();


          solution.triangleNumber(new int[]{2,3,4,4});
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         /*
            参考题解：三指针
             l         r  i
            [2,2,3,4,5,6,7]
            2 + 6 > 7
            则 2 + 6, 3 + 6, 4 + 6, ..., 5 + 6  > 7

           1. 先排序，之后从大到小遍历，也就是从 i -> 0遍历
           2. 设置l，r双指针，r=i-1
           3. 我们可以发现，如果nums[l] + nums[r] > nums[i]；
                则nums[l+1~r]也都可以和nums[i]组成三角形
          */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        // 从大到小遍历
        for(int i=nums.length-1; i>=2; i--) {
            // 左右指针
            int l = 0, r = i - 1;

            while (l < r) {
                // 只要较小的两个值之和大于最大的值，则一定可组成三角形
                if (nums[l] + nums[r] > nums[i]) {

                    ans  += r - l;
//                    System.out.printf("%d -- %d -- %d, add %d\n", nums[l], nums[r], nums[i], (r - 1) - l + 1);
                    r -= 1;
                } else {
                    l += 1;
                }

            }

        }
        System.out.println("ans=" + ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
