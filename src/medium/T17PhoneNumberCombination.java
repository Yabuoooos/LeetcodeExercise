package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangyaobin
 * @date 2021/8/8
 */
public class T17PhoneNumberCombination {
    @Test
    public void test() {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        char[][] letters = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g','h','i'},{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> ans = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        if (digits.length() == 0) {
            return ans;
        }
        dfs(letters, digits, 0, temp, ans);
        return ans;
    }

    private void dfs(char[][] letters, String digits, int depth, StringBuffer temp, List<String> ans) {
        if (depth == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        for (int i = 0; i < letters[digits.charAt(depth) - 50].length; i++) {
            temp.append(letters[digits.charAt(depth) - 50][i]);
            dfs(letters, digits, depth + 1, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }
        return;
    }
}
