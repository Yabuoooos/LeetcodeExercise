package easy;

import java.util.Stack;

public class T58LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello world  ";
        System.out.println(lengthOfLastWord2(s));
    }

    public static int lengthOfLastWord(String s) {
        //若String中不包含任何字母
        String voidString = "";
        for (int i = 0; i < s.length(); i++) {
            voidString += ' ';
        }
        if (s.equals(voidString)) return 0;
        //能入栈的都是包含字母的
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        //先把最后面的空格pop出来
        while (stack.peek() == ' ') {
            stack.pop();
        }
        int count = 0;
        while (!stack.isEmpty() && stack.pop() != ' ') {
            count++;
        }
        return count;
    }

    //实际上不需要用栈
    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        //先过滤掉尾部的空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}

