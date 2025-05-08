package org.example.chapter_8.dfs_bfs.bfs;

import org.example.chapter_8.dfs_bfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTreeTraversal {

    public void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

}
