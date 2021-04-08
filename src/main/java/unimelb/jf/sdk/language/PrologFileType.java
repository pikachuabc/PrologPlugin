package unimelb.jf.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologFileType extends LanguageFileType {

    public static final PrologFileType INSTANCE = new PrologFileType();

    private PrologFileType() {
        super(PrologLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Prolog File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Prolog language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PrologIcons.FILE;
    }
}
