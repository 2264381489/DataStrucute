package com.atguigu.recursion;

public class Queue {
    private final int max = 8;
    int[] arr = new int[8];//用一个数组来表示整个棋盘,角标+1是列数组的值是行
    static int count=0;//总共有多少种方法
   static int judegecount=0;//冲突判断次数
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.printf("一共有%d种解法",count);
        System.out.printf("一共解决%d种冲突",judegecount);

    }

    /**
     * 确定是否在正确的位置上
     * 编写一个方法，放置第n个皇后
     * 要用到递归
     */
    void check(int n) {
        if (n == max) {
            print();
            return;
        }
        /**
         * 第一个皇后先放第一行第一列
         * 第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
         * 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
         * 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
         * 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
         */
        for (int i = 0; i <max; i++) {
            arr[n] = i;//角标是列,值是行
            if (judge(n)) {
                //接着放n+1个
                check(n + 1);
            }
        }

    }

    /**
     *判断输入节点是否符合
     */
    boolean judge(int n) {
        judegecount++;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }

        }

        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }
}
