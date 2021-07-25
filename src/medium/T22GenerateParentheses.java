package medium;

import org.junit.Test;

import java.util.*;

public class T22GenerateParentheses {
    @Test
    public void test(){
        int n = 5;
        System.out.println(generateParenthesis(n));
        System.out.println(generateParenthesis(n).size());
    }

    public List<String> generateParenthesis(int n) {
        List<Set<String>> dpList = new ArrayList<>();
        dpList.add(0,new HashSet<>());
        dpList.get(0).add("");
        dpList.add(1,new HashSet<>());
        dpList.get(1).add("()");
        for (int i = 2; i <= n; i++) {
            dpList.add(i,new HashSet<>());
            //n个时，将前n-1个分为两部分：p和n-1-p。前面一个部分整体外面多了一个括号“ ( p ) ”，后面一个部分没有。
            for (int j = 0; j < i; j++) {
                for (String s1 : dpList.get(j)) {
                    for (String s2 : dpList.get(i - j - 1)) {
                        dpList.get(i).add("(" + s1 + ")" + s2);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : dpList.get(n)){
            res.add(s);
        }
        return res;
    }
}
