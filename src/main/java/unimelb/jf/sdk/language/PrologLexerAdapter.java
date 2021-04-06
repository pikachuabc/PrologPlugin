package unimelb.jf.sdk.language;

import com.intellij.lexer.FlexAdapter;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologLexerAdapter extends FlexAdapter {
    public PrologLexerAdapter() {
        super(new PrologLexer(null));
    }
}
