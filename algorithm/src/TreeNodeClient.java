/**
 * @author simon.wei
 */
public class TreeNodeClient {

    /**
     * 遍历二叉树结构
     * 1、前序
     * 2、中序
     * 3、后序
     */

    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        TreeNodeSolution solution = new TreeNodeSolution();
        solution.backOrder(a);
        solution.list.forEach(obj -> System.out.println(obj));
    }
}
