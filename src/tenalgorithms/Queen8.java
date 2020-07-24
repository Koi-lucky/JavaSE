package tenalgorithms;

public class Queen8 {
    //定义一个变量用于存储皇后个数
    int max = 8;
    //定义一个数组，用于存放皇后摆放的位置
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法！",count);
    }


    //写一个方法，用于输出合格的皇后位置，即数组
    private void printQueen() {
        count ++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //写一个方法，来判断当前所要放置的皇后是否与前面的皇后互相冲突

    /**
     *
     * @param n 这是放置第几个皇后
     * @return 不冲突返回true,若冲突则返回false
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //判断第n个皇后和前面的n-1个皇后是否在同一列arr[i] == arr[n]
            //判断第n个皇后和前面的n-1个皇后是否在同一对角线Math.abs(n - i) == Math.abs(arr[n] - arr[i]
            //例如：当n=1,意思是，放置第2列（i从0开始），arr[1]=1
            // ==> Math.abs(1 - 0) == Math.abs(arr[1] - arr[0])
            //没必要判断是否在同一行，因为你就是从第一行开始放，第一行的所有可能的位置都拿到后，才开始第二行，一行一行测试,每次n都在变化
            if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }


    //写一个放置皇后的方法
    //每一次递归，check都要进行for循环（判断每列能放皇后的所后可能——回溯）
    private void check(int n) {
        //如果n=max了，那就直接输出
        if(n == max) {
            printQueen();
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后放到第一列
            arr[n] = i;
            //判断当把第n个皇后放到第i列是，是否冲突
            if(judge(n)) {
                //不冲突，接着放第n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行arr[n]==i;即将这个皇后放在本行的下一个位置
        }
    }

}
