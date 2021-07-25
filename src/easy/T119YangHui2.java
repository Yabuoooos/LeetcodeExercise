package easy;

import org.junit.Test;

import java.util.*;

/*
    给定一个非负索引，其中 k≤33，返回杨辉三角的第 k 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
    示例:
    输入: 3
    输出: [1,3,3,1]
 */
public class T119YangHui2 {
    @Test
    public void test() {
        System.out.println(getRow(31));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> currRow = new ArrayList<>();
        //C(n,i) = n!/i!(n - i)!
        //C(n,i - 1) = n!/(i - 1)!(n - 1 + 1)!
        //C(n,i) / C(n, i - 1) = (n - i + 1) / i
        currRow.add(1);
        for (int i = 1; i < rowIndex / 2 + 1; i++) {
            currRow.add((int) (currRow.get(i - 1) * (double)(rowIndex - i + 1) / i));
        }
        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++) {
            currRow.add(currRow.get(rowIndex - i));
        }
        return currRow;
    }
}
