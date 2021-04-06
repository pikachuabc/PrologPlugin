package unimelb.jf.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;

/**
 * @description:
 * @author: Fan Jia
 */
public abstract class PrologNamedElementImpl extends ASTWrapperPsiElement implements PsiNameIdentifierOwner {
    public PrologNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
