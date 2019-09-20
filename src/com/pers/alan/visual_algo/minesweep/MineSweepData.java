package com.pers.alan.visual_algo.minesweep;

public class MineSweepData {

    public static final String blockImageURL = "src/resources/minesweepImg/block.png";
    public static final String flagImageURL = "src/resources/minesweepImg/flag.png";
    public static final String mineImageURL = "src/resources/minesweepImg/mine.png";
    public static String numberImageURL(int num){
        if(num < 0 || num >= 8)
            throw new IllegalArgumentException("No such a number image!");
        return "src/resources/minesweepImg/" + num + ".png";
    }

    //N 横
    //M 纵
    private int N, M;
    //雷
    private boolean[][] mines;
    //旗子
    public boolean[][]flag;
    //雷周围数字
    private int[][] numbers;

    //是否被翻开
    public boolean[][]open;



    public MineSweepData(int N, int M, int mineNumber){

        if(N <= 0 || M <= 0)
            throw new IllegalArgumentException("Mine sweeper size is invalid!");

        if(mineNumber < 0 || mineNumber > N*M)
            throw new IllegalArgumentException("Mine number is out of bounds!");

        this.N = N;
        this.M = M;
        mines = new boolean[N][M];
        flag = new boolean[N][M];
        numbers = new int[N][M];
        open = new boolean[N][M];


        for(int i = 0 ; i < N ; i ++)
            for(int j = 0 ; j < M ; j ++){
                mines[i][j] = false;
                flag[i][j] = false;
                numbers[i][j] = 0;
                open[i][j] = false;
            }
        generateMines(mineNumber);
        calculateNumbers();
    }


    public int N(){ return N; }
    public int M(){ return M; }

    public boolean isMine(int x, int y){
        if(!inArea(x, y))
            throw new IllegalArgumentException("Out of index in isMine function!");
        return mines[x][y];
    }
    /*/**
     * @title
     * @description 赋值 遍历雷区周围3x3矩阵
     * @author wg
     * @updateTime 2019/9/7 0:15
     * @throws
     */
    private void calculateNumbers() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mines[i][j])
                    numbers[i][j] = -1;

                numbers[i][j]=0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {
                        if (inArea(k,l)&&mines[k][l])
                            numbers[i][j]++;
                    }
                }
            }
        }
    }


    public boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    /*/**
     * @title
     * @description    Kunth洗牌算法 注意随机数偏移量
     * @author wg
     * @param: mineNumber
     * @updateTime 2019/9/7 0:01
     * @throws
     */
    private void generateMines(int mineNumber){
        for (int i = 0; i < mineNumber; i++) {
            int x = i / M;
            int y = i % M;
            mines[x][y] = true;
        }
        for (int i = 0; i < mineNumber; i++) {
            int x = i / M;
            int y = i % M;

            int ran = (int)(Math.random() * (N*M-i)+i);
            int ranX = ran / M;
            int ranY = ran % M;
            swap(x,y,ranX,ranY);
        }
    }

    private void swap(int x1, int y1, int x2, int y2) {
        boolean flag  = mines[x1][y1];
        mines[x1][y1] = mines[x2][y2];
        mines[x2][y2] = flag;
    }
/*    private void generateMines(int mineNumber){

        for (int i = 0; i < mineNumber; i++) {
            while (true){
                int x = (int)(Math.random() * N);
                int y = (int)(Math.random() * M);
                if (!isMine(x,y)){
                    mines[x][y]=true;
                    break;
                }
            }
        }
    }*/

    public int getNumbers(int x,int y) {
        return numbers[x][y];
    }

    public void open(int x,int y){
        if (!inArea(x,y))
            throw  new IllegalArgumentException("out of edge.");
        if (isMine(x,y))
            throw  new IllegalArgumentException("the block is a mine");

        open[x][y] = true;

        if (numbers[x][y]>0)
            return;

        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (inArea(i,j) && !open[i][j] && !mines[i][j])
                open(i,j);
            }
        }

    }
}
