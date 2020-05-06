package com . mine ;
//what is hashtab,哈希表 . 本质来讲就是一个小型的数据库 . 可以通过其中一个索引找到所有的内容 .
//当然,更重要的是它的时间复杂度室0(1),这依靠的的是对于目标中的数对size的取模.这样就能通过计算直接得到目标位置了

import com.atguigu.hashtab.*;

import java.util.Scanner;


 class HashTabDemo {

    public static void main(String[] args) {

        //创建哈希表
        hashtab hashTab = new hashtab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmp(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}








//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next; //next 默认为 null
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class hashtab {
    //我们完成一个任务,用一个数据结构,实现一个小型的数据库,可以用id差到员工的性别,年龄,地址等等信息
     private EmpLinkedList[] mainArr;
     int size;//散列表大小
    /**
     * 散列表是用数组存储链表实现的,所以我们要在构造函数中构造这样一个结构
     * 但是发现没有链表,所以我们还要先构建链表.
     */
    public hashtab(int size){
        this.size=size;//散列表大小可定义
        this.mainArr=new EmpLinkedList[size];//建造主要的散列表
        for (int i=0;i<size;i++){
            mainArr[i]=new EmpLinkedList();//初始化全部列表
        }
    }

    /**
     * 加入对象
     * @param
     */
    public void add(Emp emp){
        int num=hashfun(emp.id);//算出散列值
        mainArr[num].add(emp);//加入链表中
    }
    /**
     * 找到这个对象
     */
    public void findEmp(int id){
        int num=hashfun(id);
        Emp emp=mainArr[num].get(id);//找到链表中的值
        if(emp!=null){
            System.out.println("有这个雇员");
        }else {
            System.out.println("并没有这个雇员");
        }
    }
    /**
     * 散列,这个步骤就是为了可以从输入的值直接找到一个数组中的位置
     */
    private int hashfun(int id){
        return id%size;
    }
    /**
     * 循环整个散列表
     */
    public void list(){
        for (int i = 0; i <size ; i++) {
            mainArr[i].list();
            System.out.println("第"+i+"行链表 :");
        }
    }

}
//散列表中的链表
class EmpLinkedList{
    private Emp head;//构建一个散列表的头

    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp curEmp=head;//辅助指针
        while(true){
            if (curEmp.next==null){
                break;
            }//找到链表的最后位置
            //向后移动
            curEmp=curEmp.next;
        }
        //加入节点
        curEmp.next=emp;
    }
    public void list(){
        if(head == null) { //说明链表为空
            System.out.println( "链表为空");
            return;
        }
//        System.out.print("第 "+(+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }
   public  Emp get(int id){
        //判断链表是否为空
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
       Emp curEmp = head;
       while(true) {
           if(curEmp.id == id) {//找到
               break;//这时curEmp就指向要查找的雇员
           }
           System.out.println("寻找轨迹"+curEmp);
           //退出
           if(curEmp.next == null) {//说明遍历当前链表没有找到该雇员
               curEmp = null;
               break;
           }
           curEmp = curEmp.next;//以后
       }
       System.out.println(curEmp);
       return curEmp;

   }
}

