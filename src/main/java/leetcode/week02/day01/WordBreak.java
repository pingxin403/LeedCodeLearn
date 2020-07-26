package leetcode.week02.day01;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class WordBreak {
    //https://leetcode-cn.com/problems/word-break/solution/java-zi-dian-shu-he-ji-yi-hua-jie-he-by-jackwener/
    public class TrieNode {
        boolean flag;
        HashMap<Character, TrieNode> next = new HashMap<Character, TrieNode>();

        public TrieNode() {
            flag = false;
        }
    }

    TrieNode root;
    //List<Integer>  memo = new LinkedList<Integer>();
    int[] memo;

    public boolean helper(String s, int start, int end) {
        if (start == end) return true;
        if (start == end)
            return true;
        if (memo[start] != 0)
            return memo[start] > 0;
        TrieNode node = root;
        for (int i = start; i < end; ++i) {
            if (!node.next.containsKey(s.charAt(i)))
                break;
            node = node.next.get(s.charAt(i));
            if (node.flag && helper(s, i + 1, end)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        root = new TrieNode();
        TrieNode node = root;
        for (String word : wordDict) {
            node = root;
            for (char ch : word.toCharArray()) {
                if (!node.next.containsKey(ch)) {
                    node.next.put(ch, new TrieNode());
                }
                node = node.next.get(ch);
            }
            node.flag = true;
        }
        return helper(s, 0, s.length());
    }
}
