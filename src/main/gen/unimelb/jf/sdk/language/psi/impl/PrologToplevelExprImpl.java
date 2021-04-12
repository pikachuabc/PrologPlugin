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

public class PrologToplevelExprImpl extends ASTWrapperPsiElement implements PrologToplevelExpr {

  public PrologToplevelExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrologVisitor visitor) {
    visitor.visitToplevelExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrologVisitor) accept((PrologVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrologExprBody getExprBody() {
    return findChildByClass(PrologExprBody.class);
  }

  @Override
  @NotNull
  public PrologExprHead getExprHead() {
    return findNotNullChildByClass(PrologExprHead.class);
  }

}
