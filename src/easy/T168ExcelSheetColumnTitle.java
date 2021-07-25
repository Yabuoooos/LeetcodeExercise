package easy;


import java.util.Arrays;

public class T168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(78));
        String[] strs = new String[100];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = solution.convertToTitle(i + 1);
        }
        System.out.println(Arrays.toString(strs));
    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        String res = "";
        while (columnNumber > 0) {
            res = columnNumber % 26 == 0 ? 'Z' + res : (char) (columnNumber % 26 - 1 + 'A') + res;
            columnNumber = columnNumber % 26 == 0 ? columnNumber / 26 - 1 : columnNumber / 26;
        }
        return res;
    }
}
