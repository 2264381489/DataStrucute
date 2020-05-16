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
////测试类
//    public static void main(String[] args) {
//        Integer[] arr=new Integer[]{1,2,4,3};
//       Genricate g=new Genricate();
//        dog dog=new dog();
//        System.out.println("");
//        System.out.println(g.search(arr,5,0,arr.length));
//
//       //int不能直接作为泛型传进去
////       g.sort(arr);
//       g.reverse(arr);
//       for(int i:arr){
//           System.out.print(i);//int 和 Integer的关系
//       }
//    }
////排序
//    public  <T extends Comparable> T[] sort(T[] arr) {
//        if (arr == null || arr.length < 2) {
//            return null;
//        }
//        //将最大值挨个放到最后边
//        for(int i=0;i<arr.length-1;i++){
//            //将最大的元素放到最后面
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
//    //折半查找
//    public  <T extends Comparable> boolean search(T[] arr,T target,int lo,int hi) {
//        if(lo>=hi)return false;
//        //大于目标向右,小于目标向左
//        int mid=(lo+hi)/2;//中点
//        if(target.compareTo(arr[mid])>0){
//          return   search(arr,target,mid+1,hi);
//        }else if (target.compareTo(arr[mid])<0){
//           return search(arr,target,lo,mid-1);
//        }else{
//            return true;
//        }
//    }
//    //翻转
//    public <T extends Comparable> void reverse(T[] arr){
//        int pre=0;
//        int last=arr.length-1;//双指针
//        //一根指针从0节点开始,另一根指针从末尾开始,两者不断地交换数据
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
    //数组大小
    private int size=0;
    private int oldsize=10;
    private Object[] arr;
    public ArrayList() {
        this.arr =new Object[oldsize];
    }

    /**
     * 添加方法
     * @param a
     */
    public void add(T a){
        extendLength();
        arr[size++]= a;
    }

    /**
     * 扩容方法
     */
    private void extendLength(){
        if(size>=oldsize-1){
            oldsize=(oldsize*3)/2;
            Object[] newArr=new Object[oldsize];
            /**
             * 从原数组赋值到新数组
             * 参数由左到右
             * srcPos:原来的数组
             * srcPos:原数组开始的位置
             * 新数组
             * 新数组开始的位置
             *
             */
            System.arraycopy(arr,0,newArr,0,size);
            this.arr=newArr;
        }
    }
    /**
     * 删除方法
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
//        integerArrayList.add("a");这个编译器会报错,这就是泛型的作用.让你可以传入固定的类型,防止错误
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