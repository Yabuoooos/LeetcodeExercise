package hard;

import java.util.Stack;

public class T42ReceiveRain {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int n = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();  //当前栈顶，在构造容器时作为底部
                if (stack.isEmpty()) break;
                //当前栈顶左边一个元素
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currHeight * currWidth;
            }
            stack.push(i);
        }
        return res;
    }
}
