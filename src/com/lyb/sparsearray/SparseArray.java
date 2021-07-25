package com.lyb.sparsearray;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/7/10
 * Time: 22:17
 * Description: No Description
 */
public class SparseArray {
    public static void main(String[] args) {
        //先创建一个原始的二维数组 11*11
        //0:表示没有棋子，1：表示黑子，2：表示白子
        int row = 11;
        int column = 11;
        int[][] chessArr1 = new int[row][column];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;

        //输出原始的二维数组
        System.out.println("输出原始的二维数组");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                if (data != 0)
                    sum++;
            }
        }
        System.out.println("sum:" + sum);
        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;//count用于记录是第几个非0的数据
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    ;
                    sparseArr[count][1] = j;
                    ;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }


        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组恢复成二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr=int[11][11]
        //2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可
        System.out.println();
        //先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];


        //在读取稀疏数组后几行的数据，并赋给原始的二维数组即可
        for (int i=1;i<sparseArr.length;i++){
            for (int j=0;j<3;j++){
                chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
            }
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("输出恢复后的二维数组");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(chessArr2[i][j] + "\t");
            }
            System.out.println();
        }












    }
}


