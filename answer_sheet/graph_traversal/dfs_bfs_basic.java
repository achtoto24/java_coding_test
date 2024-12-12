package java_coding_test.answer_sheet.graph_traversal;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

class Queue<T> {
}

class Graph {
    class Node {
        int data;
        LinkdedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data =data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        nodes[i] = new Node(i);
    }
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contatins(n2)) n1.adjacent.add(n2);
        if (!n2.adjacent.contatins(n1)) n2.adjacent.add(n1);
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();

        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                stack.push(n);
                n.marked = true;
            }
            visit(r);
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

}

public class dfs_bfs_basic {
    public static void main(String[] args) {
        
    }
}
