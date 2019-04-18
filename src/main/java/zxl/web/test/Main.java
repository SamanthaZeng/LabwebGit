package zxl.web.test;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int x,y;
    int val;
}
public class Main {
    List<Integer>res=new ArrayList<Integer>();
    public int initBlood(int n,int m,int array[][]){
       TreeNode root = new TreeNode();
        if(array[n-1][m-1]>0)//其实不可能出现这种情况
            root.val=1+(-array[n-1][m-1]);
        if(array[n-1][m-1]<0)
            root.val=1+(-array[n-1][m-1]);
        root.x=n-1;
        root.y=m-1;
        buildTree(root,array);
        int min=1;
        for(int i=0;i<res.size();i++)
            if(res.get(i)<min)
                min=res.get(i);
        return min;
    }
    public void buildTree(TreeNode root, int array[][]){
        TreeNode left=new TreeNode();
        TreeNode right=new TreeNode();
        int x=root.x;
        int y=root.y;
        int leftval=0;
        int rightval=0;
        //计算从左边走所需值
        if(x!=0){
            if(array[x-1][y]>=0)
                leftval=root.val-array[x-1][y];
            if(array[x-1][y]<0)
                leftval=root.val+array[x-1][y];
            //添加左子树
            if(leftval>=1){
                left.val=leftval;
                left.x=x-1;
                left.y=y;
                if(left.x!=0&&left.y!=0)
                    buildTree(left,array);
                else
                    res.add(leftval);
            }
        }
         //计算从右边走的值
        if(y!=0){
            if(array[x][y-1]>=0)
                leftval=root.val-array[x][y-1];
            if(array[x][y-1]<0)
                leftval=root.val+array[x][y-1];
            //添加右子树
            if(rightval>=1){
                right.val=rightval;
                right.x=x;
                right.y=y-1;
                if(left.x!=0&&left.y!=0)
                    buildTree(right,array);
                else
                    res.add(rightval);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int m ;
       // int map[][];
        int init;
        n = in.nextInt();
        m = in.nextInt();
        int map[][]=new int[n][m];


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                map[i][j]=in.nextInt();
            }
        }
        Main test=new Main();
        init=test.initBlood(n,m,map);
        System.out.println(init);
    }
}
