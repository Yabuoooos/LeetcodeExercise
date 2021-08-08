package easy;

import org.junit.Test;

import java.util.*;

public class T1337KWeaknessRow {

    @Test
    public void test() {
        int[][] mat = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        System.out.println(Arrays.toString(kWeakestRows(mat,4)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length;
        int[] info = new int[len];
        for (int i = 0; i < len; i++) {
            //最多不超过100人
            info[i] = 100 * getSoldierNum(mat[i]) + i;
        }
        Arrays.sort(info);
        int[] res = new int[k];
        for(int i = 0; i<k;i++) {
            res[i] = info[i] % 100;
        }
        return res;
    }

    //返回士兵数目
    private int getSoldierNum(int[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == 1) {
            index++;
        }
        return index;
    }
}
