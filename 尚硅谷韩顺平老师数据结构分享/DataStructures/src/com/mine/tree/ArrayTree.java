package com.mine.tree;

public class ArrayTree {
    int[] arr;
    public ArrayTree(int[] arr){
        this.arr=arr;
    }
    //先序遍历函数
    public void preOrder(){
        this.preOrder(0);
    }
    //先序遍历,左子树是输入值的2n+1,右子树是输入值的2n+2
    private void preOrder(int n){
        if(arr==null||arr.length==0){
            System.out.println("这个数组是空的");
        }
        System.out.println(arr[n]);
        if((2*n+1)<arr.length){
            preOrder(2*n+1);
        }
//        System.out.println(arr[n]);
        if ((2*n+2)<arr.length){
            preOrder(2*n+2);
        }
    }
}
