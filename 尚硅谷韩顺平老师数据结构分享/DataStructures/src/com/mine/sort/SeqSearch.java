package com.mine.sort;

public class SeqSearch {

    /**
     * ���Բ���
     * @param i ���������
     * @param target  Ҫ���ҵ�Ŀ��
     * @return  �Ƿ��ҵ�
     */
    public static boolean sort(int[] i,int target){
        for (int j = 0; j <i.length ; j++) {
            if(i[j]==target)return true;

        }
    return false;
    }

    public static void main(String[] args) {
        if (sort(new int[]{1,4,5,6,7},5)){
            System.out.println("�ҵ���");
        }else{
            System.out.println("û�ҵ�");
        }
    }
}
