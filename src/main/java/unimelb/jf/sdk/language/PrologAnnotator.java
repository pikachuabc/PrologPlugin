package unimelb.jf.sdk.language;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * @description: annotator level syntax highlight level
 * @author: Fan Jia
 */
public class PrologAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
//        System.out.println("======================================");
//        System.out.println("element text: "+ element.getText());
//        System.out.println("element name: "+ element.toString());
//        System.out.println("element parent text: " + element.getParent().getText());
//        System.out.println("element parent name: " + element.getParent().toString());

        if (element.toString().contains("PREDICATE_ID") && !element.toString().contains("REF_PREDICATE_ID")) {
            // predicate declaration highlight
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION).create();
        } else if (element.toString().contains("REF_PREDICATE_ID") && element.getNextSibling() != null && element.getNextSibling().toString().contains("PARAMETER_LIST")) {
            // predicate referenced highlight
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(DefaultLanguageHighlighterColors.STATIC_METHOD).create();
        }
    }
}
