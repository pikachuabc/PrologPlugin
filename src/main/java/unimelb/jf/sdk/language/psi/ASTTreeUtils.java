package unimelb.jf.sdk.language.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: Fan Jia
 */
public class ASTTreeUtils {
    /**
     * find all matching type AST nodes in a tree with root, null if there is none
     *
     * @param root root node of the AST tree
     * @param type matching type
     * @return ASTNode list or null if there isn't any.
     */
    public static List<ASTNode> findAllByType(ASTNode root, IElementType type) {
        List<ASTNode> result = new ArrayList<>();
        Stack<ASTNode> temp = new Stack<>();
        temp.push(root);
        DFS(type, temp, result);
        return result;
    }

    private static void DFS(IElementType type, Stack<ASTNode> temp, List<ASTNode> result) {
        while (!temp.isEmpty()) {
            ASTNode curNode = temp.pop();
            if (curNode != null) {
                if (curNode.getElementType().equals(type)) {
                    result.add(curNode);
                }
                for (ASTNode node : curNode.getChildren(null)) {
                    temp.push(node);
                }
            }
        }

    }
}
