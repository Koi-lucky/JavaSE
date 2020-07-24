package tenalgorithms;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = { 1, 4, 3};//物品的重量
        int[] val = { 1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数

        //创建二维数组v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //创建一个二维数组，记录放入物品的情况
        int[][] path = new int[n + 1][m + 1];

        //初始化表的第一行和第一列的值
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        //用动态规划处理
        for (int i = 1; i < v.length; i++) {
            //不处理第一行
            for (int j = 1; j < v[i].length; j++) {
                //不处理第一列
                if(w[i - 1] > j) {//程序从i=1开始，所以w[i - 1]
                    v[i][j] = v[i - 1][j];
                } else {
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下，看一下目前表中的情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("======================");
        int i = path.length - 1;
        int j = path[0].length - 1;
        //输出一下包中放入的物品的情况
        while(i > 0 && j > 0) {
            if(path[i][j] == 1) {
                System.out.printf("将第%d个物品放入背包\n", i);
                j = j - w[i - 1];
            }
            i --;
        }
    }
}
