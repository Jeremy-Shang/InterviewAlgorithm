//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 1876 👎 0

/**
 * 搜索插入位置
 * @author Yuanzhi
 * @date 2023-02-14 11:54:41
 */
public class SearchInsertPosition{
	 public static void main(String[] args) {
	 	 Solution solution = new SearchInsertPosition().new Solution();
          int rel = solution.searchInsert(new int[]{1,3,5,6,7,9,12,15}, 8);
          System.out.println(rel);
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            二分查找核心

            - 本质上，二分查找的算法模版是固定的
                1. 界定条件为 l <= r
                2. 迭代计算mid，根据条件l=mid+1, r=mid-1
            - 主要的问题就在于边界的处理
                1. 为什么是while(l <= r)?

            - 如下迭代例子

            [1,3,5,7,11,13] target=4
                 l   m       r
            1.  [1,3,5,7,11,13], nums[m] > target, r=m-1
                 l
                 m r
            2.  [1,3,5,7,11,13], nums[m] < target, l=m+1

                   l
                   r
                   m
            3.  [1,3,5,7,11,13], nums[m] < target, l=m+1

                  r l
            4. [1,3,5,7,11,13], 不满足条件，break

         */
        int l=0, r=nums.length - 1, mid=0;
        int ans=0;
        while(l <= r) {
            mid = (r + l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }


        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
