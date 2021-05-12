package com.simon.learn;


import java.util.ArrayList;
import java.util.List;

/**
 * @author simon.wei
 */
public class SerializeOperation {

    /**
     * 给定一个树结构，序列化成字符串再反序列化成树
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode("1");
        TreeNode root_2 = new TreeNode("2");
        TreeNode root_3 = new TreeNode("3");
        root.left = root_2;
        root.right = root_3;
        TreeNode root_4 = new TreeNode("4");
        TreeNode root_5 = new TreeNode("5");
        root_3.left = root_4;
        root_3.right = root_5;

        SerializeOperation operation = new SerializeOperation();
        String serialize = operation.serialize(root);
        System.out.println(serialize);
        TreeNode treeNode = operation.deSerialize(serialize);
        System.out.println(treeNode);
    }

    /**
     * 序列化方法
     */
    public String serialize(TreeNode root) {
        if(root == null) {
            return "[]";
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        //[1,2,3,null,null,4,5,null,null,null,null]
        for(int i = 0; i < queue.size(); i++) {
            if(queue.get(i) == null) {
                continue;
            }
            queue.add(queue.get(i).left);
            queue.add(queue.get(i).right);
        }
        for(int i = queue.size() - 1; i >= 0; i--) {
            if(queue.get(i) == null) {
                queue.remove(i);
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if(queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append("," + queue.get(i).val);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反序列化方法
     */
    public TreeNode deSerialize(String data) {
        if(data == null || data.equals("[]")) {
            return null;
        }
        String[] datas = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(datas[0]);
        nodes.add(root);
        boolean isLeft = true;
        int index = 0;
        //2,3,#,#,4,5
        for (int i = 1; i < datas.length; i++) {
            if(!datas[i].equals("#")) {
                TreeNode leaf = new TreeNode(datas[i]);
                if(isLeft) {
                    nodes.get(index).left = leaf;
                } else {
                    nodes.get(index).right = leaf;
                }
                nodes.add(leaf);
            }
            if(!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }

}
