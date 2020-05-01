package com.mine.sort;

public class SeqSearch {

    /**
     * 线性查找
     * @param i 输入的数组
     * @param target  要查找的目标
     * @return  是否找到
     */
    public static boolean sort(int[] i,int target){
        for (int j = 0; j <i.length ; j++) {
            if(i[j]==target)return true;

        }
    return false;
    }

    public static void main(String[] args) {
        if (sort(new int[]{1,4,5,6,7},5)){
            System.out.println("找到了");
        }else{
            System.out.println("没找到");
        }
    }
}
