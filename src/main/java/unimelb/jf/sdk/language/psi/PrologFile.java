package unimelb.jf.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import unimelb.jf.sdk.language.PrologFileType;
import unimelb.jf.sdk.language.PrologLanguage;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologFile extends PsiFileBase {
    public PrologFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PrologLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PrologFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Prolog File";
    }
}
