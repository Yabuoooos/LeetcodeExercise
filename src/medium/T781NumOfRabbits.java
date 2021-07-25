package medium;

import java.util.HashMap;
import java.util.Map;

public class T781NumOfRabbits {
    public static void main(String[] args) {
        int[] answers = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5};
        System.out.println(numRabbits(answers));
    }

    private static int numRabbits(int[] answers) {
        /*
        Arrays.sort(answers);
        int res = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < answers.length; i++){
            queue.offer(answers[i]);
        }
        while (queue.size() > 0){
            res += queue.peek() + 1;
            int curr = queue.poll();
            for (int i = 0; i < curr; i++){
                if (queue.size() == 0 || queue.peek() != curr){
                    break;
                }
                queue.poll();
            }
        }
        return res;

         */
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int answer : answers) { //answer作为key,若找到同样的answer,则将value+1,否则新增一个坑,初始值为0+1
            count.put(answer, count.getOrDefault(answer, 0) + 1);  //得到每个answer出现的次数
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {  //遍历Map的键-值对
            int answer = entry.getKey(), num = entry.getValue();
            //若答案为answer的兔子有num只,则至少有[num/answer+1]（向上取整）种颜色,每种有answer+1个兔子
            //[x/y+1]（向上取整）=(x+1)/(y+1)     可以分可以被整除与不可被整除的情况讨论
            res += ((num + answer) / (answer + 1)) * (answer + 1);
        }
        return res;
    }

    private static int toCeil(int a, int b) {
        //向上取整方法(大于0)
        return (a + b - 1) / b;
    }


}
