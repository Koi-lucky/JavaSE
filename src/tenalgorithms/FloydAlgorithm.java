package tenalgorithms;

import java.util.Arrays;

public class FloydAlgorithm {

    public static void main(String[] args) {
        //测试弗洛伊德算法
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;//表示这两点间不直接连通
        int[][] matrix = {
                { N, 5, 7, N, N, N,2},
                { 5, N, N, 9, N , N, 3},
                { 7, N, N, N, 8, N, N},
                { N, 9, N, N, N, 4, N},
                { N, N, 8, N, N, 5, 4},
                { N, N, N,4, 5, N, 6},
                { 2, 3, N, N, 4, 6, N}
        };
        //创建图对象
        FloydGraph graph = new FloydGraph( vertex.length, matrix, vertex);
        //测试弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}


//创建图
class FloydGraph {
    private char[] vertex;//存放顶点的数组
    private int[][] dis;//保存：从各个定点出发到其他顶点的距离
    private int[][] pre;//保存到达目标顶点的前驱结点

    public FloydGraph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //对pre数组初始化，注意存放的是前驱结点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //显示pre数组和dis数组
    public void show() {
        //为了便于输出，进行优化
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            //先将pre数组输出的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            //输出dis数组的一行数据
            for (int j = 0; j < dis.length; j++) {
                System.out.print("(" + vertex[k] + "到" + vertex[j] + "最短路径是：" + dis[k][j] + ")" );
            }
            System.out.println();
            System.out.println();
        }
    }

    //弗洛伊德算法
    public void floyd() {
        int len = 0;//定义变量保存距离
        //对中间顶点进行遍历，k就是中间顶点的下标[A,B,C,D,E,F,G]
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始作为出发点出发[A,B,C,D,E,F,G]
            for (int i = 0; i < dis.length; i++) {
                //到达j顶点[A,B,C,D,E,F,G]
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];//从顶点i开始出发，经过顶点k，到达顶点j
                    if(len < dis[i][j]) {//如果 len小于 dis[i][j]
                        dis[i][j] = len;//更新距离
                        pre[i][j] = pre[k][j];//更新前驱结点
                    }
                }
            }
        }
    }
}