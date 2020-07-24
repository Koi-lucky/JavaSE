package datastructure;

/**
【稀疏数组】
1.几行几列，有多少个不为0的数值
2.把具有不同值元素的行、列及值记录在一个小规模的数组里，从而缩小程序的规模

【原始二维数组——>稀疏数组】思路
1.遍历原始的二维数组，得到有效值的个数sum
2.根据sum来创建稀疏数组：new int[sum + 1][3]
3.将二维数组的有效值存入稀疏数组中

【稀疏数组——>二维数组】思路
1.根据稀疏数组第一行的数据，创建二维数组
2.再读取稀疏数组后几行的数据，并赋值给二维数组

 */
public class SparseArray {

    public static void main(String[] args) {
        //1.创建一个原始的二维数组
        //将其初始化,0:无子，1：黑子，2：蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出一下这个原始的棋盘
        for(int[] row : chessArr1) {
            for(int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("======================");

        //2.原始二维数组——>稀疏数组
        //遍历原始二维数组找到有效值的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0) {
                    sum ++;
                }
            }
        }
        //创建一个稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;//原始二维数组的行数
        sparseArr[0][1] = 11;//原始二维数组的列数
        sparseArr[0][2] = sum;//原始二维数组中的有效值个数
        //遍历原始二维数组，将有效值存入稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0) {
                    count ++;//用于判断是第几个有效值
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //遍历输出稀疏数组的形式
        for (int[] row : sparseArr) {
            for(int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        System.out.println("======================");


        //3.稀疏数组——>二维数组
        //先读取稀疏数组的第一行数据
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //再读取稀疏数组后几行的数据，并赋给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //展示一下由稀疏数组转换而来的二维数组
        for(int[] row : chessArr2) {
            for(int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
