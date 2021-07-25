package medium;

import java.util.Arrays;
import java.util.Stack;

public class T739DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    //暴力
    /*
    private static int[] dailyTemperatures(int[] temperatures) {
        int daysRange = temperatures.length;
        int[] days = new int[daysRange];
        for (int i = 0; i < daysRange - 1; i++) {
            int next = i + 1;
            while (next < daysRange && temperatures[i] >= temperatures[next]) {
                next++;
            }
            if (next < daysRange) {
                days[i] = next - i;
            } else {
                days[i] = 0;
            }
        }
        return days;
    }
     */

    //单调栈
    private static int[] dailyTemperatures(int[] temperatures) {
        int daysRange = temperatures.length;
        int[] days = new int[daysRange];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < daysRange; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                days[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return days;
    }

}
