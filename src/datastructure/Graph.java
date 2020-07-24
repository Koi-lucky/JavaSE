package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdeges;//表示边的数目
    //定义给数组boolean[]，记录某个节点是否被访问
    private boolean[] isVisited;
    public static void main(String[] args) {

        //测试图的创建是否成功
        int n = 5;//5个顶点
        String Vertexs[] = { "A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A—B,A—C,B—C,B—D,B—E
        graph.insertEdges( 0, 1, 1);
        graph.insertEdges( 0, 2, 1);
        graph.insertEdges( 1, 2, 1);
        graph.insertEdges( 1, 3, 1);
        graph.insertEdges( 1, 4, 1);
        //显示一下形成的邻接矩阵
        graph.showGraph();

        //测试dfs
        System.out.println("深度优先遍历");
        graph.dfs();//A —> B —> C —> D —> E —>
        //测试bfs
        System.out.println();
        System.out.println("广度优先遍历");
        graph.bfs();//A —> B —> C —> D —> E —>
    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和顶点的集合
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdeges = 0;
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加边
    /**
     *
     * @param v1 表示点的下标，即是第几个顶点 ，例如"A" — "B" （A点到B点）  表示的是下标 0 — 1
     * @param v2  第二个顶点对应的下标
     * @param weight  表示这两点之间的权重
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;//无向图两点之间的边，表示"A" — "B" ，"B" — "A"
        numOfEdeges++;
    }

    //图的相关常用方法
    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // 返回边的数目
    public int getNumOfEdeges() {
        return numOfEdeges;
    }
    // 显示图所对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //返回结点i（下标）所对应的数据：0 — "A" 1 — "B"  2 — "C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }



    //对一个节点深度优先遍历算法的思路过程
    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 1) {
                return i;
            }
        }
        return -1;
    }
    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if(edges[v1][i] > 1) {
                return i;
            }
        }
        return -1;
    }
    // 对一个节点进行深度优先遍历算法
    // i（下标）第一次就是0
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该节点，然后输出
        System.out.print(getValueByIndex(i) + " —> ");
        // 再将该节点设置已访问
        isVisited[i] = true;
        // 查找节点i的第一个邻接节点
        int w = getFirstNeighbor(i);
        while(w != -1) {//说明有这个结点
            if(!isVisited[w]) {
                dfs( isVisited, w);
            }
            //如果w结点已被访问过
            w = getNextNeighbor( i, w);
        }
    }
    //重载dfs方法，遍历所有的结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的节点，进行dfs ——》回溯
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs( isVisited, i);
            }
        }
    }


    //对一个节点广度优先遍历算法的思路过程
    private void bfs(boolean[] isVisited, int i) {
        int u = -1;//表示队列的头节点的对应下标
        int w = -1;//邻接节点w
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        //访问节点，输出节点的信息
        System.out.print(getValueByIndex(i) + " —> ");
        //标记节点为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);//【注意】是要加到队列的尾部
        while(w != -1) {
            //取出队列头结点的下标
            u = (Integer)queue.removeFirst();
            //得到第一个邻接点的下标w
            w = getFirstNeighbor(u);
            while(w != -1) {//找到了
                //是否访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + " —> ");
                    //标记已访问过
                    isVisited[w] = true;
                    //将其入队列
                    queue.addLast(w);
                }
                //以u为前驱结点，找w后面的下一个邻接点
                w = getNextNeighbor( u, w);//体现bfs
            }
        }
    }
    // 遍历所有的节点，对其进行bfs
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的节点，进行dfs ——》回溯
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs( isVisited, i);
            }
        }
    }
}
