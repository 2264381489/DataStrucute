package com  .  mine  .  sort ;
// {1,2,3,4,5,6}
// Find 4
// mid=3
//��ô�����ҵݹ�,ֱ���ҵ�Ϊֹ
public class BinarySearch {
    /**
     *
     * @param arr һ���Ѿ����������
     * @param target һ��Ŀ��
     * @param lo ��͵Ľڵ�
     * @param hi ��ߵĽڵ�
     * @return  �����Ƿ��ҵ�
     */
    public static  boolean BinarySearch(int[] arr,int target,int lo,int hi){
        if (lo>hi){
            return false;
        }
     int mid=(lo+hi)/2;//�ҵ��м�ֵ
        boolean a=false;

        if(target>arr[mid]){//������ֵ���λ����
           a=BinarySearch(arr,target,mid+1,hi);//Ҫ��mid���λ��ȥ��,��Ϊmid���λ���Ѿ�����֤������Ŀ������.Ҫ�ǲ�ȥ��,�ͻ�StackOver/ why?
            //because 1,2,3,4,5
            //��һ�� mid=arr[2]=3 lo=0 hi=4
            //�ڶ��� mid=arr[1]=2 lo=0 hi=2
            //������ mid=arr[1]=2 lo=0 hi=1
            //���Ĵ� mid=arr[1]=2 lo=0 hi=1
            //��ѭ��,���������ջ����,StackOverFlow
        }else if (target<arr[mid]){//С����ֵ���λ����
            a=BinarySearch(arr,target,lo,mid-1);
        }else {
            return true;//�����Ƿ���true
        }
        return a;

    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,5,6,7};
        if (BinarySearch(arr,11,0,arr.length-1)){
            System.out.println("�ҵ���");
        }else{
            System.out.println("û�ҵ�");
        }
    }

}
