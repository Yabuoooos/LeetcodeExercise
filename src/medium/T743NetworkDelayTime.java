package medium;

import org.junit.Test;

import java.util.Arrays;

public class T743NetworkDelayTime {

    final int INF = Integer.MAX_VALUE / 2;

    @Test
    public void test() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        //创建邻接矩阵存储边信息，默认值为INF
        int[][] g = new int[n][n];
        for (int[] ele : g) {
            Arrays.fill(ele, INF);
        }
        //设置各个边的值
        for (int[] netWork : times) {
            int row = netWork[0] - 1;
            int col = netWork[1] - 1;
            g[row][col] = netWork[2];
        }
        boolean[] isVisited = new boolean[n];
        int[] cost = new int[n];
        //源点到各个点所需花费的路径
        Arrays.fill(cost, INF);
        cost[k - 1] = 0;
        for (int i = 0; i < n; i++) {
           int x = -1;
           for (int y = 0; y < n; y++) {
               if (!isVisited[y] && (x == -1 || cost[y] < cost[x])) {
                   x = y;
               }
           }

           isVisited[x] = true;
           for (int y = 0; y < n; y++) {
               //x = y时值为INF故不会被更新
               cost[y] = Math.min(cost[y], cost[x] + g[x][y]);
           }
        }

        int res = Arrays.stream(cost).max().getAsInt();
        return res == INF ? -1 : res;
    }
}
