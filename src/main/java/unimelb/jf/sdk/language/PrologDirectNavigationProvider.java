package unimelb.jf.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.DirectNavigationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import unimelb.jf.sdk.language.psi.ASTTreeUtils;
import unimelb.jf.sdk.language.psi.PrologTypes;

import java.util.List;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologDirectNavigationProvider implements DirectNavigationProvider {
    @Override
    public @Nullable PsiElement getNavigationElement(@NotNull PsiElement element) {
        ASTNode node = element.getNode();
        ASTNode rootNode = node;
        while (rootNode != null && !rootNode.getElementType().toString().equals("FILE")) {
            rootNode = rootNode.getTreeParent();
        }
        // can't find root AST node of this file, weird
        if (rootNode == null) return null;

        if (node.getTreeParent().getElementType() == PrologTypes.REF_PREDICATE_ID) {
            // make sure predicate declaration has same PREDICATE_ID and amount of parameters
            int parameterLength = node.getTreeParent().getTreeNext().getText().split(",").length;
            List<ASTNode> result = ASTTreeUtils.findAllByType(rootNode, PrologTypes.PREDICATE_ID);
            for (ASTNode res : result) {
                if (res.getText().equals(element.getText())
                        && res.getTreeNext().getText().split(",").length == parameterLength) {
                    return res.getPsi();
                }
            }

        }
        return element;
    }
}
