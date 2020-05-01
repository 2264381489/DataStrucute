package com  .  mine  .  sort ;
// {1,2,3,4,5,6}
// Find 4
// mid=3
//那么就向右递归,直到找到为止
public class BinarySearch {
    /**
     *
     * @param arr 一个已经排序的数组
     * @param target 一个目标
     * @param lo 最低的节点
     * @param hi 最高的节点
     * @return  返回是否找到
     */
    public static  boolean BinarySearch(int[] arr,int target,int lo,int hi){
        if (lo>hi){
            return false;
        }
     int mid=(lo+hi)/2;//找到中间值
        boolean a=false;

        if(target>arr[mid]){//大于中值向高位遍历
           a=BinarySearch(arr,target,mid+1,hi);//要把mid这个位置去掉,因为mid这个位置已经被验证过不是目标数了.要是不去掉,就会StackOver/ why?
            //because 1,2,3,4,5
            //第一次 mid=arr[2]=3 lo=0 hi=4
            //第二次 mid=arr[1]=2 lo=0 hi=2
            //第三次 mid=arr[1]=2 lo=0 hi=1
            //第四次 mid=arr[1]=2 lo=0 hi=1
            //死循环,导致虚拟机栈过多,StackOverFlow
        }else if (target<arr[mid]){//小于中值向低位遍历
            a=BinarySearch(arr,target,lo,mid-1);
        }else {
            return true;//都不是返回true
        }
        return a;

    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,5,6,7};
        if (BinarySearch(arr,11,0,arr.length-1)){
            System.out.println("找到了");
        }else{
            System.out.println("没找到");
        }
    }

}
