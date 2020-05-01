package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//import static com.atguigu.sort.RadixSort.radixSort;

public class RadixSort1 {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println("基数排序后 " + Arrays.toString(arr));

    }

    private static void radixSort(int[] arr) {
        //先找出全部数据中数据最大长度
        int max = arr[0];//假设第一个就是最大值
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxlength = (max + "").length();//求出最大值的位数

        int[][] bucket = new int[10][arr.length];//建造桶
        int[] bucketElementCounts = new int[10];//确定每个桶中有多少个数组

//将数据放入桶中
        //处理对象:单个数字
        for (int i = 0, n = 1; i < maxlength; i++, n *= 10) { //一次找寻一位543第一次找到3第二次找到4第三次找到5
         //处理对象:整个数组
            for (int j = 0; j < arr.length; j++) { //将数组中的每个数组都放入桶中
                int digitOfElement = arr[j] / n % 10;
//                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
                //将一个数据放在对应的桶中,并且记录这个桶中放入了多少数字
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;//记录桶中放了多少数字
            }
            //将数据从桶中取出,拿回原来的数组中
            int index = 0;//原先的数组下标,
            //将数据从
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCounts[j] = 0;//将记录每个桶中数组的个数的数组归零
            }

        }
    }
}
