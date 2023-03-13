//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
//
// Related Topics 字符串 动态规划 👍 512 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 把数字翻译成字符串
 * @author Yuanzhi
 * @date 2023-01-11 11:06:16
 */
public class BaShuZiFanYiChengZiFuChuanLcof{
	 public static void main(String[] args) {
	 	 Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
         solution.translateNum(26);
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

         /*
            回溯，思路和有效IP地址一样，属于典型切割问题, 切割问题见leetcode笔记

            也可以用动态规划dp[i]表示，以i结尾有多少种方法
         */

    int ans = 0;
    List<String> paths = new ArrayList<>();
    public int translateNum(int num) {
        String strNum = Integer.toString(num);
        int start = 0;
        backTrack(strNum, start);
        return ans;
    }

    public void backTrack(String strNum, int start) {
        if (start == strNum.length()) {
//            System.out.println(paths.toString());
            ans += 1;
            return ;
        }
        for(int i=start; i<strNum.length(); i++) {
            // 取得当前回溯层的块：如12258， 取"12"这个块
            String subStr = strNum.substring(start, i + 1);
            // 转换为数字
            Integer subStrVal = Integer.parseInt(subStr);

//            System.out.printf("subStr: %s, subVal: %d\n", subStr, subStrVal);
            // 判断是否在有效的数字范围并且判断是否有效, 如"005"这种组合不属于有效数字,
            if (subStrVal > 25 || (subStr.charAt(0) == '0' && subStr.length() > 1)) {
                break;
            }
            paths.add(subStr);
            backTrack(strNum, i + 1);
            paths.remove(paths.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
