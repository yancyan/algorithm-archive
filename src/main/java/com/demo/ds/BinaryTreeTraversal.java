package com.demo.ds;

import com.demo.ds.vo.BinaryNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树遍历:前序、中序、后序遍历
 * 递归及非递归实现，
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        LinkedList<Integer> inputs = new LinkedList<>(Arrays.asList(3, 2, 9, null,
                null, 10, null, null, 8, null, 4));

        BinaryNode<Integer> root = BinaryNode.create(inputs);
        preorder(root);
        System.out.println("##################");
        preorderTraverse(root);

    }


    private static void preorder(BinaryNode<Integer> p) {
        if (p != null) {
            System.out.print("data: " + p.getData());
            preorder(p.left);
            preorder(p.right);
        }
    }

    private static void preorderTraverse(BinaryNode<Integer> root) {
        Stack<BinaryNode<Integer>> binaryNodes = new Stack<>();

        BinaryNode<Integer> p = root;
        while (p != null || !binaryNodes.isEmpty()) {
            if (p != null) {
                System.out.print("the current node data: " + p.getData());
                binaryNodes.push(p.left);
                p = p.left;
            } else {
                System.out.println("^.");
                p = binaryNodes.pop();
                p = p.right;
            }
        }
        System.out.println("^");
    }

    private static void inorder(BinaryNode<Integer> p) {
        if (p != null) {
            preorder(p.left);
            System.out.println("data: " + p.getData());
            preorder(p.right);
        }
    }

    private void inorderTraverse(BinaryNode<Integer> root) {
        Stack<BinaryNode<Integer>> binaryNodes = new Stack<>();
        BinaryNode<Integer> p = root;
        while (p != null || !binaryNodes.isEmpty()) {
            if (p != null) {
                binaryNodes.push(p.left);
                p = p.left;
            } else {
                System.out.println("^.");
                p = binaryNodes.pop();
                System.out.println("the current node data: " + p.getData());
                p = p.right;
            }
        }
        System.out.println("^");
    }

    private static void postorder(BinaryNode<Integer> p) {
        if (p != null) {
            preorder(p.left);
            preorder(p.right);
            System.out.println("data: " + p.getData());
        }
    }

    private void postorderTraverse(BinaryNode<Integer> root) {
        Stack<BinaryNode<Integer>> binaryNodes = new Stack<>();
        Stack<BinaryNode<Integer>> output = new Stack<>();

        BinaryNode<Integer> p = root;

        while (p != null || !binaryNodes.isEmpty()) {
            if (p != null) {
                binaryNodes.push(p);
                output.push(p);
                p = p.right;
            } else {
                output.push(new BinaryNode<>(null));
                p = binaryNodes.pop();
                p = p.left;
            }
        }

        while (!output.isEmpty()) {
            BinaryNode<Integer> pop = output.pop();
            if (pop.getData() == null) {
                System.out.println("^");
            } else {
                System.out.println("the current node data: " + pop.getData());
            }
        }
    }
}
