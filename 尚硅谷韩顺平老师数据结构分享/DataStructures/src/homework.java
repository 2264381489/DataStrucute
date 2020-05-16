import java.util.LinkedList;
import java.util.Scanner;

public class homework {

   private LinkedList<Integer> list=new LinkedList<>();//构建栈
    LinkedList<Integer>   stack;//辅助栈

    public void add(int a){
        list.addFirst(a);
        display();
    }
    public int remove(){
       return list.removeFirst();
    }
    private void display(){
     stack=list;
//     StringBuffer str=new StringBuffer();
     int flag=0;
//        for (int i:stack) {
//            if(flag>2)break;
//            str.append(i);
//            flag++;
//        }
//        System.out.println(str.reverse());
     int i=stack.size()<3?stack.size()-1:2;//大于3用3小于3用集合长度
     while(!stack.isEmpty()&&i>=0){
       int a=stack.get(i);
         System.out.print(a);
         i--;
     }
        System.out.println();
    }

    public static void main(String[] args) {
        homework homework = new homework();
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("1运行2停止");
          int a= scanner.nextInt();
            switch (a){
                case 1:
                    System.out.println("输入一个数字");
                    int num=scanner.nextInt();
                    homework.add(num);
                    break;
                case 2:
                    return;
                    default:
                        homework.add(a);
            }
        }

    }
}
