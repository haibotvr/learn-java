import com.simon.learn.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author simon.wei
 */
public class TreeNodeSolution {

    public List<String> list = new ArrayList<>();

    public void preOrder(TreeNode root){
        if(root != null){
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    public void backOrder(TreeNode root){
        if(root != null){
            backOrder(root.left);
            backOrder(root.right);
            list.add(root.val);
        }
    }

    public List<String> preOrderRecursion(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        List<String> left = preOrderRecursion(root.left);
        List<String> right = preOrderRecursion(root.right);
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    public void preOrderNoRecursion(TreeNode root) {
        if(root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrderNoRecursion(TreeNode root) {
        if(root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
    }

    public void postOrderNoRecursion(TreeNode root) {
        if(root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if(current.left == null && current.right == null) {
                list.add(stack.pop().val);
            }
            if(current.right != null) {
                stack.push(current.right);
                current.right = null;
            }
            if(current.left != null) {
                stack.push(current.left);
                current.left = null;
            }
        }
    }

    public void postOrderNoRecursion2(TreeNode root) {
        if(root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.peek();
            if(prev == null || prev.left == current || prev.right == current) {
                if(current.left != null) {
                    stack.push(current.left);
                } else if(current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) {
                if(current.right != null) {
                    stack.push(current.right);
                }
            } else {
                list.add(current.val);
                stack.pop();
            }

            prev = current;
        }
    }
}
