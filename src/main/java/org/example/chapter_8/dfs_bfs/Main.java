package org.example.chapter_8.dfs_bfs;

import org.example.chapter_8.dfs_bfs.bfs.BfsTreeTraversal;
import org.example.chapter_8.dfs_bfs.dfs.DfsTreeTraversal;

public class Main {

    public static void main(String[] args) {
        // Создаём дерево:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        DfsTreeTraversal traversalDfs = new DfsTreeTraversal();
        BfsTreeTraversal traversalBfs = new BfsTreeTraversal();

        System.out.print("Inorder (DFS): ");
        traversalDfs.inorder(root);
        System.out.println();

        System.out.print("Preorder (DFS): ");
        traversalDfs.preorder(root);
        System.out.println();

        System.out.print("Postorder (DFS): ");
        traversalDfs.postorder(root);
        System.out.println();

        System.out.print("Level Order (BFS): ");
        traversalBfs.levelOrder(root);
        System.out.println();
    }

}
