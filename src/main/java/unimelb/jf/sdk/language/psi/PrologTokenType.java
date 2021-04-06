package unimelb.jf.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import unimelb.jf.sdk.language.PrologLanguage;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologTokenType extends IElementType {
    public PrologTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PrologLanguage.INSTANCE);
    }
    @Override
    public String toString() {
        return "PrologTokenType." + super.toString();
    }
}
