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

public class PrologCommonPredicateImpl extends ASTWrapperPsiElement implements PrologCommonPredicate {

  public PrologCommonPredicateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrologVisitor visitor) {
    visitor.visitCommonPredicate(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrologVisitor) accept((PrologVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrologParameterList getParameterList() {
    return findChildByClass(PrologParameterList.class);
  }

  @Override
  @NotNull
  public PrologRefPredicateId getRefPredicateId() {
    return findNotNullChildByClass(PrologRefPredicateId.class);
  }

}
