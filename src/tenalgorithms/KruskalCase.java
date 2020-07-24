package tenalgorithms;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    //使用Integer的最大值表示两条边不连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        //测试克鲁斯卡尔算法
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                { 0, 12, INF, INF, INF, 16, 14},
                { 12, 0, 10, INF, INF, 7, INF},
                { INF, 10, 0, 3, 5, 6, INF},
                { INF, INF, 3, 0, 4, INF, INF},
                { INF, INF, 5, 4, 0, 2, 8},
                { 16, 7, 6, INF, 2, 0, 9},
                { 14, INF, INF, INF, 8, 9, 0}
        };
        KruskalCase kruskalCase = new KruskalCase( vertexs, matrix);
        kruskalCase.show();
        kruskalCase.kruskal();
    }

    //构造器
    public KruskalCase(char[] vertexs, int[][] matrix) {
        //以下的初始化都通过复制拷贝的方式实现
        //也可以直接构造方法，二者皆可

        this.vertexs = new char[vertexs.length];//初始化顶点
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vertexs.length][vertexs.length];//初始化边
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边的条数
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //打印邻接矩阵
    public void show() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //返回顶点对应下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch) {
                return i;
            }
        }
        return -1;//找到就返回对应下标，没找到就返回-1
    }

    //获取图中的每条边及权值大小
    /**
     * 通过matrix邻接矩阵来获取图中的边，放到EData[]数组中
     * EData[]的形式如：[['A','B',12],['B','F',7]......]
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //对边进行排序——冒泡排序
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j + 1].weight) {
                    //进行交换
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    //获取该顶点的终点——用于后面的克鲁斯卡尔算法中判断两个顶点的终点是否相同

    /**
     *   获取下标为i的顶点的终点，用于后面的算法中判断两个顶点的终点是否相同
     * @param ends 这个数组就是记录各个顶点对应的终点是哪个，这个ends数组是在遍历中逐步形成的
     * @param i 表示要传入的顶点的对应下标
     * @return 返回的是 下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {//
            i = ends[i];
        }
        return i;
    }

    //克鲁斯卡尔算法
    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存“已有最小生成树”中的每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] res = new EData[edgeNum];
        //获取图中的所有边的集合
        EData[] edges = getEdges();
        System.out.println("图中所有边的集合为： " + Arrays.toString(edges));
        System.out.println("一共" + edges.length + "条边");
        //按边的权值大小进行排序
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树时，判断 即将准备加入的边 是否形成了回路，如果没有就加入结果集中，否则就不加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第1个顶点（作为起点）
            int p1 = getPosition(edges[i].start);
            // 获取到第i条边的第2个顶点（作为终点）
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd(ends, p2);
            //判断是否构成回路
            if(m != n) {
                //没有构成回路
                ends[m] = n;//设置m在“已有最小生成树”中的终点
                res[index++] = edges[i];//有一条边加到结果集中
            }
        }
        //统计并打印“最小生成树”，输出结果集
        System.out.println("最小生成树为：");
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
    }
}


//创建一个类EData，他的对象实例就表示一条边
class EData {
    char start;//边的一个点
    char end;//边的另一个点
    int weight;//边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return " < " + start + "," + end + " > = " + weight + " ";
    }
}