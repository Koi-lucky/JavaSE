package tenalgorithms;

import java.util.Arrays;

public class PrimAlgorithm {

    public static void main(String[] args) {

        //测试创建的图是否成功
        char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示，10000这个大数，表示这两个点不联通
        int[][] weight = {
                { 10000, 5, 7, 10000, 10000, 10000, 2},
                { 5, 10000, 10000, 9, 10000, 10000, 3},
                { 7, 10000, 10000, 10000, 8, 10000, 10000},
                { 10000, 9, 10000, 10000, 10000, 4, 10000},
                { 10000, 10000, 8, 10000, 10000, 5, 4},
                { 10000, 10000, 10000, 4, 5, 10000, 6},
                { 2, 3, 10000, 10000, 4, 6, 10000}
        };

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个最小生成树的对象
        MinTree minTree = new MinTree();
        minTree.creatGraph( graph, verxs, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普里姆算法
        minTree.prim( graph, 1);//从第一个节点开始
    }
}


//创建最小生成树
class MinTree {
    //创建图的邻接矩阵
    //你要传给我：图这个对象，图对应的节点的个数，图的各个顶点的值，图的邻接矩阵
    public void creatGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {//权值
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写Prim算法 ——> 得到最小生成树
    //你要给我传的值：图对象，从图的第几个顶点开始的（'A'-> 0, 'B'->1 ……）
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verxs];//用于标记节点是否被访问过 ——> 默认值0表示未被访问，访问过就设为1
        //将当前这个节点标记为已访问
        visited[v] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将minWeight初始成一个最大数，后面在替换的时候会进行替换
        for (int k = 1; k < graph.verxs; k++) {//因为有graph.verxs顶点，普里姆算法结束后，有graph.verxs-1条边
            //这个是确定每一次生成的子图，和哪个节点的距离更近
            for (int i = 0; i < graph.verxs; i++) {//i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j结点表示还没有访问过的节点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight（寻找已经访问过的结点和未访问过的节点间的权值最小的边）
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小的了
            System.out.println("边 < " + graph.data[h1] + " ," + graph.data[h2] + " > , 权值： " + minWeight);
            //将当前这个节点标记为已访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }
}


//创建图的节点
class MGraph {
    int verxs;//表示图的节点的个数
    char[] data;//存放节点的数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}