package homework;

////import org.omg.CORBA.Object;
//import sun.net.www.content.text.Generic;
//
//import java.lang.reflect.Array;
//
////class dog implements Comparable {
////
////    @Override
////    public int compareTo(Object o) {
////        return 0;
////    }
////}
//public class Genricate {
////������
//    public static void main(String[] args) {
//        Integer[] arr=new Integer[]{1,2,4,3};
//       Genricate g=new Genricate();
//        dog dog=new dog();
//        System.out.println("");
//        System.out.println(g.search(arr,5,0,arr.length));
//
//       //int����ֱ����Ϊ���ʹ���ȥ
////       g.sort(arr);
//       g.reverse(arr);
//       for(int i:arr){
//           System.out.print(i);//int �� Integer�Ĺ�ϵ
//       }
//    }
////����
//    public  <T extends Comparable> T[] sort(T[] arr) {
//        if (arr == null || arr.length < 2) {
//            return null;
//        }
//        //�����ֵ�����ŵ�����
//        for(int i=0;i<arr.length-1;i++){
//            //������Ԫ�طŵ������
//            for (int j = 0; j <arr.length-i-1 ; j++) {
//                if(arr[j].compareTo(arr[j+1])>0){
//                    T temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//               }
//
//            }
//        }
//        return arr ;
//    }
//    //�۰����
//    public  <T extends Comparable> boolean search(T[] arr,T target,int lo,int hi) {
//        if(lo>=hi)return false;
//        //����Ŀ������,С��Ŀ������
//        int mid=(lo+hi)/2;//�е�
//        if(target.compareTo(arr[mid])>0){
//          return   search(arr,target,mid+1,hi);
//        }else if (target.compareTo(arr[mid])<0){
//           return search(arr,target,lo,mid-1);
//        }else{
//            return true;
//        }
//    }
//    //��ת
//    public <T extends Comparable> void reverse(T[] arr){
//        int pre=0;
//        int last=arr.length-1;//˫ָ��
//        //һ��ָ���0�ڵ㿪ʼ,��һ��ָ���ĩβ��ʼ,���߲��ϵؽ�������
//        while(pre<=last){
//             T ar=null;
//             ar=arr[pre];
//             arr[pre]=arr[last];
//             arr[last]=ar;
//            pre++;
//            last--;
//        }
//    }
//    //
//}


class ArrayList<T>{
    //�����С
    private int size=0;
    private int oldsize=10;
    private Object[] arr;
    public ArrayList() {
        this.arr =new Object[oldsize];
    }

    /**
     * ��ӷ���
     * @param a
     */
    public void add(T a){
        extendLength();
        arr[size++]= a;
    }

    /**
     * ���ݷ���
     */
    private void extendLength(){
        if(size>=oldsize-1){
            oldsize=(oldsize*3)/2;
            Object[] newArr=new Object[oldsize];
            /**
             * ��ԭ���鸳ֵ��������
             * ����������
             * srcPos:ԭ��������
             * srcPos:ԭ���鿪ʼ��λ��
             * ������
             * �����鿪ʼ��λ��
             *
             */
            System.arraycopy(arr,0,newArr,0,size);
            this.arr=newArr;
        }
    }
    /**
     * ɾ������
     */
     public void remove(){
         arr[--size]=null;
     }
   public void toList(){
       for (Object o: arr) {
           System.out.print(o);
       }
   }
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(12);
//        integerArrayList.add("a");����������ᱨ��,����Ƿ��͵�����.������Դ���̶�������,��ֹ����
        integerArrayList.add(3);
        integerArrayList.add(3);
        integerArrayList.add(3);
         integerArrayList.add(4);
        integerArrayList.add(3);
        integerArrayList.add(3);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(3);
        integerArrayList.add(3);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.remove();
        integerArrayList.toList();

    }
//java.util.ArrayList

}