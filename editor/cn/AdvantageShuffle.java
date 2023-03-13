//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 357 👎 0

import javafx.geometry.Side;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 优势洗牌
 * @author Yuanzhi
 * @date 2023-01-17 12:30:34
 */
public class AdvantageShuffle{
	 public static void main(String[] args) {
	 	 Solution solution = new AdvantageShuffle().new Solution();
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
            贪心算法
            - nums1=[1, 2, 4, 5, 9]
			- nums2=[6, 2, 9, 1, 4]

			找到"映射"，比如对于num2[0]=6来说，对应的映射为nums1[4]=9

			1. 对num的索引进行排序
			如：[1, 2, 4, 5, 9]排序[1,2,4,5,9] -> idx1=[0,1,2,3,4]
			如：[6, 2, 9, 1, 4]排序[1,2,4,6,9] -> idx2=[3,1,4,0,2]

			比较排序后的数组

         */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        // 根据值，对索引进行排序
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        // 相当于排序过的两个数组
        // nums1 :[1, 2, 4, 5, 9] idx1:
        // nums2 :[1, 2, 4, 6, 9] idx2:
        System.out.println(Arrays.stream(idx1).collect(Collectors.toList()).toString());
        System.out.println(Arrays.stream(idx2).collect(Collectors.toList()).toString());

        int[] ans = new int[n];
        int left = 0, right = n - 1;

        for (int i = 0; i < n; ++i) {
            // idx2[left]的索引上找到了映射
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
