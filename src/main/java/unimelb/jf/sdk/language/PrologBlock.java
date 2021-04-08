package unimelb.jf.sdk.language;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import unimelb.jf.sdk.language.psi.PrologTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Fan Jia
 */
public class PrologBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private final boolean needIndent;

    protected PrologBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                          SpacingBuilder spacingBuilder, boolean needIndent) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
        this.needIndent = needIndent;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();

        while (child != null) {
            if (child.getElementType() == PrologTypes.TOPLEVEL_EXPR) {
                ASTNode expHead = child.findChildByType(PrologTypes.EXPR_HEAD);
                ASTNode expBody = child.findChildByType(PrologTypes.EXPR_BODY);
                ASTNode UNIFY = child.findChildByType(PrologTypes.UNIFY);
                if (expHead != null) {
                    Block block = new PrologBlock(expHead, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                            spacingBuilder, false);
                    blocks.add(block);
                }
                if (UNIFY != null) {
                    Block block1 = new PrologBlock(UNIFY, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                            spacingBuilder, false);
                    blocks.add(block1);
                }
                if (expBody != null) {
//                    ASTNode[] nodes = expBody.getChildren(null);
//                    for (ASTNode node : nodes) {
//                        Block temp = new PrologBlock(node, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
//                                spacingBuilder, true);
//                        blocks.add(temp);
//                    }
                    Block block1 = new PrologBlock(expBody, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                            spacingBuilder, true);
                    blocks.add(block1);
                }

            } else if (child.getElementType() == PrologTypes.DOT) {
                Block block1 = new PrologBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                        spacingBuilder, false);
                blocks.add(block1);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        return needIndent ? Indent.getNormalIndent() : Indent.getNoneIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}
