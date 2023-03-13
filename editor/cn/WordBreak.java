//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1915 👎 0

import java.util.*;

/**
 * 单词拆分
 * @author Yuanzhi
 * @date 2023-01-15 17:47:13
 */
public class WordBreak{
	 public static void main(String[] args) {
	 	 Solution solution = new WordBreak().new Solution();
         List<String> input = new ArrayList<>(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));
         solution.wordBreak("catsandog", input);
	 }


     //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         /*
            利用回溯，切割问题的视角解决

            catsanddog, 堆单词进行切分，需要在切完后所有的单词都在wordDict出现

          */

         private Set<String> set;
         private int[] memo;
         public boolean wordBreak(String s, List<String> wordDict) {
             memo = new int[s.length()];
             set = new HashSet<>(wordDict);
             return backtracking(s, 0);
         }

         public boolean backtracking(String s, int startIndex) {
             // System.out.println(startIndex);
             if (startIndex == s.length()) {
                 return true;
             }
             if (memo[startIndex] == -1) {
                 return false;
             }

             for (int i = startIndex; i < s.length(); i++) {
                 String sub = s.substring(startIndex, i + 1);
                 // 拆分出来的单词无法匹配
                 if (!set.contains(sub)) {
                     continue;
                 }
                 boolean res = backtracking(s, i + 1);
                 if (res) return true;
             }
             // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
             memo[startIndex] = -1;
             return false;
         }
}
//leetcode submit region end(Prohibit modification and deletion)

}
