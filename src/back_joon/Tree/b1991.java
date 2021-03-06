package back_joon.Tree;
import java.util.*;

class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
    }
}

class Tree{
    Node root;

    public void createNode(char data,char leftData,char rightData){
        if(root == null){
            root = new Node(data);

            if(leftData != '.'){
                root.left = new Node(leftData);
            }
            if(rightData != '.'){
                root.right = new Node(rightData);
            }
        }else{
            searchNode(root,data,leftData,rightData);
        }
    }

    public void searchNode(Node root,char data,char leftData,char rightData){
        if(root == null){
            return;
        }else if(root.data == data){
            if(leftData != '.'){
                root.left = new Node(leftData);
            }
            if(rightData != '.'){
                root.right = new Node(rightData);
            }
        }else{
            searchNode(root.left,data,leftData,rightData);
            searchNode(root.right,data,leftData,rightData);
        }
    }

    public void preorder(Node root){
        System.out.print(root.data);
        if(root.left != null){
            preorder(root.left);
        }
        if(root.right != null){
            preorder(root.right);
        }
    }

    public void inorder(Node root){
        if(root.left != null){
            inorder(root.left);
        }
        System.out.print(root.data);
        if(root.right != null){
            inorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root.left != null){
            postorder(root.left);
        }
        if(root.right != null){
            postorder(root.right);
        }
        System.out.print(root.data);
    }
}
public class b1991 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Tree tree = new Tree();

        for(int i=0;i<N;i++){
            char c1 = sc.next().charAt(0);
            char c2 = sc.next().charAt(0);
            char c3 = sc.next().charAt(0);
            tree.createNode(c1,c2,c3);
        }

        tree.preorder(tree.root);
        System.out.println();

        tree.inorder(tree.root);
        System.out.println();

        tree.postorder(tree.root);
        System.out.println();

    }
}
