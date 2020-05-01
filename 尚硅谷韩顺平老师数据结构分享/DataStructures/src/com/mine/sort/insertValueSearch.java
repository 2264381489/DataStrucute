package com.mine.sort;

public class insertValueSearch {
    public static  boolean insertvaluesearch(int[] arr, int target, int lo, int hi){
        if (lo>hi){
            return false;
        }
        int mid=(target-arr[lo])/(arr[hi]-arr[lo])*(hi-lo)+lo;//找到中间值
        //这是由一个公式构成的.用目标值到数组最小值的差除数组最大值到最小值的差,乘上现在所截取得长度.得到一个长度.加上最低节点.
        //这里不能使用数组长度,因为我们无论是中值还是插值都用的中间值.
        boolean a=false;

        if(target>arr[mid]){//大于中值向高位遍历
            a= insertvaluesearch(arr,target,mid+1,hi);//要把mid这个位置去掉,因为mid这个位置已经被验证过不是目标数了.要是不去掉,就会StackOver/ why?

        }else if (target<arr[mid]){//小于中值向低位遍历
            a= insertvaluesearch(arr,target,lo,mid-1);
        }else {
            return true;//都不是返回true
        }
        return a;

    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,200,300,4500,5000,6000,7000};
        if (insertvaluesearch(arr,5000,0,arr.length-1)){
            System.out.println("找到了");
        }else{
            System.out.println("没找到");
        }
    }
}
