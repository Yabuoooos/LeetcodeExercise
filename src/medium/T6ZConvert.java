package medium;

public class T6ZConvert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        T6ZConvert test = new T6ZConvert();
        System.out.println(test.convert(s,4));

    }

    public String convert(String s, int numRows) {
        //当numRows = 1时，单行输出
        if (numRows == 1) return s;

        int len = s.length();
        int group = len % (2 * numRows - 2) == 0 ? len / (2 * numRows - 2) : len / (2 * numRows - 2) + 1;
        //创建一个二维数组用于按排序存放字符
        char[][] placement = new char[numRows][2 * group];

        for (int i = 0; i < len; i++) {
            int currGroup = (i + 1) % (2 * numRows - 2) == 0 ? (i + 1) / (2 * numRows - 2) : (i + 1) / (2 * numRows - 2) + 1;
            if ((i + 1) % (2 * numRows - 2) != 0 && (i + 1) % (2 * numRows - 2) <= numRows) {
                placement[(i + 1) % (2 * numRows - 2) - 1][currGroup * 2 - 2] = s.charAt(i);
            } else {
                placement[2 * numRows - ((i + 1) % (2 * numRows - 2) == 0 ? 2 * numRows - 2 : (i + 1) % (2 * numRows - 2)) - 1][currGroup * 2 - 1] = s.charAt(i);
            }
        }
        String res = "";

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[0].length; j++) {
                if (placement[i][j] != '\u0000'){
                    res += placement[i][j];
                }
            }
        }
        return res;

    }
}
