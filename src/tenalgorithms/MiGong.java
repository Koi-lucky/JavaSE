package tenalgorithms;

public class MiGong {

    public static void main(String[] args) {
        //先创建一个地图
        int[][] map = new int[8][7];
        //设置迷宫的墙,1为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，1表示挡板
        map[2][1] = 1;
        map[2][2] = 1;
        //输出未出发前的地图
        System.out.println("出发前的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        //调用方法1给小球找路
        setWay1(map, 1, 1);
        //输出已找到通路的地图
        System.out.println("已找到通路的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //调用方法2给小球找路
        setWay2(map, 1, 1);
        //输出已找到通路的地图
        System.out.println("随便换一个走法的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //现在开始给小球找路
    //用0表示没走过，1表示墙，2表示已走过的通路，3表示以走过的死路
    //定一个给小球找路的顺序，比如：下——>右——>上——>左
    //给小球设置一个初始的位置i,j      表示从这个位置开始走
    //走到最后一个位置map[6][5]表示找路成功

    /**
     *
     * @param map 地图
     * @param i i和j表示小球初始位置的坐标
     * @param j
     * @return 若找到了最后一个位置则表示成功，返回true，否则返回false
     */
    public static boolean setWay1(int[][] map, int i, int j) {
        if(map[6][5] == 2) {//已经到达最后一个位置，表示通路已找到
            return true;
        } else {
            if(map[i][j] == 0) {//没走过的路
                map[i][j] = 2;//开始假定这条路可以走通
                if(setWay1(map , i + 1, j)) {//向下走
                    return true;
                } else if(setWay1(map , i, j + 1)) {//向右走
                    return true;
                } else if(setWay1(map , i - 1, j)) {//向上走
                    return true;
                } else if(setWay1(map , i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;//上下左右都走不通，设置为3，开始返回上一步——>回溯
                    return false;
                }
            } else {//如果map[i][j]!=0,则他可能的值为1,2,3
                return false;
            }
        }
    }


    //随便换一个走法
    public static boolean setWay2(int[][] map, int i, int j) {
        if(map[6][5] == 2) {//已经到达最后一个位置，表示通路已找到
            return true;
        } else {
            if(map[i][j] == 0) {//没走过的路
                map[i][j] = 2;//开始假定这条路可以走通
                if(setWay1(map , i - 1, j)) {//向上走
                    return true;
                } else if(setWay1(map , i, j - 1)) {//向左走
                    return true;
                } else if(setWay1(map , i + 1, j)) {//向下走
                    return true;
                } else if(setWay1(map , i, j + 1)) {//向右走
                    return true;
                } else {
                    map[i][j] = 3;//上下左右都走不通，设置为3，开始返回上一步——>回溯
                    return false;
                }
            } else {//如果map[i][j]!=0,则他可能的值为1,2,3
                return false;
            }
        }
    }
}
