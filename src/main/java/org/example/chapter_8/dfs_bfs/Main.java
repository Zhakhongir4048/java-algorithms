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

        System.out.print("Inorder recursive (DFS): ");
        traversalDfs.inorderRecursive(root);
        System.out.println();
        System.out.print("Inorder with stack (DFS): ");
        traversalDfs.inorderWithStack(root);
        System.out.println();

        System.out.print("Preorder recursive (DFS): ");
        traversalDfs.preorderRecursive(root);
        System.out.println();
        System.out.print("Preorder with stack (DFS): ");
        traversalDfs.preorderWithStack(root);
        System.out.println();

        System.out.print("Postorder recursive (DFS): ");
        traversalDfs.postorderRecursive(root);
        System.out.println();
        System.out.print("Postorder with stack (DFS): ");
        traversalDfs.postorderWithStack(root);
        System.out.println();

        System.out.print("Level Order (BFS): ");
        traversalBfs.levelOrder(root);
        System.out.println();
    }

}
