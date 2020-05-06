package com . mine ;
//what is hashtab,��ϣ�� . ������������һ��С�͵����ݿ� . ����ͨ������һ�������ҵ����е����� .
//��Ȼ,����Ҫ��������ʱ�临�Ӷ���0(1),�������ĵ��Ƕ���Ŀ���е�����size��ȡģ.��������ͨ������ֱ�ӵõ�Ŀ��λ����

import com.atguigu.hashtab.*;

import java.util.Scanner;


 class HashTabDemo {

    public static void main(String[] args) {

        //������ϣ��
        hashtab hashTab = new hashtab(7);

        //дһ���򵥵Ĳ˵�
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  ��ӹ�Ա");
            System.out.println("list: ��ʾ��Ա");
            System.out.println("find: ���ҹ�Ա");
            System.out.println("exit: �˳�ϵͳ");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("����id");
                    int id = scanner.nextInt();
                    System.out.println("��������");
                    String name = scanner.next();
                    //���� ��Ա
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("������Ҫ���ҵ�id");
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








//��ʾһ����Ա
class Emp {
    public int id;
    public String name;
    public Emp next; //next Ĭ��Ϊ null
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
    //�������һ������,��һ�����ݽṹ,ʵ��һ��С�͵����ݿ�,������id�Ա�����Ա�,����,��ַ�ȵ���Ϣ
     private EmpLinkedList[] mainArr;
     int size;//ɢ�б��С
    /**
     * ɢ�б���������洢����ʵ�ֵ�,��������Ҫ�ڹ��캯���й�������һ���ṹ
     * ���Ƿ���û������,�������ǻ�Ҫ�ȹ�������.
     */
    public hashtab(int size){
        this.size=size;//ɢ�б��С�ɶ���
        this.mainArr=new EmpLinkedList[size];//������Ҫ��ɢ�б�
        for (int i=0;i<size;i++){
            mainArr[i]=new EmpLinkedList();//��ʼ��ȫ���б�
        }
    }

    /**
     * �������
     * @param
     */
    public void add(Emp emp){
        int num=hashfun(emp.id);//���ɢ��ֵ
        mainArr[num].add(emp);//����������
    }
    /**
     * �ҵ��������
     */
    public void findEmp(int id){
        int num=hashfun(id);
        Emp emp=mainArr[num].get(id);//�ҵ������е�ֵ
        if(emp!=null){
            System.out.println("�������Ա");
        }else {
            System.out.println("��û�������Ա");
        }
    }
    /**
     * ɢ��,����������Ϊ�˿��Դ������ֱֵ���ҵ�һ�������е�λ��
     */
    private int hashfun(int id){
        return id%size;
    }
    /**
     * ѭ������ɢ�б�
     */
    public void list(){
        for (int i = 0; i <size ; i++) {
            mainArr[i].list();
            System.out.println("��"+i+"������ :");
        }
    }

}
//ɢ�б��е�����
class EmpLinkedList{
    private Emp head;//����һ��ɢ�б��ͷ

    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp curEmp=head;//����ָ��
        while(true){
            if (curEmp.next==null){
                break;
            }//�ҵ���������λ��
            //����ƶ�
            curEmp=curEmp.next;
        }
        //����ڵ�
        curEmp.next=emp;
    }
    public void list(){
        if(head == null) { //˵������Ϊ��
            System.out.println( "����Ϊ��");
            return;
        }
//        System.out.print("�� "+(+" �������ϢΪ");
        Emp curEmp = head; //����ָ��
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//˵��curEmp�Ѿ��������
                break;
            }
            curEmp = curEmp.next; //���ƣ�����
        }
        System.out.println();
    }
   public  Emp get(int id){
        //�ж������Ƿ�Ϊ��
        if(head==null){
            System.out.println("����Ϊ��");
            return null;
        }
       Emp curEmp = head;
       while(true) {
           if(curEmp.id == id) {//�ҵ�
               break;//��ʱcurEmp��ָ��Ҫ���ҵĹ�Ա
           }
           System.out.println("Ѱ�ҹ켣"+curEmp);
           //�˳�
           if(curEmp.next == null) {//˵��������ǰ����û���ҵ��ù�Ա
               curEmp = null;
               break;
           }
           curEmp = curEmp.next;//�Ժ�
       }
       System.out.println(curEmp);
       return curEmp;

   }
}

