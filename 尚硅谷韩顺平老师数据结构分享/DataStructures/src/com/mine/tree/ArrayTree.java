package com.mine.tree;

public class ArrayTree {
    int[] arr;
    public ArrayTree(int[] arr){
        this.arr=arr;
    }
    //�����������
    public void preOrder(){
        this.preOrder(0);
    }
    //�������,������������ֵ��2n+1,������������ֵ��2n+2
    private void preOrder(int n){
        if(arr==null||arr.length==0){
            System.out.println("��������ǿյ�");
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
