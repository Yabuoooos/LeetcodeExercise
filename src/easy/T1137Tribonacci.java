package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangyaobin
 * @date 2021/8/8
 */
public class T1137Tribonacci {
    @Test
    public void test() {
        System.out.println(tribonacci(25));
    }

    public int tribonacci(int n) {
        List<Integer> tribonacci = new ArrayList<>();
        tribonacci.add(0);
        tribonacci.add(1);
        tribonacci.add(1);
        for (int i = 3; i <=n; i++) {
            tribonacci.add(tribonacci.get(i - 1) + tribonacci.get(i - 2) +tribonacci.get(i - 3));
        }
        return tribonacci.get(n);
    }
}
