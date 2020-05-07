package com.mine.tree.threadedbinarytree;

public class ThreadBinaryTreeDemo {
}


class HeroNode {
    //�����������Ľڵ�Ҫ�� ֵ,���ҽڵ�,���ҽڵ��ʶ
    private int val;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //��ʶ
    private int leftType;
    private int rightType;


    //���캯��
    public HeroNode(String name, int val) {
        this.name = name;
        this.val = val;
    }
//ǰ�����
    public void preOrder(HeroNode root){
        if (root==null)return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //�������
    public void middleOrder(HeroNode root){
        if (root==null)return;
        middleOrder(root.left);
        System.out.println(root.val);
        middleOrder(root.right);
    }
    //ɾ���ڵ�
    public void delNode(HeroNode root,int target){
        if(root.right!=null&&root.right.val==target){
            root.right=null;
        }
        if(root.left!=null&&root.left.val==target){
            root.left=null;
        }
        if(root==null)return;
        if(root.left!=null) {
            delNode(root.left, target);
        }
        if(root.right!=null) {
            delNode(root.right, target);
        }
    }
    //�������


    //���¶����Զ����ɵ�get,set����,Ϊ���������������һ��{},�ǵ�ȥ��

        @Override
        public String toString () {
        return "HeroNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

        public int getVal () {
        return val;
    }

        public void setVal ( int val){
        this.val = val;
    }

        public HeroNode getLeft () {
        return left;
    }

        public void setLeft (HeroNode left){
        this.left = left;
    }

        public HeroNode getRight () {
        return right;
    }

        public void setRight (HeroNode right){
        this.right = right;
    }

        public int getLeftType () {
        return leftType;
    }

        public void setLeftType ( int leftType){
        this.leftType = leftType;
    }

        public int getRightType () {
        return rightType;
    }

        public void setRightType ( int rightType){
        this.rightType = rightType;
    }

}
class threadBinaryTree{
    HeroNode root;//��Ҫ�ڵ�
    HeroNode pre=null;//ǰ��ڵ�
    //���캯��,�����������
    public threadBinaryTree(HeroNode node){
        this.root=node;
    }
    //���л�
    public void threadBinary(HeroNode node){
        //�õݹ���ʵ��
        threadBinary(node.getLeft());
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null&&pre.getLeft()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }



        pre=root;
        threadBinary(node.getRight());

    }
//����������
    public void threadlist(HeroNode node){
        while(node!=null){
            //һֱ�������������ڵ�
            while(node.getLeft()!=null){
                node=node.getLeft();
            }
            while(node.getRightType()==1)
                node=node.getRight();
            node=node.getRight();
        }
    }



}