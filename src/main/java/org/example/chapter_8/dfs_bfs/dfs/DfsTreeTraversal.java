package org.example.chapter_8.dfs_bfs.dfs;

import org.example.chapter_8.dfs_bfs.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DfsTreeTraversal {

    public void inorderRecursive(TreeNode root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    public void inorderWithStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {

            // Step 1. Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2. Get root
            current = stack.pop();
            System.out.print(current.val + " ");

            // Step 3. Go to the right
            current = current.right;
        }
    }

    public void preorderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // root → left → right
    public void preorderWithStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            // Step 1. Get root
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            // Step 2. Right first because the stack LIFO (so the left one is processed first)
            if (current.right != null) {
                stack.push(current.right);
            }

            // Step 3. Push left
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void postorderRecursive(TreeNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    public void postorderWithStack(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

}
