//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1352 👎 0

import java.io.StringReader;
import java.util.*;

/**
 * 字母异位词分组
 * @author Yuanzhi
 * @date 2023-01-14 11:39:09
 */
public class GroupAnagrams{
	 public static void main(String[] args) {
	 	 Solution solution = new GroupAnagrams().new Solution();
	 }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         /*
            官方题解思路（比自己写的简洁）
            遍历数组时，对每个单词进行排序
            ["eat", "tea", "tan", "ate", "nat", "bat"]

            - 遍历到"tea"排序，得到"aet"；作为哈希表的键, 加入list中
            - "aet" :["eat", "tea"]
          */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);
            List<String> group = strMap.getOrDefault(k, new ArrayList<>());
            group.add(strs[i]);
            strMap.put(k,group);
        }
        return new ArrayList<List<String>>(strMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
