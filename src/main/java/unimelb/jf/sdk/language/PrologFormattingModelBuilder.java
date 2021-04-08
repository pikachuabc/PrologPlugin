package unimelb.jf.sdk.language;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import unimelb.jf.sdk.language.psi.PrologTypes;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, PrologLanguage.INSTANCE)
                .before(PrologTypes.UNIFY)
                .spaces(1)
                .after(PrologTypes.UNIFY)
                .lineBreakInCode();

    }

    @NotNull
    @Override
    public FormattingModel createModel(FormattingContext formattingContext) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new PrologBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(formattingContext.getCodeStyleSettings()),false),
                        formattingContext.getCodeStyleSettings());
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
