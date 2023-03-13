//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 692 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * @author Yuanzhi
 * @date 2023-01-09 22:26:20
 */
public class IntersectionOfTwoArrays{
	 public static void main(String[] args) {
         Solution solution = new IntersectionOfTwoArrays().new Solution();
         solution.intersection(new int[] {1,2,2,1}, new int[]{2,2});

	 }
	 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();

        for(int num: nums1) {
            s1.add(num);
        }
        for(int num: nums2) {
            s2.add(num);
        }

        for(int num: nums2) {
            if (s1.contains(num)) {
                s3.add(num);
            }
        }

        int[] ans = new int[s3.size()];
        int i=0;
        for(Integer nim: s3) {
            ans[i] = nim;
            i++;
        }


        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
