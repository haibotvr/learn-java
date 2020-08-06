import java.util.ArrayList;
import java.util.List;

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

}
