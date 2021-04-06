package unimelb.jf.sdk.language;

import com.intellij.lang.Language;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologLanguage extends Language {
    public static final PrologLanguage INSTANCE = new PrologLanguage();
    private PrologLanguage() {
        super("Prolog");
    }
}
