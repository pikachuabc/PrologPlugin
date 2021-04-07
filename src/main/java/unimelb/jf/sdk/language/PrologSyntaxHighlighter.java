package unimelb.jf.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import unimelb.jf.sdk.language.psi.PrologTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @description: .flex level syntax highlighter
 * @author: Fan Jia
 */
public class PrologSyntaxHighlighter extends SyntaxHighlighterBase {

    //DefaultLanguageHighlighterColors.XXX just color styles, doesn't must have to match its meaning.

    public static final TextAttributesKey UNIFY =
            createTextAttributesKey("UNIFY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LB =
            createTextAttributesKey("LB", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey RB =
            createTextAttributesKey("RB", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey ATOM =
            createTextAttributesKey("ATOM", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey COMMA =
            createTextAttributesKey("COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey DOT =
            createTextAttributesKey("DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);



    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] UNIFY_KEYS = new TextAttributesKey[]{UNIFY};
    private static final TextAttributesKey[] LB_KEYS = new TextAttributesKey[]{LB};
    private static final TextAttributesKey[] RB_KEYS = new TextAttributesKey[]{RB};
    private static final TextAttributesKey[] ATOM_KEYS = new TextAttributesKey[]{ATOM};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PrologLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {

        if (tokenType.equals(PrologTypes.UNIFY)) {
            return UNIFY_KEYS;
        } else if (tokenType.equals(PrologTypes.ATOM)) {
            return ATOM_KEYS;
        } else if (tokenType.equals(PrologTypes.LB)) {
            return LB_KEYS;
        } else if (tokenType.equals(PrologTypes.RB)) {
            return RB_KEYS;
        } else if (tokenType.equals(PrologTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(PrologTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(PrologTypes.DOT)) {
            return DOT_KEYS;
        } else if (tokenType.equals(PrologTypes.STRING)) {
            return STRING_KEYS;
        }else if (tokenType.equals(PrologTypes.INTEGER) || tokenType.equals(PrologTypes.FLOAT)) {
            return NUMBER_KEYS;
        }else {
            return EMPTY_KEYS;
        }
    }
}
