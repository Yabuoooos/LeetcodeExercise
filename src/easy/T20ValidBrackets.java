package easy;

import java.util.Stack;

public class T20ValidBrackets {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //若奇数个括号，直接排除
        if (s.length() % 2 != 0) return false;

        Stack<Character> charStack = new Stack<>();
        //入栈
        for (int i = 0; i < s.length(); i++) {
            charStack.push(s.charAt(i));
        }
        //循环直到栈空
        while (!charStack.isEmpty()) {
            int index = getFirstRightBrackets(charStack);
            if (index < 1) return false;
            else {
                switch (charStack.elementAt(index)) {
                    case ']':
                        if (charStack.elementAt(index - 1) == '[') {
                            charStack.remove(index);
                            charStack.remove(index - 1);
                            break;
                        } else return false;
                    case '}':
                        if (charStack.elementAt(index - 1) == '{') {
                            charStack.remove(index);
                            charStack.remove(index - 1);
                            break;
                        } else return false;
                    case ')':
                        if (charStack.elementAt(index - 1) == '(') {
                            charStack.remove(index);
                            charStack.remove(index - 1);
                            break;
                        } else return false;

                }
            }
        }
        return true;
    }

    public static int getFirstRightBrackets(Stack<Character> charStack) {
        for (int i = 0; i < charStack.size(); i++) {
            if (charStack.elementAt(i) == ']' || charStack.elementAt(i) == '}' || charStack.elementAt(i) == ')') {
                return i;
            }
        }
        return -1;
    }
}
