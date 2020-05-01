package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//import static com.atguigu.sort.RadixSort.radixSort;

public class RadixSort1 {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

        System.out.println("��������� " + Arrays.toString(arr));

    }

    private static void radixSort(int[] arr) {
        //���ҳ�ȫ��������������󳤶�
        int max = arr[0];//�����һ���������ֵ
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxlength = (max + "").length();//������ֵ��λ��

        int[][] bucket = new int[10][arr.length];//����Ͱ
        int[] bucketElementCounts = new int[10];//ȷ��ÿ��Ͱ���ж��ٸ�����

//�����ݷ���Ͱ��
        //�������:��������
        for (int i = 0, n = 1; i < maxlength; i++, n *= 10) { //һ����Ѱһλ543��һ���ҵ�3�ڶ����ҵ�4�������ҵ�5
         //�������:��������
            for (int j = 0; j < arr.length; j++) { //�������е�ÿ�����鶼����Ͱ��
                int digitOfElement = arr[j] / n % 10;
//                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
                //��һ�����ݷ��ڶ�Ӧ��Ͱ��,���Ҽ�¼���Ͱ�з����˶�������
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;//��¼Ͱ�з��˶�������
            }
            //�����ݴ�Ͱ��ȡ��,�û�ԭ����������
            int index = 0;//ԭ�ȵ������±�,
            //�����ݴ�
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCounts[j] = 0;//����¼ÿ��Ͱ������ĸ������������
            }

        }
    }
}
