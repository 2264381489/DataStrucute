package com.mine.sort;

public class insertValueSearch {
    public static  boolean insertvaluesearch(int[] arr, int target, int lo, int hi){
        if (lo>hi){
            return false;
        }
        int mid=(target-arr[lo])/(arr[hi]-arr[lo])*(hi-lo)+lo;//�ҵ��м�ֵ
        //������һ����ʽ���ɵ�.��Ŀ��ֵ��������Сֵ�Ĳ���������ֵ����Сֵ�Ĳ�,������������ȡ�ó���.�õ�һ������.������ͽڵ�.
        //���ﲻ��ʹ�����鳤��,��Ϊ������������ֵ���ǲ�ֵ���õ��м�ֵ.
        boolean a=false;

        if(target>arr[mid]){//������ֵ���λ����
            a= insertvaluesearch(arr,target,mid+1,hi);//Ҫ��mid���λ��ȥ��,��Ϊmid���λ���Ѿ�����֤������Ŀ������.Ҫ�ǲ�ȥ��,�ͻ�StackOver/ why?

        }else if (target<arr[mid]){//С����ֵ���λ����
            a= insertvaluesearch(arr,target,lo,mid-1);
        }else {
            return true;//�����Ƿ���true
        }
        return a;

    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,200,300,4500,5000,6000,7000};
        if (insertvaluesearch(arr,5000,0,arr.length-1)){
            System.out.println("�ҵ���");
        }else{
            System.out.println("û�ҵ�");
        }
    }
}
