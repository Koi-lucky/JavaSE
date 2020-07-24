package tenalgorithms;

/*
分治算法的典型例题——汉诺塔问题
（1）如果n=1，直接从A——>C;
（2）如果n=2,上面那个A——>B,
             下面那个A——>C,
             上面那个B——>C;
（3）如果n=3,把上面那两个看作一个盘A——>B,
             把最下面那个A——>C,
             再把最上面那两个B——>C;
（4）以此类推，所有n>=2的盘，都可以看作是两个盘在移动
 */
public class HanoiTowar {//HanoiTower...手抖打错了

    public static void main(String[] args) {

        hanoiTower(3 ,'A' ,'B' ,'C');
    }

    public static void hanoiTower(int n, char a, char b, char c) {
        //如果只有一个盘，直接从A——>C
        if(n == 1) {
            System.out.println("Mpve dish " + n + " from " + a + " to " + c);
        } else {
            //如果有n>=2个盘，都可以看作是两个盘在移动，即：最底下的那个是一个盘，上面的所有算作一个盘
            //把上面那些个看作一个盘，从A——>B
            //把最下面那个盘，从A——>C
            //再把最上面那些个盘，从B——>C
            hanoiTower(n -1 , a, c, b);
            System.out.println("Mpve dish " + n + " from " + a + " to " + c);
            hanoiTower(n -1 , b, a, c);
        }
    }
}
