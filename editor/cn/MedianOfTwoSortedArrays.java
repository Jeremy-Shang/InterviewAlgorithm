//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6291 👎 0

/**
 * 寻找两个正序数组的中位数
 * @author Yuanzhi
 * @date 2023-02-22 19:37:33
 */
public class MedianOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 Solution solution = new MedianOfTwoSortedArrays().new Solution();

          double ans = solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});

          System.out.println("ans: " + ans);
	 }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
            官方题解思路：中位数性质 + 二分查找
         */
        int ans = 0;
        int l1 = nums1.length, l2 = nums2.length;
        int left = 0, right = l1;

        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // 因为中位数的性质，分割后的数组左边长度总等于这个值; 因为向下取整的关系，奇偶可以一起讨论
        int leftNum = (l1 + l2 + 1) / 2;


        // 目的是在nums1上的left，right指针重合。重合的位置即为分割线
        // 算法需要满足: nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        while (left < right) {
            int i = left + (right - left + 1) / 2;     // 第一个数组分割线index
            int j = leftNum - i;            // 第二个数组分割线index

            System.out.println(left + " " + right);
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索区间[left, i - 1]
                right = i - 1;
            } else  {
                // 下一轮搜索区间[i + 1, right]
                left = i ;
            }
        }

        int i = left;
        int j = leftNum - i;


        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        // 等i=第一个数组的长度时，说明第一个数组分割线右边没有值，为了不影响
        // nums2[j - 1] <= nums1[i] 和 Math.min(nums1RightMin, nums2RightMin)
        // 的判断，所以将它设置为int的最大值
        int nums1RightMin = i == l1 ? Integer.MAX_VALUE : nums1[i];
        // 当j=0时，说明第二个数组分割线左边没有值，为了不影响
        // nums2[j - 1] <= nums1[i] 和 Math.max(nums1LeftMax, nums2LeftMax)
        // 的判断，所以将它设置为int的最小值
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        // 等j=第二个数组的长度时，说明第二个数组分割线右边没有值，为了不影响
        // nums1[i - 1] <= nums2[j] 和 Math.min(nums1RightMin, nums2RightMin)
        // 的判断，所以将它设置为int的最大值
        int nums2RightMin = j == l2 ? Integer.MAX_VALUE : nums2[j];
        // 如果两个数组的长度之和为奇数，直接返回两个数组在分割线左边的最大值即可
        if (((l1 + l2) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            // 如果两个数组的长度之和为偶数，返回的是两个数组在左边的最大值和两个数组在右边的最小值的和的二分之一
            // 此处不能被向下取整，所以要强制转换为double类型
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
