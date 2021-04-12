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

public class PrologEquivBinaryImpl extends ASTWrapperPsiElement implements PrologEquivBinary {

  public PrologEquivBinaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrologVisitor visitor) {
    visitor.visitEquivBinary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrologVisitor) accept((PrologVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrologArithmeticEval getArithmeticEval() {
    return findChildByClass(PrologArithmeticEval.class);
  }

  @Override
  @Nullable
  public PrologLogicalAnd getLogicalAnd() {
    return findChildByClass(PrologLogicalAnd.class);
  }

  @Override
  @Nullable
  public PrologLogicalEqual getLogicalEqual() {
    return findChildByClass(PrologLogicalEqual.class);
  }

  @Override
  @Nullable
  public PrologLogicalNot getLogicalNot() {
    return findChildByClass(PrologLogicalNot.class);
  }

}
