package com.demo.dat.structure;

import java.util.LinkedList;

/*
Depth First Search(DFS)
回溯，就是自后向前，追溯曾经走过的路径
可以利用栈的先入后出，也可使用递归的方式（基于方法调用栈实现）

Breadth First Search(BFS)
重放，把遍历过的顶点按照之前的遍历顺序重新回顾，就叫做重放。
同样的，要实现重放也需要额外的存储空间，可以利用队列的先入先出特性来实现。


 */
public class Graph {


    public static void main(String[] args) {

        GraphC graph = new GraphC(6);


        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);


        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);


        graph.adj[2].add(0);
        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);


        System.out.println("图的深度优先遍历：");

//        dfs(graph, 0, new boolean[graph.size]);


        System.out.println("图的广度优先遍历：");

//        bfs(graph, 0, new boolean[graph.size], new LinkedList<Integer>());
    }


    static class Vertex {
        int data;

        Vertex(int data) {
            this.data = data;
        }
    }

    private static class GraphC {
        private int size;
        private Vertex[] vertices;
        private LinkedList<Integer> adj[];

        GraphC(int size) {
            this.size = size;
            vertices = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = new Vertex(i);
                adj[i] = new LinkedList<>();
            }


        }

    }
}
