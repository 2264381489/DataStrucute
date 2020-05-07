package com.mine.tree.threadedbinarytree;

public class ThreadBinaryTreeDemo {
}


class HeroNode {
    //线索二叉树的节点要有 值,左右节点,左右节点标识
    private int val;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //标识
    private int leftType;
    private int rightType;


    //构造函数
    public HeroNode(String name, int val) {
        this.name = name;
        this.val = val;
    }
//前序遍历
    public void preOrder(HeroNode root){
        if (root==null)return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public void middleOrder(HeroNode root){
        if (root==null)return;
        middleOrder(root.left);
        System.out.println(root.val);
        middleOrder(root.right);
    }
    //删除节点
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
    //先序查找


    //往下都是自动生成的get,set方法,为了整理在外面加了一个{},记得去掉

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
    HeroNode root;//主要节点
    HeroNode pre=null;//前序节点
    //构造函数,处理这个问题
    public threadBinaryTree(HeroNode node){
        this.root=node;
    }
    //序列化
    public void threadBinary(HeroNode node){
        //用递归来实现
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
//线索化遍历
    public void threadlist(HeroNode node){
        while(node!=null){
            //一直走左子树到根节点
            while(node.getLeft()!=null){
                node=node.getLeft();
            }
            while(node.getRightType()==1)
                node=node.getRight();
            node=node.getRight();
        }
    }



}