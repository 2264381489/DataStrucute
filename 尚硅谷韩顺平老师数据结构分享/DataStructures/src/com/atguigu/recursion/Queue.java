package com.atguigu.recursion;

public class Queue {
    private final int max = 8;
    int[] arr = new int[8];//��һ����������ʾ��������,�Ǳ�+1���������ֵ����
    static int count=0;//�ܹ��ж����ַ���
   static int judegecount=0;//��ͻ�жϴ���
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.printf("һ����%d�ֽⷨ",count);
        System.out.printf("һ�����%d�ֳ�ͻ",judegecount);

    }

    /**
     * ȷ���Ƿ�����ȷ��λ����
     * ��дһ�����������õ�n���ʺ�
     * Ҫ�õ��ݹ�
     */
    void check(int n) {
        if (n == max) {
            print();
            return;
        }
        /**
         * ��һ���ʺ��ȷŵ�һ�е�һ��
         * �ڶ����ʺ���ڵڶ��е�һ�С�Ȼ���ж��Ƿ�OK�� �����OK���������ڵڶ��С������С����ΰ������ж����꣬�ҵ�һ������
         * �����������ʺ󣬻��ǵ�һ�С��ڶ��С���ֱ����8���ʺ�Ҳ�ܷ���һ������ͻ��λ�ã������ҵ���һ����ȷ��
         * ���õ�һ����ȷ��ʱ����ջ���˵���һ��ջʱ���ͻῪʼ���ݣ�������һ���ʺ󣬷ŵ���һ�е�������ȷ�⣬ȫ���õ�.
         * Ȼ���ͷ������һ���ʺ�ŵڶ��У��������ѭ��ִ�� 1,2,3,4�Ĳ���
         */
        for (int i = 0; i <max; i++) {
            arr[n] = i;//�Ǳ�����,ֵ����
            if (judge(n)) {
                //���ŷ�n+1��
                check(n + 1);
            }
        }

    }

    /**
     *�ж�����ڵ��Ƿ����
     */
    boolean judge(int n) {
        judegecount++;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }

        }

        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }
}
