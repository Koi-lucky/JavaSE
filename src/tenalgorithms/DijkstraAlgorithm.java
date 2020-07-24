package tenalgorithms;

import java.util.Arrays;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        //测试迪杰斯特拉算法
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
        Graph graph = new Graph( vertex, matrix);
        System.out.println("生成的对应的图为：");
        graph.showGraph();
        System.out.println("迪杰斯特拉算法的实现：");
        graph.dsj(6);//6表示从G开始
        graph.showDijkstra();
    }
}


//创建图
class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//表示已访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示最终的结果
    public void showDijkstra() {
        vv.show();
    }

    //显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱结点
    private void update(int index) {
        //根据遍历的邻接矩阵的matrix[index]行
        for (int i = 0; i < matrix[index].length; i++) {
            //len的含义是：从出发顶点到index顶点的距离
            int len = vv.getDis(index) + matrix[index][i];
            //如果i顶点没有被访问过，并且len小于 出发顶点到i顶点的距离，就需要更新
            if(!vv.isIn(i) && len < vv.getDis(i)) {
                vv.updatePre( i, index);//更新i顶点的前驱结点为index顶点
                vv.updateDis( i, len);//更新出发顶点到i顶点的距离
            }
        }
    }

    //迪杰斯特拉算法的实现
    //给我传入出发顶点的下标
    public void dsj(int index) {
        vv = new VisitedVertex( vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int i = 0; i < vertex.length; i++) {
            index = vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }
}

//创建已访问顶点的集合
class VisitedVertex {
    //记录各个顶点是否访问过，1表示访问过，0表示未访问过，会动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点的下标，会动态更新
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离，比如G为出发顶点，就会记录G到其他顶点的距离，会动态更新，求得的最短距离就会存放到dis
    public int[] dis;

    //构造器
    /**
     *
     * @param length 表示顶点的个数
     * @param index 表示出发顶点的对应下标，比如G顶点下标就是6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill( dis, 65535);
        this.already_arr[index] = 1;//设置出发顶点被访问过
        this.dis[index] = 0;//设置出发顶点的访问距离为0
    }

    //判断这个index顶点是否被访问过
    public boolean isIn(int index) {
        return already_arr[index] == 1;//如果访问过就返回true，否则返回false
    }

    //更新出发顶点到index顶点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    //更新pre这个顶点的前驱结点为index顶点
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    //返回出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }

    //继续选择并返回新的访问节点，比如G访问完所有直接连通的顶点后，开始让A作为新的访问顶点（只是访问顶点，不是出发顶点）
    public int updateArr() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    //也就是将三个数组的情况输出
    public void show() {
        //输出already_arr
        System.out.println("already_arr数组的情况：");
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("====================");
        System.out.println("pre_visited数组的情况：");
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("====================");
        System.out.println("dis数组的情况：");
        for (int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}