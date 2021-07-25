package medium;

import org.junit.Test;

import java.util.*;

public class T151ReverseWordsInAString {

    @Test
    public void test(){
        System.out.println(reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        s = " " + s;
        int len = s.length();
        int left = len - 1, right = len - 1;
        Stack<String> wordStack = new Stack<>();
        while (left >= 0) {
            //初始化左右指针，同时指向最后一个单词的最后一个字符
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
                right--;
            }
            //left停在字符左边的第一个空格处
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            wordStack.push(s.substring(left + 1, right + 1));
            right = left;
        }
        wordStack.pop();
        return String.join(" ",wordStack);
    }
}
