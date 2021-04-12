// This is a generated file. Not intended for manual editing.
package unimelb.jf.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static unimelb.jf.sdk.language.psi.PrologTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import unimelb.jf.sdk.language.psi.*;

public class PrologCommonValImpl extends ASTWrapperPsiElement implements PrologCommonVal {

  public PrologCommonValImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrologVisitor visitor) {
    visitor.visitCommonVal(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrologVisitor) accept((PrologVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrologCommonPredicate getCommonPredicate() {
    return findChildByClass(PrologCommonPredicate.class);
  }

  @Override
  @Nullable
  public PrologIdent getIdent() {
    return findChildByClass(PrologIdent.class);
  }

  @Override
  @Nullable
  public PrologListConstructor getListConstructor() {
    return findChildByClass(PrologListConstructor.class);
  }

  @Override
  @Nullable
  public PrologLiteral getLiteral() {
    return findChildByClass(PrologLiteral.class);
  }

}
