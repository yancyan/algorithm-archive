package com.demo.ds;

import com.demo.ds.vo.BinaryNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树遍历: 层序遍历
 */
public class BinaryTreeLayerTraversal {

    public static void main(String[] args) {

    }

    private void traver(BinaryNode<String> r) {
        Queue<BinaryNode<String>> queue = new ArrayDeque<>();
        if (r == null) {
            return;
        }
        queue.add(r);
        while (!queue.isEmpty()) {
            BinaryNode<String> p = queue.poll();
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }

    }

}
