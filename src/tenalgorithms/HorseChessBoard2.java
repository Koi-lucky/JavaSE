package tenalgorithms;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 用贪心算法对“马踏棋盘问题”的优化
 */
public class HorseChessBoard2 {

    private static int X;//表示棋盘的行数
    private static int Y;//表示棋盘的列数
    //创建一个数组用来标记棋盘是否被访问过
    private static boolean[] visited;
    //使用一个属性，用来标记是否棋盘所有的位置都被访问过
    private static boolean finished;//如果都被访问过，则为true

    public static void main(String[] args) {

        X = 6;
        Y = 6;//构造6*6的棋盘
        int row = 1;
        int col = 1;//马的初始位置，row和col都从1开始
        //创建棋盘
        int[][] chess = new int[X][Y];
        visited = new boolean[X * Y];//初始值都是false
        travesalChess(chess , row - 1, col - 1, 1);
        //输出棋盘的最后情况
        for(int[] rows : chess) {
            for(int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


    //根据当前的位置，计算马儿还能走那些位置(Point)，并把它放入一个集合(ArrayList)中,最多走8个位置
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个点的集合
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个点
        Point p = new Point();
        //表示马儿可以走0这个位置
        if((p.x = curPoint.x + 2 ) < X && (p.y = curPoint.y - 1) >= 0) {
            //此时的p.x表示列，p.y表示行
            ps.add(new Point(p));
        }
        //表示马儿可以走1这个位置
        if((p.x = curPoint.x + 2 ) < X && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        //表示马儿可以走2这个位置
        if((p.x = curPoint.x + 1 ) < X && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //表示马儿可以走3这个位置
        if((p.x = curPoint.x - 1 ) >= 0 && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //表示马儿可以走4这个位置
        if((p.x = curPoint.x - 2 ) >= 0 && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        //表示马儿可以走5这个位置
        if((p.x = curPoint.x - 2 ) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        //表示马儿可以走6这个位置
        if((p.x = curPoint.x - 1 ) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        //表示马儿可以走7这个位置
        if((p.x = curPoint.x + 1 ) < X && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        return ps;
    }


    //马踏棋盘的核心算法
     public static void travesalChess(int[][] chess, int row, int col, int step) {
        chess[row][col] = step;
        //row * X + col表示此刻这个位置是第几个位置
         //当row=4，X=8，col=4时，4*8+4=36，
        visited[row * X + col] = true;//标记该位置已经访问
         //获取当前位置的可以走的下一个位置的集合
         ArrayList<Point> ps = next(new Point(col, row));
         //对ps进行排序，排序的规则是：对ps所有的point对象的下一步位置的数目，进行非递减排序
         sortArrayList(ps);
         //遍历ps
         while(!ps.isEmpty()) {
             Point p1 = ps.remove(0);//取出下一个可以走的位置
             //判断该点是否已经访问过
             if(!visited[p1.y * X + p1.x]) {
                 //说明还没访问过
                 travesalChess( chess, p1.y, p1.x, step + 1);
             }
         }
         //判断马儿是否完成了任务，也就是判断step是否等于应该走的步数
         //如果step<应走的步数，将整个棋盘置0
         //step<X*Y的情况有两种：
         //1.棋盘到目前为止仍然没有走完
         //2.棋盘处于一个回溯过程
         if(step < X * Y && !finished) {
             chess[row][col] = 0;
             visited[row * X + col] = false;
         } else {
             finished = true;
         }
     }


     //根据当前这一步的所有下一步的选择位置，进行非递减排序，为的是减少回溯的次数
    public static void sortArrayList(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1的下一步的所有位置个数
                int count1 = next(o1).size();
                //获取到o2的下一步的所有位置个数
                int count2 = next(o2).size();
                if(count1 < count2) {
                    return -1;
                } else if(count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

}
