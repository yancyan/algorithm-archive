package com.demo.ds.vo;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

public class BinaryNode <T> {
    @Setter
    @Getter
    private T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T t) {
        this.data = t;
    }

    public static BinaryNode<Integer> create(LinkedList<Integer> input) {
        BinaryNode<Integer> node = null;
        if (input == null || input.isEmpty()) {
            return null;
        }
        Integer arF = input.removeFirst();
        if (arF != null) {
            node = new BinaryNode<>(arF);
            node.left = create(input);
            node.right = create(input);
        }
        return node;
    }
}
