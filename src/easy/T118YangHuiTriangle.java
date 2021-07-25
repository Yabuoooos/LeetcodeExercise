package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T118YangHuiTriangle {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(generate(n));
    }

    private static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        res.add(Arrays.asList(1));
        if (n == 1) return res;
        res.add(Arrays.asList(1,1));
        if (n == 2) return res;
        for (int i = 2; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) +  res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}

