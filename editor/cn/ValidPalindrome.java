//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 602 👎 0

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 验证回文串
 * @author Yuanzhi
 * @date 2023-01-19 19:03:10
 */
public class ValidPalindrome{
	 public static void main(String[] args) {
	 	 Solution solution = new ValidPalindrome().new Solution();
          solution.isPalindrome("0P");
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(Character.toLowerCase(ch));

            }else if (Character.isAlphabetic(s.charAt(i))) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        String filterStr = sb.toString();

        System.out.println(filterStr);
        for(int i=0, j=filterStr.length() - 1; i<=j; i++, j--) {
            if (filterStr.charAt(i) != filterStr.charAt(j)) {
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
